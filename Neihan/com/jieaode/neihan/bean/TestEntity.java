package com.jieaode.neihan.bean;

import org.json.JSONObject;

/**
 * {
 *                 "online_time": 1411878957,
 *                 "display_time": 1411878957,
 *                 "group": {
 *                     "create_time": 1411718218.0,
 *                     "favorite_count": 1209,
 *                     "user_bury": 0,
 *                     "user_favorite": 0,
 *                     "bury_count": 1516,
 *                     "share_url": "http://toutiao.com/group/3560859160/?iid=2337593504&app=joke_essay",
 *                     "label": 1,
 *                     "content": "�?昨天碰到抢劫的，被打了两顿�?�?为啥啊？�?他问我有钱吗我说没有，他从我身上搜出�?��软中华然后就被打了一顿�?等他走了，不�?��儿又回来打了我一顿，因为他发现里面塞的是白红梅，劫匪走时还留下一句�?没钱还装B�?,
 *                     "comment_count": 177,
 *                     "status": 3,
 *                     "has_comments": 0,
 *                     "go_detail_count": 4370,
 *                     "status_desc": "已发表到热门列表",
 *                     "user": {
 *                         "avatar_url": "http://p1.pstatp.com/thumb/1367/2213311454",
 *                         "user_id": 3080520868,
 *                         "name": "请叫我梓安哥",
 *                         "user_verified": false
 *                     },
 *                     "user_digg": 0,
 *                     "group_id": 3560859160,
 *                     "level": 4,
 *                     "repin_count": 1209,
 *                     "digg_count": 18424,
 *                     "has_hot_comments": 1,
 *                     "user_repin": 0,
 *                     "category_id": 1
 *                 },
 *                 "comments": [],
 *                 "type": 1
 *             }
 * @author FCB-MESSI
 */
public class TestEntity extends DuanziEntity {
	private int type;
	private Long createTime;
	/**
	 * 代表点赞的个�?
	 */
	private int favoriteCount;
	/**
	 * 代表当前用户是否踩了�?代表没有�?代表踩了
	 */
	private int userBury;
	/**
	 * 代表当前用户是否赞了�?代表没有�?代表赞了
	 */
	private int userFavorite;
	/**
	 * 代表踩的个数
	 */
	private int buryCount;
	/**
	 * 用于第三方分享，提交网址的参�?
	 */
	private String shareUrl;
	/**
	 * TODO分析这个字段的含�?
	 */
	private int label;
	/**
	 * 文本段子的内容部分（完整内容�?
	 */
	private String content;
	/**
	 * 评论个数
	 */
	private int commentCount;
	/**
	 * 状�?，其中可选�?�?，分析是�?��类型
	 */
	private int status;
	/**
	 * 状�?描述信息<br/>
	 * 可�?�?br/>
	 * <ul>
	 * <li>"已经发表到热门评�?</li>
	 * <>
	 */
	private String statusDesc;
	/**
	 * 当前用户是否评论�?
	 */
	private int hasComments;
	/**
	 * TODO�?��分析这个字段的含�?
	 */
	private int goDetailCount;
	/**
	 * �?��去了解这个字段的含义
	 */
	private int userDigg;
	/**
	 * digg个数
	 */
	private int diggCount;
	/**
	 * 段子的ID，访问详情和评论时，用这个作为接口的参数
	 */
	private Long groupId;
	/**
	 * TODO这个�?��分析�?��是什么含义，现在又两处地方出�?
	 * 1.获取列表接口里面有一�?level=6
	 * 2.文本段子实体�?level=4
	 */
	private int level;
	/**
	 * 代表用户是否repin,0代表无，1代表�?
	 */
	private int userRepin;
	/**
	 * TODO分析含义
	 */
	private int repinCount;
	/**
	 * 是否含有热门评论
	 */
	private int hasHotComment;
	/**
	 * 内容分类�?代表文本�?代表图片
	 */
	private int categoryId;
	/**
	 * 上线时间
	 */
	private Long onlineTime;
	/**
	 * 显示时间
	 */
	private Long displayTime;
	private UserEntity userEntity;

	public void parseJson(JSONObject json) throws JSONException {
		throw new UnsupportedOperationException();
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getFavoriteCount() {
		return this.favoriteCount;
	}

	public void setUserBury(int userBury) {
		this.userBury = userBury;
	}

	public int getUserBury() {
		return this.userBury;
	}

	public void setUserFavorite(int userFavorite) {
		this.userFavorite = userFavorite;
	}

	public int getUserFavorite() {
		return this.userFavorite;
	}

	public void setBuryCount(int buryCount) {
		this.buryCount = buryCount;
	}

	public int getBuryCount() {
		return this.buryCount;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getShareUrl() {
		return this.shareUrl;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public int getLabel() {
		return this.label;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getCommentCount() {
		return this.commentCount;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setHasComments(int hasComments) {
		this.hasComments = hasComments;
	}

	public int getHasComments() {
		return this.hasComments;
	}

	public void setGoDetailCount(int goDetailCount) {
		this.goDetailCount = goDetailCount;
	}

	public int getGoDetailCount() {
		return this.goDetailCount;
	}

	public void setUserDigg(int userDigg) {
		this.userDigg = userDigg;
	}

	public int getUserDigg() {
		return this.userDigg;
	}

	public void setDiggCount(int diggCount) {
		this.diggCount = diggCount;
	}

	public int getDiggCount() {
		return this.diggCount;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setUserRepin(int userRepin) {
		this.userRepin = userRepin;
	}

	public int getUserRepin() {
		return this.userRepin;
	}

	public void setRepinCount(int repinCount) {
		this.repinCount = repinCount;
	}

	public int getRepinCount() {
		return this.repinCount;
	}

	public void setHasHotComment(int hasHotComment) {
		this.hasHotComment = hasHotComment;
	}

	public int getHasHotComment() {
		return this.hasHotComment;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Long getOnlineTime() {
		return this.onlineTime;
	}

	public void setDisplayTime(Long displayTime) {
		this.displayTime = displayTime;
	}

	public Long getDisplayTime() {
		return this.displayTime;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public UserEntity getUserEntity() {
		return this.userEntity;
	}
}