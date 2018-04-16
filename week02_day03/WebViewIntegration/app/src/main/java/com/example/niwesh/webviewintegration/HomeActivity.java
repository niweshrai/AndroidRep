package com.example.niwesh.webviewintegration;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by Niwesh on 4/15/2018.
 */

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    PageAdapter pageAdapter;
    CollapsingToolbarLayout collapse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        collapse = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapse.setTitleEnabled(true);
        collapse.setTitle("Web Gallery");
    }
}
