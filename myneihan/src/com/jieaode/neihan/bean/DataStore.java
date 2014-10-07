package com.jieaode.neihan.bean;

import java.util.LinkedList;
import java.util.List;

public class DataStore {
private static DataStore outInstance;
public static DataStore getInatance(){
	if (outInstance==null) {
		outInstance = new DataStore();
	}
	return outInstance;
}
private List<TestEntity> textEntities;
private List<TestEntity> imageEntities;
private DataStore(){
	textEntities = new LinkedList<TestEntity>();
	imageEntities  = new LinkedList<TestEntity>();
}
/**
 * 把获取到的文本列表放在最前面，这个方法针对的是下拉刷新的操作
 * @param entities
 */
public void addTextEntities(List<TestEntity> entities){
	if (entities!=null) {
		textEntities.addAll(0,entities);
	}
}
/**
 * 把获取到的文本列表放在最后面，这个方法针对的是上啦查看旧数据的操作
 * @param entities
 */
public void appendTextEntities(List<TestEntity> entities){
	if (entities!=null) {
		textEntities.addAll(0,entities);
	}
}
/**
 * 把获取到的图片列表放在最后面，这个方法针对的是上啦查看旧数据的操作
 * @param entities
 */
public void addImageEntities(List<TestEntity> entities){
	if (entities!=null) {
		imageEntities.addAll(0,entities);
	}
}
/**
 * 把获取到的图片列表放在最后面，这个方法针对的是上啦查看旧数据的操作
 * @param entities
 */
public void appendImageEntities(List<TestEntity> entities){
	if (entities!=null) {
		imageEntities.addAll(0,entities);
	}
}
/**
 * 获取文本段子列表
 * @return
 */
public List<TestEntity> getTextEntities() {
	return textEntities;
}
/*
 * 获取图片段子列表
 */
public List<TestEntity> getImageEntities() {
	return imageEntities;
}

}
