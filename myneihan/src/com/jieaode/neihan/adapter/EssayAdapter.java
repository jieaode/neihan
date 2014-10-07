package com.jieaode.neihan.adapter;

import java.util.List;
import java.util.zip.Inflater;


import pl.droidsonroids.gif.GifImageView;

import com.jieaode.neihan.R;
import com.jieaode.neihan.bean.TestEntity;
import com.jieaode.neihan.bean.UserEntity;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class EssayAdapter extends BaseAdapter {

	private Context context;
	List<TestEntity> entities;
	private LayoutInflater inflater ;
	private OnClickListener listener;

	
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}

	public EssayAdapter(Context context, List<TestEntity> entities) {
		super();
		// TODO Auto-generated constructor stub
		this.context = context;
		this.entities = entities;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return entities.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return entities.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View ret = convertView;
		if (convertView==null) {
			ret = inflater.inflate(R.layout.item_entity,parent ,false );
		}
		if (ret!=null) {
			
		
		ViewHolder holder = (ViewHolder)ret.getTag();
		if (holder==null) {
			holder = new ViewHolder();
			holder.btnGifPlay = (TextView)ret.findViewById(R.id.btnGifPlay);
			holder.btnShare = (ImageButton)ret.findViewById(R.id.item_share);
			holder.chbBuryCount = (CheckBox)ret.findViewById(R.id.item_bury_count);
			holder.chbDiggCount = (CheckBox)ret.findViewById(R.id.item_digg_count);
			holder.gifImageView = (GifImageView)ret.findViewById(R.id.gifView);
			holder.imgProfileImage = (ImageView)ret.findViewById(R.id.item_profile_image);
			holder.pbDownloadProgressBar =(ProgressBar)ret.findViewById(R.id.item_image_download_progress);
			holder.txtCommentCount = (TextView)ret.findViewById(R.id.item_comment_count);
			holder.txtContent = (TextView)ret.findViewById(R.id.item_content);
			holder.txtProfileNick = (TextView)ret.findViewById(R.id.item_profile_nick);
			ret.setTag(holder);
		}
		TestEntity entity = entities.get(position);
		//先设置文本内容的数据
		UserEntity user = entity.getUserEntity();
		String nick = "";
		if (user!=null) {
			nick = user.getName();
		}
		holder.txtProfileNick.setText(nick);
		
		String content = entity.getContent();
		holder.txtContent.setText(content);
		holder.txtContent.setOnClickListener(listener);
		//holder.txtContent.setTag(Integer.toString());
		int diggCount = entity.getDiggCount();
		
		holder.chbDiggCount.setText(Integer.toString(diggCount));
		
		int userDigg = entity.getUserDigg();//当前用户是否赞过；
		//如果userDiggCount是1的话，代表了已经赞过，那么chbDiggCount必出禁用，所以用!+1;
		holder.chbDiggCount.setEnabled(userDigg!=1);
		
		int buryCount = entity.getBuryCount();
		
		holder.chbBuryCount.setText(Integer.toString(buryCount));
		
		int userBury = entity.getUserBury();
		//rguserBury是1的话，代表了已经踩过，那么chbBuryCount必须禁用，所以用！=1;
		holder.chbBuryCount.setEnabled(userBury!=1);
		
		int commentCount = entity.getCommentCount();
		
		holder.txtCommentCount.setText(Integer.toString(commentCount));
		//设置图片内容的数据
		}
		return ret;
	}

	private static class ViewHolder {
		/**
 * 头像
 */
		public ImageView imgProfileImage;
		//昵称
		public TextView txtProfileNick;
		//文本内容
		public TextView txtContent;
		
		public ProgressBar pbDownloadProgressBar;
		//图片显示
		public GifImageView gifImageView;
		//图片显示部分按钮，开启gif播放
		
		public TextView btnGifPlay;
		//赞的个数，如果赞过，不能再赞
		public CheckBox chbDiggCount;
		
		public CheckBox chbBuryCount;
		
		public TextView txtCommentCount;
		
		public ImageButton btnShare;
		
	}
}
