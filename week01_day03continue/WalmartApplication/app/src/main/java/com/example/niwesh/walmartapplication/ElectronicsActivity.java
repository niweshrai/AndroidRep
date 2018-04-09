package com.example.niwesh.walmartapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ElectronicsActivity extends AppCompatActivity {

    static ElectronicsActivity electronics;
    static ArrayList<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        electronics = this;

        products = new ArrayList<Product>(Arrays.asList(
                new Product("Echo Dot - Voice control your music, Make calls, Get news, weather & more",44.99, "Black","alexa","Amazon001","Echo Dot is a hands-free smart speaker that you control using your voice. It connects to Alexa - a cloud based voice service to play music, make calls, check weather and news, set alarms, control smart home devices, and much more."),
                new Product("OnePlus 5T (Midnight Black 6GB RAM + 64GB memory)",329.99, "Midnight Black","oneplus5t","Amazon002","An immersive screen that pulls you in : The OnePlus 5T features a Full Optic AMOLED Display with an 18:9 aspect ratio, allowing for a more immersive viewing experience. It’s a clean and crisp front display that feels nearly boundless."),
                new Product("Samsung S19F350HNW 18.5-inch AH IPS LED Monitor (Black)[NOT A TV]",54.50, "Black","samsung_monitor","Amazon003","Super Slim Panel: At an incredibly slim 10 mm - as slender as a ballpoint pen - the one-piece panel is more than twice as thin as standard Samsung monitors."),
                new Product("OPTA SB-039 Bluetooth Fitnessband Smartwatch + All-in-One Activity Tracker",27.99, "Black","fitnessband_smartwatch","Amazon004","0.96inch Display: Time, date, steps, distance, calories, heart rate in real time, messages, call ID, movement recording etc. can be displayed on the screen, which makes it readily available for check and keeps track of your exercise progress and effect."),
                new Product("Canon EOS 1300D 18MP Digital SLR Camera",262.94, "Black","digital_camera","Amazon004","The EOS 1300D packs in all the fun of photography, which is why we recommend it to users looking for their very first EOS DSLR camera. It uses an 18-megapixel APS-C size sensor and the DIGIC 4+ image processor - which even professional photographers recognize as high performance with core features.")
        ));

       // ArrayAdapter<Product> adapter = new ElectronicAdapter(this, 0, products);

        ListView lv1 = (ListView) findViewById(R.id.electronics_custom_list_view);

        lv1.setAdapter(new ElectronicAdapter(ElectronicsActivity.this));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);

                Intent intent = new Intent(ElectronicsActivity.this, DetailedDescriptionActivity.class);
                intent.putExtra("title", product.getTitle());
                intent.putExtra("id", product.getItemid());
                intent.putExtra("color", product.getColor());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("image", product.getImage());
                intent.putExtra("detailedDescription", product.getDesc());

                startActivityForResult(intent,200);
            }
        });
    }
}
