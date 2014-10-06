package com.jieaode.neihan.bean;

import org.json.JSONObject;

public class AdEntity {
	private int type;
	private long displayTime;
	private long onlineTime;
	private int displayImageHeight;
	private long adId;
	private int displayImageWidth;
	private String source;
	private String package;
	private String title;
	private String openUrl;
	private String downloadUrl;
	private int isId;
	private String displayInfo;
	private String webUrl;
	private int displayType;
	private String buttonText;
	private String appleid;
	private String trackUrl;
	private String label;
	private String typeAd;
	private long id;
	private String ipaUrl;
	private String displayImage;

	/**
	 * "ad": {"display_image_height": 400,"ad_id": 3561092485,"display_image_width": 600,"source": "","package": "","title": "霜霜和阿伟都爱玩的游戏，还有iphone6等你拿哦�?,"open_url": "","download_url": "http://yihua.b0.upaiyun.com/neihan.apk","is_ad": 1,"display_info": "霜霜和阿伟都爱玩的游戏，还有iphone6等你拿哦�?,"web_url": "http://yihua.b0.upaiyun.com/neihan.apk","display_type": 3,"button_text": "立即下载","appleid": "","track_url": "","label": "推广","type": "app","id": 3561092485,"ipa_url": "","display_image": "http://p2.pstatp.com/large/1362/1075506622"}}
	 */
	public void parseJson(JSONObject json) throws JSONException {
		throw new UnsupportedOperationException();
	}

	public String getPackage() {
		return this.package;
	}

	public void setPackage(String package1) {
		this.package = package1;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setDisplayTime(long displayTime) {
		this.displayTime = displayTime;
	}

	public long getDisplayTime() {
		return this.displayTime;
	}

	public void setOnlineTime(long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public long getOnlineTime() {
		return this.onlineTime;
	}

	public void setDisplayImageHeight(int displayImageHeight) {
		this.displayImageHeight = displayImageHeight;
	}

	public int getDisplayImageHeight() {
		return this.displayImageHeight;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}

	public long getAdId() {
		return this.adId;
	}

	public void setDisplayImageWidth(int displayImageWidth) {
		this.displayImageWidth = displayImageWidth;
	}

	public int getDisplayImageWidth() {
		return this.displayImageWidth;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getOpenUrl() {
		return this.openUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getDownloadUrl() {
		return this.downloadUrl;
	}

	public void setIsId(int isId) {
		this.isId = isId;
	}

	public int getIsId() {
		return this.isId;
	}

	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}

	public String getDisplayInfo() {
		return this.displayInfo;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getWebUrl() {
		return this.webUrl;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	public int getDisplayType() {
		return this.displayType;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getButtonText() {
		return this.buttonText;
	}

	public void setAppleid(String appleid) {
		this.appleid = appleid;
	}

	public String getAppleid() {
		return this.appleid;
	}

	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	public String getTrackUrl() {
		return this.trackUrl;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public void setTypeAd(String typeAd) {
		this.typeAd = typeAd;
	}

	public String getTypeAd() {
		return this.typeAd;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setIpaUrl(String ipaUrl) {
		this.ipaUrl = ipaUrl;
	}

	public String getIpaUrl() {
		return this.ipaUrl;
	}

	public void setDisplayImage(String displayImage) {
		this.displayImage = displayImage;
	}

	public String getDisplayImage() {
		return this.displayImage;
	}
}