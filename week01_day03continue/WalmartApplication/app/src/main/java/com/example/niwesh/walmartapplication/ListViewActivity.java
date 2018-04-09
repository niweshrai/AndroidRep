package com.example.niwesh.walmartapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class ListViewActivity extends AppCompatActivity {

    ListView list;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = (ListView) findViewById(R.id.list_view);

        String path = "/storage/emulated/0/Samsung/";

        File f = new File(path);

        String[] files = f.list();

        final ArrayAdapter adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, files);

        list.setAdapter(adapter);
        list.setClickable(true);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "You have Selected : "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}