package com.powertracker.powertracker;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dashboard extends FragmentActivity {

    private final static int NUM_PAGES=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ViewPager pager=(ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter= new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new DashboardFragment();
            }
            else{
                return new DeviceListFragment();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
