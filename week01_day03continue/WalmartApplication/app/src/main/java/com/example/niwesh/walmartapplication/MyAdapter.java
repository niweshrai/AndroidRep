package com.example.niwesh.walmartapplication;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Niwesh on 4/7/2018.
 */

public class MyAdapter extends BaseAdapter{

    String path = "storage/emulated/0/Samsung/Cuisine/";

    File file = new File(path);

    String[] fileList = file.list();

    @Override
    public int getCount() {
        return fileList.length;
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

        LayoutInflater inflater = LayoutInflater.from(CustomListActivity.customList);

        View v = inflater.inflate(R.layout.custom_view,null);

        ImageView imgView = (ImageView) v.findViewById(R.id.image_food);
        TextView fileName = (TextView) v.findViewById(R.id.file_name);
        TextView fileSize = (TextView) v.findViewById(R.id.file_size);

        String image_path = path + fileList[i];
        final File new_file = new File(image_path);
        imgView.setImageURI(Uri.fromFile(new_file));

        fileName.setText(fileList[i]);
        fileSize.setText(new_file.length()+" bytes");

        return v;
    }
}
