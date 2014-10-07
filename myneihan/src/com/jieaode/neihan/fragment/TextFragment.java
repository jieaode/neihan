package com.jieaode.neihan.fragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jieaode.neihan.EssayDetailActivity;
import com.jieaode.neihan.R;
import com.jieaode.neihan.adapter.EssayAdapter;
import com.jieaode.neihan.bean.DataStore;
import com.jieaode.neihan.bean.EntityList;
import com.jieaode.neihan.bean.TestEntity;
import com.jieaode.neihan.client.ClientAPI;

import android.R.anim;
import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 1.列表界面，第一次启动，并且数据为空的时候，自动加载数据 2.只要列表没有数据，进入这个界面时，就尝试加载数据 3.只要有数据，就不进行数据的加载
 * 4.进入这个界面，并且有数据的情况下，尝试检查新信息的个数
 * 
 * @author FCB-MESSI
 * 
 */
public class TextFragment extends Fragment implements OnClickListener,
		OnScrollListener, OnRefreshListener2<ListView>, OnItemClickListener {
	private View quickTols;
	private View textNotify;
	private EssayAdapter adapter;
	private long lastTime;
	// private List<TestEntity> entities;

	/**
	 * 分类id代表文本
	 */
	public static final int CATEGORY_TEST = 1;
	/**
	 * 分类id代表图片
	 */
	public static final int CATEGORY_IMAGE = 2;

	private int requestCategory = CATEGORY_TEST;
	private RequestQueue queue;

	public TextFragment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		queue = Volley.newRequestQueue(getActivity());

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// int listCurrentPosition = 0;
		if (savedInstanceState != null) {
			lastTime = savedInstanceState.getInt("lastTime");
			Log.d("", "lastTime" + lastTime);
		}

		View view = inflater.inflate(R.layout.fragment_text, container, false);
		// ListView listView = (ListView) view.findViewById(R.id.textlsit_view);
		// 获取标题事件，增加电极，进行 心小心炫富显示的功能
		View titleView = view.findViewById(R.id.textlist_title);
		titleView.setOnClickListener(this);

		PullToRefreshListView refreshListView = (PullToRefreshListView) view
				.findViewById(R.id.textlsit_view);
		refreshListView.setOnRefreshListener(this);
		refreshListView.setMode(Mode.BOTH);

		ListView listView = refreshListView.getRefreshableView();
		listView.setOnItemClickListener(this);
		List<String> strings = new LinkedList<String>();
		strings.add("java");
		strings.add("java1");
		strings.add("java11");
		strings.add("java111");
		strings.add("java1111");
		strings.add("java11111");
		strings.add("java2");
		strings.add("java22");
		strings.add("java2223");
		strings.add("java3");
		strings.add("java34");
		strings.add("java324");
		strings.add("java23423");
		strings.add("java546");
		strings.add("java56");
		strings.add("java7");
		strings.add("java8");
		strings.add("java444");
		strings.add("java4653");
		// 添加列表上的快速工具条（Header）
		View header = inflater.inflate(R.layout.textlist_header_tools,
				listView, false);
		listView.addHeaderView(header);

		View quickPublish = header.findViewById(R.id.quick_tools_piblish);
		quickPublish.setOnClickListener(this);

		View quickReview = header.findViewById(R.id.quick_tools_review);
		quickReview.setOnClickListener(this);

		List<TestEntity> entities = DataStore.getInatance().getTextEntities();
		// if (entities == null) {
		// entities = new LinkedList<TestEntity>();
		// }

		// ArrayAdapter<String> adapter = new
		// ArrayAdapter<String>(getActivity(),
		// android.R.layout.simple_list_item_1, strings);
		// entities = new LinkedList<TestEntity>();

		adapter = new EssayAdapter(getActivity(), entities);
		adapter.setListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v instanceof TextView) {
					String string = (String)v.getTag();
					if (string!=null) {
						int position = Integer.parseInt(string);
						Intent intent = new Intent(getActivity(), EssayDetailActivity.class);

						intent.putExtra("currentEssayPosition", position);
						intent.putExtra("category", requestCategory);
						startActivity(intent);
					}
					
				}
			}
		});
		listView.setAdapter(adapter);
		listView.setOnScrollListener(this);
		// TODO 获取ListView并且设置数据（以后需要有PullToRefresh进行完善）
		// 获取快速的工具条（发布和审核），用于列表的滚动显示和隐藏
		quickTols = view.findViewById(R.id.textlist_quick_tools);

		quickTols.setVisibility(View.INVISIBLE);
		// 设置悬浮的工具条，两个点击事件
		quickPublish = header.findViewById(R.id.quick_tools_piblish);
		quickPublish.setOnClickListener(this);

		quickReview = header.findViewById(R.id.quick_tools_review);
		quickReview.setOnClickListener(this);

		// 获取新条目通知控件，每次跟新数据要显示，过一段时间隐藏
		textNotify = view.findViewById(R.id.textlist_new_notify);
		textNotify.setVisibility(View.INVISIBLE);
		return view;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			if (what == 1) {
				// TODO what = 1代表有新消息提醒
				textNotify.setVisibility(View.INVISIBLE);
			}
		};
	};

	// ///////////////////////////////////////////////////////////////////////////////////////////
	private int lastIndex = 0;

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub

		int offset = lastIndex - firstVisibleItem;

		if (offset < 0 || firstVisibleItem == 0) {
			// 证明现在listView往上移动
			if (quickTols != null) {

				quickTols.setVisibility(View.INVISIBLE);
			}
		} else if (offset > 0) {
			if (quickTols != null) {
				quickTols.setVisibility(View.VISIBLE);

			}

		}

		lastIndex = firstVisibleItem;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.textlist_title:
			textNotify.setVisibility(View.VISIBLE);

			handler.sendEmptyMessageDelayed(1, 3000);
			break;

		default:
			break;
		}

	}

	/*
	 * 列表网络获取回调部分 这个方法是在Volley联网响应返回的时候调用 他是在主线程调用
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
			List<TestEntity> ets = entityList.getEntities();

			if (ets != null) {
				if (!ets.isEmpty()) {
					DataStore.getInatance().addTextEntities(ets);

					// entities.addAll(0, ets);
					// int len = ets.size();
					// for (int i = len - 1; i >= 0; i--) {
					// // 把object添加到指定的location位置，原有的location以及
					// entities.add(0, ets.get(i));
					// }
					adapter.notifyDataSetChanged();
				} else {
					// TODO没有更多数据了，需要提示一下
				}
			} else {
				// TODO没有获取到网络数据，可能是数据解析错误，网络错误，需要
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////
	// 列表下拉刷新与上拉加载
	/**
	 * 从上向下拉动列表，那么就进行加载新数据的操作
	 */
	@Override
	public void onPullDownToRefresh(
			final PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		ClientAPI.getList(queue, requestCategory, 30, lastTime,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						listonResponse(arg0);
						refreshView.onRefreshComplete();
					}
				});
	}

	/**
	 * 从下往上拉动列表，那么就进行加载旧数据的操作
	 */
	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		position--;
		// DataStore store = DataStore.getInatance();
		// List<TestEntity> entities = store.getTextEntities();
		//
		// TestEntity entity = entities.get(position);
		//

		Intent intent = new Intent(getActivity(), EssayDetailActivity.class);

		intent.putExtra("currentEssayPosition", position);
		intent.putExtra("category", requestCategory);
		startActivity(intent);
	}
}
