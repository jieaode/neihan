package com.jieaode.neihan.test;

import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import cn.sharesdk.framework.authorize.a;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.jieaode.neihan.R;
import com.jieaode.neihan.bean.Comment;
import com.jieaode.neihan.bean.CommentList;
import com.jieaode.neihan.bean.EntityList;
import com.jieaode.neihan.bean.TestEntity;
import com.jieaode.neihan.client.ClientAPI;

/**
 * 这个文件时一个测试入口，所有的测试内容都可以放在这里
 * 
 * @author FCB-MESSI
 * 
 */
public class TestActivity extends Activity implements Response.Listener<String> {
	private Button button, button2;
	private int offset = 0;
	private long lastTime;
	/**
	 * 分类id代表文本
	 */
	public static final int CATEGORY_TEST = 1;
	/**
	 * 分类id代表图片
	 */
	public static final int CATEGORY_IMAGE = 2;
	private RequestQueue queue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		int itemCount = 30;
		queue = Volley.newRequestQueue(this);
		button = (Button) this.findViewById(R.id.button1);
		//button2 = (Button) this.findViewById(R.id.button2);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ClientAPI.getList(queue, CATEGORY_TEST, 30, lastTime,
						TestActivity.this);
			}
		});
		long groupId = 3551461874l;
		// offset = 0;
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ClientAPI.getComment(queue, 3551461874l, offset,
						TestActivity.this);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	/*
	 * 列表网络获取回调部分
	 * 
	 * @param arg0 列表JSON字符串
	 */

	public void listonResponse(String arg0) {
		// TODO Auto-generated method stub
		Log.i("TestActivity", "List" + arg0);
		try {
			JSONObject json = new JSONObject(arg0);
			// arg0 = json.toString(4);
			// System.out.println("list" + arg0);
			// 获取根节点下的data对象
			JSONObject obj = json.getJSONObject("data");
			// 解析段子列表的完整数据
			EntityList entityList = new EntityList();
			// 这个方法是解析JSON的方法，其中包含支持图片，文本，广告的解析
			entityList.parseJson(obj);// 相当于获取数据内容

			// 如果isHasMore返回true，代表还可以更新一次数据
			if (entityList.isHasMore()) {
				lastTime = entityList.getMinTime();// 获取更新时间标识
				Log.i("<<<<<<", "<<<" + lastTime);
			} else {
				// 没有更多的数据了，休息一会儿
				String tip = entityList.getTip();
				Log.d(">>>>", "tip" + tip);
			}

			// ImageEntity imageEntity = new ImageEntity();
			// imageEntity.parseJson(item);
			// 获取段子内容列表
			// List<TestEntity> entities = entityList.getEntities();
			// TODO 把entityList这个段子的数据集合体，传递给ListView之类的Adapter即可显示
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		try {
			JSONObject json = new JSONObject(arg0);
			arg0 = json.toString(4);
			// Iterator<String> keys = json.keys();
			// while (keys.hasNext()) {
			// String key = keys.next();
			// Log.d("","JSON key"+key);
			// }
			// 解析获取到的评论列表
			CommentList commentList = new CommentList();
			// 评论列表包含两组数据，一个是热门评论，一个是新鲜评论
			// 热门和新鲜评论都有可能是空的
			commentList.parseJson(json);
			// 评论总数
			int totalNumber = commentList.getTotalNumber();
			long groupId = commentList.getGroupId();
			//表示是否要继续加载
			boolean hasMore = commentList.isHasMore();
			// 热门评论列表（可能为空，第一次offset为0时可能有数据）
			List<Comment> topComments = commentList.getTopComments();
			// 新鲜评论，可能有数据
			List<Comment> recentComments = commentList.getRecetentComments();
			if (topComments != null) {
				for (Comment comment : topComments) {
					Log.d("", "" + comment.getText());
				}
			}
			if (recentComments != null) {
				for (Comment comment : topComments) {
					Log.d("", "" + comment.getText());
				}
			}

			

			Log.d("TestActivity", "Comment groupId" + groupId);
			Log.d("TestActivity", "Comment hasMore" + hasMore);
			// TODO 直接把CommentList提交给ListView的Adapter，这样可以进行是否还有内容的判断
			// 利用Adapter更新数据
			
			//分页标识，要求服务器每次返回20条评论，通过hasMore来判断是否还有内容的判断
			offset += 20;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
