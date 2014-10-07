package com.jieaode.neihan.bean;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;

/**
 * { "online_time": 1411878957, "display_time": 1411878957, "group": {
 * "create_time": 1411718218.0, "favorite_count": 1209, "user_bury": 0,
 * "user_favorite": 0, "bury_count": 1516, "share_url":
 * "http://toutiao.com/group/3560859160/?iid=2337593504&app=joke_essay",
 * "label": 1, "content":
 * "甲:昨天碰到抢劫的，被打了两顿。乙:为啥啊？甲:他问我有钱吗我说没有，他从我身上搜出一包软中华然后就被打了一顿。等他走了，不一会儿又回来打了我一顿，因为他发现里面塞的是白红梅，劫匪走时还留下一句‘没钱还装B’"
 * , "comment_count": 177, "status": 3, "has_comments": 0, "go_detail_count":
 * 4370, "status_desc": "已发表到热门列表", "user": { "avatar_url":
 * "http://p1.pstatp.com/thumb/1367/2213311454", "user_id": 3080520868, "name":
 * "请叫我梓安哥", "user_verified": false }, "user_digg": 0, "group_id": 3560859160,
 * "level": 4, "repin_count": 1209, "digg_count": 18424, "has_hot_comments": 1,
 * "user_repin": 0, "category_id": 1 }, "comments": [], "type": 1 }
 * 
 * @author FCB-MESSI
 * 
 */

public class TestEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7846326414079052498L;

	/*
	 * 代表点赞的个数
	 */
	private int favoriteCount;

	/*
	 * 代表当前用户是否赞了，0代表没有，1代表赞了
	 */
	private int userFavorite;

	// TODO分析这个字段的含义
	private int label;

	/*
	 * 状态描述信息<br/> 可选值<br/> <ul> <li>"已经发表到热门评论"</li> <>
	 */
	private String statusDesc;
	private int type;
	private Long createTime;
	/*
	 * 上线时间
	 */
	private Long onlineTime;
	/*
	 * 显示时间
	 */
	private Long displayTime;
	/*
	 * 评论个数
	 */
	private int commentCount;
	// digg个数
	private int diggCount;
	/*
	 * 状态，其中可选值为3，分析是什么类型
	 */
	private int status;
	// 需要去了解这个字段的含义
	private int userDigg;

	/*
	 * 段子的ID，访问详情和评论时，用这个作为接口的参数
	 */
	private Long groupId;
	/*
	 * 内容分类，1代表文本，2代表图片
	 */
	private int categoryId;
	/*
	 * 代表踩的个数
	 */
	private int buryCount;
	/*
	 * 文本段子的内容部分（完整内容）
	 */
	private String content;
	/*
	 * 代表用户是否repin,0代表无，1代表有
	 */
	private int userRepin;
	/*
	 * 代表当前用户是否踩了，0代表没有，1代表踩了
	 */
	private int userBury;
	/*
	 * TODO这个需要分析一下是什么含义，现在又两处地方出现 1.获取列表接口里面有一个 level=6 2.文本段子实体中 level=4
	 */
	private int level;
	/*
	 * TODO需要分析这个字段的含义
	 */
	private int goDetailCount;
	/*
	 * 当前用户是否评论了
	 */
	private int hasComments;
	/*
	 * 用于第三方分享，提交网址的参数
	 */
	private String shareUrl;

	// TODO分析含义
	private int repinCount;
	/*
	 * 是否含有热门评论
	 */
	private int hasHotComment;

	// TODO需要去分析comments这个json数组中的内容是什么

	private UserEntity userEntity;

	public void parseJson(JSONObject json) throws JSONException {
		if (json != null) {
			onlineTime = json.getLong("online_time");
			displayTime = json.getLong("display_time");
			JSONObject group = json.getJSONObject("group");
			createTime = group.getLong("create_time");
			favoriteCount = group.getInt("favorite_count");
			userBury = group.getInt("user_bury");
			buryCount = group.getInt("bury_count");
			userFavorite = group.getInt("user_favorite");
			shareUrl = group.getString("share_url");
			label = group.optInt("label");
			commentCount = group.getInt("comment_count");
			content = group.getString("content");
			status = group.getInt("status");
			hasComments = group.getInt("has_comments");
			goDetailCount = group.getInt("go_detail_count");
			statusDesc = group.getString("status_desc");
			JSONObject uobj = group.getJSONObject("user");
			userEntity = new UserEntity();
			userEntity.parseJson(uobj);
			userDigg = group.getInt("user_digg");
			groupId = group.getLong("group_id");
			level = group.getInt("level");
			repinCount = group.getInt("repin_count");
			diggCount = group.getInt("digg_count");
			hasHotComment = group.optInt("has_hot_comments",0);
			userRepin = group.getInt("user_repin");
			categoryId = group.getInt("category_id");
			
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getUserBury() {
		return userBury;
	}

	public void setUserBury(int userBury) {
		this.userBury = userBury;
	}

	public int getUserFavorite() {
		return userFavorite;
	}

	public void setUserFavorite(int userFavorite) {
		this.userFavorite = userFavorite;
	}

	public int getBuryCount() {
		return buryCount;
	}

	public void setBuryCount(int buryCount) {
		this.buryCount = buryCount;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public int getHasComments() {
		return hasComments;
	}

	public void setHasComments(int hasComments) {
		this.hasComments = hasComments;
	}

	public int getGoDetailCount() {
		return goDetailCount;
	}

	public void setGoDetailCount(int goDetailCount) {
		this.goDetailCount = goDetailCount;
	}

	public int getUserDigg() {
		return userDigg;
	}

	public void setUserDigg(int userDigg) {
		this.userDigg = userDigg;
	}

	public int getDiggCount() {
		return diggCount;
	}

	public void setDiggCount(int diggCount) {
		this.diggCount = diggCount;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getUserRepin() {
		return userRepin;
	}

	public void setUserRepin(int userRepin) {
		this.userRepin = userRepin;
	}

	public int getRepinCount() {
		return repinCount;
	}

	public void setRepinCount(int repinCount) {
		this.repinCount = repinCount;
	}

	public int getHasHotComment() {
		return hasHotComment;
	}

	public void setHasHotComment(int hasHotComment) {
		this.hasHotComment = hasHotComment;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Long getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(Long displayTime) {
		this.displayTime = displayTime;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
