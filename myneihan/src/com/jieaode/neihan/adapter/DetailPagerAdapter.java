package com.jieaode.neihan.adapter;

import java.util.List;

import com.jieaode.neihan.bean.DataStore;
import com.jieaode.neihan.bean.TestEntity;
import com.jieaode.neihan.fragment.DetailContentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DetailPagerAdapter extends FragmentPagerAdapter{
	private List<TestEntity> entities;

	public DetailPagerAdapter(FragmentManager fm,List<TestEntity> entities) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.entities = entities;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		DetailContentFragment fragment = null;
		Bundle arguments = new Bundle();
		entities.get(arg0);
		TestEntity entity =entities.get(arg0);
		arguments.putSerializable("entity", entity);
		
		fragment.setArguments(arguments);
		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return entities.size();
	}

}
