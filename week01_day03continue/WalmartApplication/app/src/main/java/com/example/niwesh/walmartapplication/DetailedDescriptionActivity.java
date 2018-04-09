package com.example.niwesh.walmartapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_electronics_view);

        ImageView imageView = (ImageView) findViewById(R.id.item_image);
        TextView titletext = (TextView) findViewById(R.id.item_title);
        TextView idtext = (TextView) findViewById(R.id.item_id);
        TextView colortext = (TextView) findViewById(R.id.item_color);
        TextView pricetext = (TextView) findViewById(R.id.item_price);
        //TextView description = (TextView) findViewById(R.id.item_description);
        TextView detailedDescriptiontext = (TextView) findViewById(R.id.item_detail_description);


        Intent intent = getIntent();

        String image = intent.getStringExtra("image");
        String title = intent.getStringExtra("title");
        String id = intent.getStringExtra("id");
        String color = intent.getStringExtra("color");
        Double price = intent.getDoubleExtra("price",0.0);
        String description = intent.getStringExtra("detailedDescription");

        int imageID = this.getResources().getIdentifier(image, "drawable", this.getPackageName());
        imageView.setImageResource(imageID);

        titletext.setText(title);
        idtext.setText("Walmart id : "+id);
        colortext.setText("Color : "+color);
        pricetext.setText("Price : $ "+Double.toString(price));
        detailedDescriptiontext.setText(description);
    }
}
