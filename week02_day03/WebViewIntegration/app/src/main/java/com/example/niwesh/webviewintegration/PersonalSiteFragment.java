package com.example.niwesh.webviewintegration;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Niwesh on 4/15/2018.
 */

public class PersonalSiteFragment extends Fragment {

    ArrayList<WebList> sitesList;
    ListView lv;

    WebView webView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_site, container, false);

        sitesList = new ArrayList<WebList>(Arrays.asList(
            new WebList("https://soundcloud.com/","SoundCloud is an online audio distribution platform based in Berlin, Germany that enables its users to upload, record, promote and share sounds","soundcloud"),
            new WebList("https://www.techzilla.com/","A cellphone isn’t just a fancy gadget that’s for show. It’s a lifeline. From connecting you with friends and family to keeping you ahead of the game workwise","techzilla"),
            new WebList("http://www.goal.com/en-us","The latest soccer news, live scores, results, rumours, transfers, fixture schedules, table standings and player profiles from around the world, including World Cup.","goal")
        ));

       webView1 = (WebView) view.findViewById(R.id.personal_webView);
       webView1.setWebViewClient(new WebViewClient());
       webView1.getSettings().setBuiltInZoomControls(true);
       webView1.getSettings().setJavaScriptEnabled(true);

       lv = (ListView) view.findViewById(R.id.personal_list);
       lv.setAdapter(new SiteAdapter(getActivity(),sitesList, webView1));


        return view;
    }

}
