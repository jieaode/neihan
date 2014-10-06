package com.jieaode.neihan.bean;

import org.json.JSONObject;

public class ImageEntity extends DuanziEntity {
	private long group_id;
	private String content;
	private ImageUrlList largeList;
	private ImageUrlList middleList;
	private int commentCount;
	private int type;
	private UserEntity user;

	public void parseJson(JSONObject json) throws JSONException {
		throw new UnsupportedOperationException();
	}
}