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
 * @author : Niwesh Chandra Rai
 */
public class MoviesFragment extends Fragment {

    ArrayList<WebList> sitesList;
    ListView lv;

    WebView webView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        sitesList = new ArrayList<WebList>(Arrays.asList(
                new WebList("https://en.wikipedia.org/wiki/Avengers:_Infinity_War","Avengers: Infinity War is an upcoming American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures.","avengers"),
                new WebList("https://en.wikipedia.org/wiki/Suicide_Squad_(film)","Suicide Squad is a 2016 American superhero film based on the DC Comics antihero team of the same name, distributed by Warner Bros. Pictures. It is the third installment in the DC Extended Universe (DCEU).","suicidesquad"),
                new WebList("https://en.wikipedia.org/wiki/Justice_League_(film)","Justice League is a 2017 American superhero film based on the DC Comics superhero team of the same name, distributed by Warner Bros. Pictures. It is the fifth installment in the DC Extended Universe (DCEU).","justiceleague")
        ));

        webView3 = (WebView) view.findViewById(R.id.movies_webView);
        webView3.setWebViewClient(new WebViewClient());
        webView3.getSettings().setBuiltInZoomControls(true);
        webView3.getSettings().setJavaScriptEnabled(true);

        lv = (ListView) view.findViewById(R.id.movies_list);
        lv.setAdapter(new SiteAdapter(getActivity(),sitesList, webView3));

        return view;
    }


}
