package com.jieaode.neihan.bean;

import java.util.List;
import org.json.JSONObject;

public class ImageUrlList {
	private java.util.List<String> largeImageList;
	private String uri;
	private int width;
	private int height;

	public void parseJson(JSONObject json) throws JSONException {
		throw new UnsupportedOperationException();
	}

	private java.util.List<String> parseMiddleImageList(JSONObject middleImage) throws JSONException {
		throw new UnsupportedOperationException();
	}

	private java.util.List<String> parseLagerImageList(JSONObject largeImage) throws JSONException {
		throw new UnsupportedOperationException();
	}
}