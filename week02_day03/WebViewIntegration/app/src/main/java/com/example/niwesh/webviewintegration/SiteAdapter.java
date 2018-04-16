package com.example.niwesh.webviewintegration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Niwesh on 4/15/2018.
 */

public class SiteAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<WebList> webLists;
    private WebView webView;

    public SiteAdapter(Context context, ArrayList<WebList> webLists, WebView webView) {
        this.context = context;
        this.webLists = webLists;
        this.webView = webView;
    }

    @Override
    public int getCount() {
        return webLists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.custom_view, null);

        ImageView img1 = (ImageView) v.findViewById(R.id.image_custom);
        TextView tv1 = (TextView) v.findViewById(R.id.text_custom);
        Button btn1 = (Button) v.findViewById(R.id.button_custom);

        String desc = webLists.get(i).getSiteDescription();

        final String sitename = webLists.get(i).getSiteName();

        int imageID = context.getResources().getIdentifier(webLists.get(i).getImage(),"drawable",context.getPackageName());
        img1.setImageResource(imageID);

        tv1.setText(desc);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(sitename);
            }
        });

        return v;
    }
}
