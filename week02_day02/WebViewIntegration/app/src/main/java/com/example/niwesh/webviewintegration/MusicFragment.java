package com.example.niwesh.webviewintegration;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Niwesh on 4/15/2018.
 */

public class MusicFragment extends Fragment {


    ArrayList<WebList> sitesList;
    ListView lv;

    WebView webView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        sitesList = new ArrayList<WebList>(Arrays.asList(
                new WebList("https://www.azlyrics.com/lyrics/johnmayer/dreamingwithabrokenheart.html","\"Dreaming with a Broken Heart\" is a song by John Mayer from his 2006 album Continuum. It was released as digital download single in July 2007.","dreaming"),
                new WebList("https://www.azlyrics.com/lyrics/greenday/wakemeupwhenseptemberends.html","\"Wake Me Up When September Ends\" is a song by American rock band Green Day, released on June 13, 2005, as the fourth single from the group's seventh studio album","wakemeup"),
                new WebList("https://www.azlyrics.com/lyrics/christinaperri/athousandyears.html","\"A Thousand Years\" is a song by American singer-songwriter Christina Perri and David Hodges. It is taken from the album The Twilight Saga: Breaking Dawn ","thousandyears")
        ));

        webView2 = (WebView) view.findViewById(R.id.music_webView);
        webView2.setWebViewClient(new WebViewClient());
        webView2.getSettings().setBuiltInZoomControls(true);
        webView2.getSettings().setJavaScriptEnabled(true);

        lv = (ListView) view.findViewById(R.id.music_list);
        lv.setAdapter(new SiteAdapter(getActivity(),sitesList, webView2));


        return view;
    }

}
