package com.jieaode.neihan.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.sharesdk.framework.network.c;

import android.R.integer;

/*
 * 评论接口返回的data：{}数据部分的实体定义
 * 包含了top_comments和recent_comments两个数组
 * JSON格式如下:<br/>
 * <pre>
 * {
 * "data":{
 * "top_comments":[],
 * "recent_comments":[]
 * }
 * 
 * }
 * </pre>
 */
public class CommentList {
	private List<Comment> topComments;

	private List<Comment> recetentComments;

	private long groupId;
	private int totalNumber;
	private boolean hasMore;

	public void parseJson(JSONObject json) throws JSONException {
		if (json != null) {
			groupId = json.getLong("group_id");
			totalNumber = json.getInt("total_number");
			hasMore = json.getBoolean("has_more");
			JSONObject data = json.getJSONObject("data");
			JSONArray tArray = data.optJSONArray("top_comments");
			if (tArray != null) {
				topComments = new LinkedList<Comment>();
				int len = tArray.length();
				if (len > 0) {
					for (int i = 0; i < len; i++) {
						JSONObject obj = tArray.getJSONObject(i);
						Comment comment = new Comment();
						comment.parseJson(obj);
						topComments.add(comment);
					}
				}
			}
			JSONArray rArray = data.getJSONArray("recent_comments");
			if (rArray != null) {
				recetentComments = new LinkedList<Comment>();
				int len = rArray.length();
				if (len > 0) {
					for (int i = 0; i < len; i++) {
						JSONObject obj = rArray.getJSONObject(i);
						Comment comment = new Comment();
						comment.parseJson(obj);
						recetentComments.add(comment);
					}
				}
			}
		}
	}

	public List<Comment> getTopComments() {
		return topComments;
	}

	public List<Comment> getRecetentComments() {
		return recetentComments;
	}

	public long getGroupId() {
		return groupId;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public boolean isHasMore() {
		return hasMore;
	}

}
