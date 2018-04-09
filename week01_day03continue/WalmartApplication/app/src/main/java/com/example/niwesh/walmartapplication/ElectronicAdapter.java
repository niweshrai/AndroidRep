package com.example.niwesh.walmartapplication;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niwesh on 4/8/2018.
 */

public class ElectronicAdapter extends BaseAdapter {

    private Context context;

    public ElectronicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ElectronicsActivity.products.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.electronics_view,null);

//      Product product = productsLists.get(i);

        TextView tv1 = (TextView) v.findViewById(R.id.price_fill);
        TextView tv2 = (TextView) v.findViewById(R.id.color_fill);
        TextView tv3 = (TextView) v.findViewById(R.id.electronics_name);
        ImageView image = (ImageView) v.findViewById(R.id.image_food);

        String price = String.valueOf(ElectronicsActivity.products.get(i).getPrice());
        String color = ElectronicsActivity.products.get(i).getColor();
        String name = ElectronicsActivity.products.get(i).getTitle();

        int imageID = context.getResources().getIdentifier(ElectronicsActivity.products.get(i).getImage(),"drawable",context.getPackageName());
        image.setImageResource(imageID);

        tv1.setText("$"+price);
        tv2.setText(color);
        tv3.setText(name);

        return v;
    }
}
