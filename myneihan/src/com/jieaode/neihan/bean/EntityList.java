package com.jieaode.neihan.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class EntityList {
	private boolean hasMore;
	private long minTime;
	private String tip;
	private long maxTime;
	private List<TestEntity> entities;

	public void parseJson(JSONObject json) throws JSONException {
		if (json != null) {
			hasMore = json.getBoolean("has_more");
			tip = json.getString("tip");
			if (hasMore) {
				minTime = json.getLong("min_time");
			}

			maxTime = json.getLong("max_time");
			// 从data对象中获取名称为data的数组，它代表的是段子列表的数据
			JSONArray array = json.getJSONArray("data");
			int len = array.length();
			if (len > 0) {
				entities = new LinkedList<TestEntity>();
				// 遍历数组中的每一条图片信息
				for (int i = 0; i < len; i++) {
					JSONObject item = array.getJSONObject(i);
					int type = item.getInt("type");// 获取类型1.段子，5.广告
					if (type == 5) {
						// 处理广告内容
						AdEntity entity = new AdEntity();
						entity.parseJson(item);
						String downloadUrl = entity.getDownloadUrl();
						Log.d("------", "----" + downloadUrl);

					} else if (type == 1) {
						// 处理段子内容
						JSONObject group = item.getJSONObject("group");
						int cid = group.getInt("category_id");
						TestEntity entity = null;
						if (cid == 1) {
							// 解析文本段子
							entity = new TestEntity();
						} else if (cid == 2) {
							// 解析图片段子

							entity = new ImageEntity();
						}
						entity.parseJson(item);
						entities.add(entity);
						Long groupId = entity.getGroupId();
						Log.d("+++++++", "======" + groupId);

					}
				}
			}
		}
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public long getMinTime() {
		return minTime;
	}

	public String getTip() {
		return tip;
	}

	public long getMaxTime() {
		return maxTime;
	}

	public List<TestEntity> getEntities() {
		return entities;
	}

}
