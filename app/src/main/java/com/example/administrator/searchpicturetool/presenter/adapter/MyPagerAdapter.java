package com.example.administrator.searchpicturetool.presenter.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


import com.example.administrator.searchpicturetool.R;
import com.example.administrator.searchpicturetool.view.fragment.NetImgFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/11/2 0002.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private HashMap<String,NetImgFragment> fragments;
    private String[] tabs;
    public MyPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        tabs=context.getResources().getStringArray(R.array.tab);
        fragments = new HashMap<String,NetImgFragment>();

    }

    @Override
    public Fragment getItem(int position) {

        NetImgFragment fragment1 = new NetImgFragment();
       Bundle bundle = new Bundle();
        bundle.putInt("tab", position);
        fragment1.setArguments(bundle);
        fragments.put(position+"",fragment1);
        return fragment1;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {


       return tabs[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragments.remove(position);

    }
    public NetImgFragment getFragment(int position){
        return fragments.get(position+"");
    }
}
