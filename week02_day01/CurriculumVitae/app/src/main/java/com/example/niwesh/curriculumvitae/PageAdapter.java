package com.example.niwesh.curriculumvitae;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Niwesh on 4/9/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private String tabs[] = new String[] {"Home","About Me","Experience","Contact"};
    private int numOfTabs =tabs.length;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new HomeFragment();
        }
        else if(position==1){
            return new AboutFragment();
        }
        else if(position==2){
            return new ExperienceFragment();
        }
        else if(position==3){
            return new ContactFragment();
        }
        else return null;
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
