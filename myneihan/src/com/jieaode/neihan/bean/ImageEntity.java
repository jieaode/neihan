package com.jieaode.neihan.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity extends TestEntity {

	private ImageUrlList largeList;
	private ImageUrlList middleList;

	public ImageUrlList getLargeList() {
		return largeList;
	}

	public ImageUrlList getMiddleList() {
		return middleList;
	}

	public void parseJson(JSONObject json) throws JSONException {

		super.parseJson(json);
		JSONObject group = json.getJSONObject("group");

		JSONObject largeImage = group.optJSONObject("large_image");
		JSONObject middleImage = group.optJSONObject("middle_image");

		largeList = new ImageUrlList();
		if (largeImage != null) {
			largeList.parseJson(largeImage);
		}

		middleList = new ImageUrlList();
		if (middleImage != null) {
			middleList.parseJson(middleImage);
		}

	}
}
