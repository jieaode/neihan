package com.jieaode.neihan.bean;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class UserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7443188975722218782L;
	
	/*
	 * 头像网址
	 */
	private String avatarUrl;
	/*
	 * 用户ID
	 * 
	 */
	private Long userId;
	/*
	 * 用户昵称
	 */
	private String name;
	/*
	 * 用户是否加V
	 */
	private boolean userVerified;
	
/**
 *  "user": {
                        "avatar_url": "http://p1.pstatp.com/thumb/1367/2213311454",
                        "user_id": 3080520868,
                        "name": "请叫我梓安哥",
                        "user_verified": false
                    }
 */
	public void parseJson(JSONObject json) throws JSONException {
		if (json!=null) {
			 avatarUrl = json.getString("avatar_url");
			userId = json.getLong("user_id");
			name = json.getString("name");
			userVerified = json.getBoolean("user_verified");
			
		}
	}

public String getAvatarUrl() {
	return avatarUrl;
}

public Long getUserId() {
	return userId;
}

public String getName() {
	return name;
}

public boolean isUserVerified() {
	return userVerified;
}
	
}
