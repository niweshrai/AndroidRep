package com.example.niwesh.webviewintegration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Niwesh on 4/12/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private String[] tabs = new String[]{"Personal Site", "Music", "Movies"};
    private int numOfTabs = tabs.length;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0) return new PersonalSiteFragment();
        else if(position==1) return new MusicFragment();
        else if(position==2) return new MoviesFragment();
        else return null;/**
         * Created by Niwesh on 4/15/2018.
         */
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
