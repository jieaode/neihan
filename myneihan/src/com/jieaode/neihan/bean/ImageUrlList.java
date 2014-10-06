package com.jieaode.neihan.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;

public class ImageUrlList {
	private List<String> largeImageList;
	private String uri;
	private int width;
	private int height;

	public void parseJson(JSONObject json) throws JSONException {
		largeImageList = parseLagerImageList(json);
		uri = json.getString("uri");
		width = json.getInt("width");
		height = json.getInt("height");
	}

	private List<String> parseMiddleImageList(JSONObject middleImage)
			throws JSONException {
		JSONArray urls = middleImage.getJSONArray("url_list");
		int ulen = urls.length();

		// 小图片的网址全部都在这里
		List<String> middleImageUrls = new LinkedList<String>();

		for (int j = 0; j < ulen; j++) {
			JSONObject uobj = urls.getJSONObject(j);
			String url = uobj.getString("url");
			middleImageUrls.add(url);
		}
		return middleImageUrls;
	}

	private List<String> parseLagerImageList(JSONObject largeImage)
			throws JSONException {
		JSONArray urls = largeImage.getJSONArray("url_list");
		// 大图片的网址全部都在这里
		List<String> largeImageUrls = new LinkedList<String>();
		int ulen = urls.length();
		for (int i = 0; i < ulen; i++) {
			JSONObject uobj = urls.getJSONObject(i);
			String url = uobj.getString("url");
			largeImageUrls.add(url);
		}
		return largeImageUrls;
	}

}
