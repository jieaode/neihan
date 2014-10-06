package com.jieaode.neihan.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class AdEntity {
private int type;
private long displayTime;
private long onlineTime;
private int displayImageHeight;
private long adId;
private int displayImageWidth;
private String source;
private String Package;
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

	/*
 *  "ad": {
                    "display_image_height": 400,
                    "ad_id": 3561092485,
                    "display_image_width": 600,
                    "source": "",
                    "package": "",
                    "title": "霜霜和阿伟都爱玩的游戏，还有iphone6等你拿哦！",
                    "open_url": "",
                    "download_url": "http://yihua.b0.upaiyun.com/neihan.apk",
                    "is_ad": 1,
                    "display_info": "霜霜和阿伟都爱玩的游戏，还有iphone6等你拿哦！",
                    "web_url": "http://yihua.b0.upaiyun.com/neihan.apk",
                    "display_type": 3,
                    "button_text": "立即下载",
                    "appleid": "",
                    "track_url": "",
                    "label": "推广",
                    "type": "app",
                    "id": 3561092485,
                    "ipa_url": "",
                    "display_image": "http://p2.pstatp.com/large/1362/1075506622"
                }
            }
 */
	public void parseJson(JSONObject json) throws JSONException {
		if (json!=null) {
			type = json.getInt("type");
			displayTime = json.getLong("display_time");
			onlineTime = json.getLong("online_time");
			JSONObject ad = json.getJSONObject("ad");
			displayImageHeight = ad.getInt("display_image_height");
			adId = ad.getLong("ad_id");
			displayImageWidth = ad.getInt("display_image_width");
			source = ad.getString("source");
			Package = ad.getString("package");
			title = ad.getString("title");
			openUrl = ad.getString("open_url");
			downloadUrl = ad.getString("download_url");
			isId = ad.getInt("is_id");
			displayInfo = ad.getString("display_info");
			webUrl = ad.getString("web_url");
			displayType = ad.getInt("display_type");
			buttonText = ad.getString("button_text");
			appleid = ad.getString("appleid");
			trackUrl = ad.getString("track_url");
			label = ad.getString("label");
			typeAd = ad.getString("type");
			id = ad.getLong("id");
			ipaUrl = ad.getString("ipa_url");
			displayImage = ad.getString("display_image");
			
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(long displayTime) {
		this.displayTime = displayTime;
	}

	public long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public int getDisplayImageHeight() {
		return displayImageHeight;
	}

	public void setDisplayImageHeight(int displayImageHeight) {
		this.displayImageHeight = displayImageHeight;
	}

	public long getAdId() {
		return adId;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}

	public int getDisplayImageWidth() {
		return displayImageWidth;
	}

	public void setDisplayImageWidth(int displayImageWidth) {
		this.displayImageWidth = displayImageWidth;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPackage() {
		return Package;
	}

	public void setPackage(String package1) {
		Package = package1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public int getIsId() {
		return isId;
	}

	public void setIsId(int isId) {
		this.isId = isId;
	}

	public String getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getAppleid() {
		return appleid;
	}

	public void setAppleid(String appleid) {
		this.appleid = appleid;
	}

	public String getTrackUrl() {
		return trackUrl;
	}

	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTypeAd() {
		return typeAd;
	}

	public void setTypeAd(String typeAd) {
		this.typeAd = typeAd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpaUrl() {
		return ipaUrl;
	}

	public void setIpaUrl(String ipaUrl) {
		this.ipaUrl = ipaUrl;
	}

	public String getDisplayImage() {
		return displayImage;
	}

	public void setDisplayImage(String displayImage) {
		this.displayImage = displayImage;
	}
	
}
