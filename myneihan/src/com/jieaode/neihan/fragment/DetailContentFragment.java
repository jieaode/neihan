package com.jieaode.neihan.fragment;

import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import pl.droidsonroids.gif.GifImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.Volley;
import com.jieaode.neihan.R;
import com.jieaode.neihan.R.id;
import com.jieaode.neihan.adapter.CommentAdapter;
import com.jieaode.neihan.bean.Comment;
import com.jieaode.neihan.bean.CommentList;
import com.jieaode.neihan.bean.TestEntity;
import com.jieaode.neihan.bean.UserEntity;
import com.jieaode.neihan.client.ClientAPI;

import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailContentFragment extends Fragment implements OnTouchListener,
		Listener<String> {
	private TestEntity entity;
	private ScrollView scrollView;
	private TextView txtHotCommentCount;
	private ListView hotCommentListView;
	private TextView txtrecentCommentCount;
	private ListView recentCommentListView;
	private RequestQueue queue;
	private int offset = 0;
	private LinearLayout scrollContent;

	public DetailContentFragment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		queue = Volley.newRequestQueue(getActivity());
		if (entity == null) {
			Bundle arguments = getArguments();
			Serializable serializable = arguments.getSerializable("entity");
			if (serializable instanceof TestEntity) {
				entity = (TestEntity) serializable;
			}
		}
	}

	private CommentAdapter hotAdapter;
	private CommentAdapter recentAdapter;
	private List<Comment> hotComments;

	private List<Comment> recentComments;
	private boolean hasMore;
	private long groupId;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View ret = inflater.inflate(R.layout.fragment_detail_content,
				container, false);
		scrollView = (ScrollView) ret.findViewById(R.id.detail_scroll);
		scrollContent = (LinearLayout)ret.findViewById(R.id.scroll_content);
		scrollView.setOnTouchListener(this);
		// 设置主题内容
		setEssayContet(ret);

		txtHotCommentCount = (TextView) ret
				.findViewById(R.id.text_hot_comment_count);

		hotCommentListView = (ListView) ret.findViewById(R.id.hot_comment_list);

		hotComments = new LinkedList<Comment>();

		hotAdapter = new CommentAdapter(getActivity(), hotComments);
		hotCommentListView.setAdapter(hotAdapter);

		txtrecentCommentCount = (TextView) ret
				.findViewById(R.id.text_recent_comment_count);

		recentCommentListView = (ListView) ret
				.findViewById(R.id.recent_comment_list);
		recentComments = new LinkedList<Comment>();

		recentAdapter = new CommentAdapter(getActivity(), recentComments);
		hotCommentListView.setAdapter(recentAdapter);
		groupId = entity.getGroupId();
		ClientAPI.getComment(queue, groupId, 0, this);

		// if (entity!=null) {
		// UserEntity user = entity.getUserEntity();
		// if (user!=null) {
		// String avatarUrl = user.getAvatarUrl();
		// String nick = user.getName();
		//
		// TextView txtNick = (TextView)
		// }
		// }
		return ret;
	}

	private void setEssayContet(View ret) {
		// 先设置文本内容的数据
		TextView btnGifPlay = (TextView) ret.findViewById(R.id.btnGifPlay);
		ImageButton btnShare = (ImageButton) ret.findViewById(R.id.item_share);
		CheckBox chbBuryCount = (CheckBox) ret
				.findViewById(R.id.item_bury_count);
		CheckBox chbDiggCount = (CheckBox) ret
				.findViewById(R.id.item_digg_count);
		GifImageView gifImageView = (GifImageView) ret
				.findViewById(R.id.gifView);
		ImageView imgProfileImage = (ImageView) ret
				.findViewById(R.id.item_profile_image);
		ProgressBar pbDownloadProgressBar = (ProgressBar) ret
				.findViewById(R.id.item_image_download_progress);
		TextView txtCommentCount = (TextView) ret
				.findViewById(R.id.item_comment_count);
		TextView txtContent = (TextView) ret.findViewById(R.id.item_content);
		TextView txtProfileNick = (TextView) ret
				.findViewById(R.id.item_profile_nick);

		UserEntity user = entity.getUserEntity();
		String nick = "";
		if (user != null) {
			nick = user.getName();
		}
		txtProfileNick.setText(nick);

		String content = entity.getContent();
		txtContent.setText(content);

		int diggCount = entity.getDiggCount();

		chbDiggCount.setText(Integer.toString(diggCount));

		int userDigg = entity.getUserDigg();// 当前用户是否赞过；
		// 如果userDiggCount是1的话，代表了已经赞过，那么chbDiggCount必出禁用，所以用!+1;
		chbDiggCount.setEnabled(userDigg != 1);

		int buryCount = entity.getBuryCount();

		chbBuryCount.setText(Integer.toString(buryCount));

		int userBury = entity.getUserBury();
		// rguserBury是1的话，代表了已经踩过，那么chbBuryCount必须禁用，所以用！=1;
		chbBuryCount.setEnabled(userBury != 1);

		int commentCount = entity.getCommentCount();

		txtCommentCount.setText(Integer.toString(commentCount));
		// 设置图片内容的数据
	}

	/**
	 * 处理scorllview的触摸事件，用于在scrollview滚动到最下面时，自动加载数据
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		boolean bret  =false;
		int action = event.getAction();
		if (action== MotionEvent.ACTION_DOWN) {
			bret = true;
			hasMore = false;
		}else if (action == MotionEvent.ACTION_MOVE) {
			hasMore = true;
		
		
		
		}else if (action == MotionEvent.ACTION_UP) {
			if (hasMore) {
				
				
				int sy = scrollView.getScrollY();
				
				int mh =   scrollView.getMeasuredHeight();
				int ch = scrollContent.getHeight();
				if (sy+mh>=ch) {
					//TODO进行评论分页加载
					ClientAPI.getComment(queue, groupId, offset, this);
					
				}
				
				
			}
		}
		
		
		return false;
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
			// long groupId = commentList.getGroupId();
			hasMore = commentList.isHasMore();
			// 热门评论列表（可能为空，第一次offset为0时可能有数据）
			List<Comment> topComments = commentList.getTopComments();
			// 新鲜评论，可能有数据
			List<Comment> rtComments = commentList.getRecetentComments();
			if (topComments != null) {
				hotComments.addAll(topComments);
			}
			if (rtComments != null) {
				recentComments.addAll(rtComments);
			}

			Log.d("TestActivity", "Comment groupId" + groupId);
			Log.d("TestActivity", "Comment hasMore" + hasMore);
			// TODO 直接把CommentList提交给ListView的Adapter，这样可以进行是否还有内容的判断
			// 利用Adapter更新数据

			// 分页标识，要求服务器每次返回20条评论，通过hasMore来判断是否还有内容的判断
			offset += 20;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
