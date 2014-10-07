package com.jieaode.neihan;

import java.util.List;

import cn.sharesdk.framework.authorize.e;

import com.jieaode.neihan.adapter.DetailPagerAdapter;
import com.jieaode.neihan.bean.DataStore;
import com.jieaode.neihan.bean.TestEntity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class EssayDetailActivity extends FragmentActivity {
	private ViewPager pager;
private DetailPagerAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_essay_detail);
		pager = (ViewPager)findViewById(R.id.detail_pager_content);
		
		Intent intent = getIntent();
		
		Bundle extras = intent.getExtras();
		
		int category = 1;
		
		int currentEssayPosition = 0;
		if (extras!=null) {
			category = extras.getInt("category",1);
			currentEssayPosition = extras.getInt("currentEssayPosition",0);
		}
		
		
		DataStore dataStore = DataStore.getInatance();
		
		List<TestEntity> entities = null;
		
		if (category==1) {
			entities = dataStore.getTextEntities();
		}else if (category==2) {
			entities = dataStore.getImageEntities();
		}
		
		adapter = new DetailPagerAdapter(getSupportFragmentManager(), entities);
		pager.setAdapter(adapter); 
		
		if (currentEssayPosition>0) {
			pager.setCurrentItem(currentEssayPosition);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.essay_detail, menu);
		return true;
	}

}
