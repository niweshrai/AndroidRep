package com.example.niwesh.walmartapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        tv1 = findViewById(R.id.show_login_email);

        Intent intent = getIntent();
        String op1 = intent.getStringExtra("first");
        String op2 = intent.getStringExtra("last");
        tv1.setText(op1+" "+op2);
    }

    public void foodToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,CustomListActivity.class);
        intent.putExtra("food1","Welcome to Food Category");
        startActivity(intent);
        Toast.makeText(this, "You have selected Food category", Toast.LENGTH_LONG).show();
    }

    public void clothingToast(View view){
        Intent intent = new Intent(ShoppingActivity.this, ListViewActivity.class);
        intent.putExtra("clothing","Welcome to Clothing Category");
        startActivity(intent);
        Toast.makeText(this, "You have selected Clothing category", Toast.LENGTH_LONG).show();
    }

    public void beautyToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,SpinnerActivity.class);
        intent.putExtra("beauty","Welcome to Beauty Category");
        startActivity(intent);
        Toast.makeText(this, "You have selected Beauty category", Toast.LENGTH_LONG).show();
    }

    public void electronicsToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,ElectronicsActivity.class);
        intent.putExtra("electronics","Welcome to Electronics Category");
        startActivity(intent);
        Toast.makeText(this, "You have selected Electronics category", Toast.LENGTH_LONG).show();
    }
}
