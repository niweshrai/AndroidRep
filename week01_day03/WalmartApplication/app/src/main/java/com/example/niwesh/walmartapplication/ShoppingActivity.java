package com.example.niwesh.walmartapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
    }

    public void foodToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,SpinnerActivity.class);
        intent.putExtra("msg","Food");
        startActivity(intent);
        Toast.makeText(this, "You have selected Food category", Toast.LENGTH_LONG).show();
    }

    public void clothingToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,SpinnerActivity.class);
        intent.putExtra("msg","Food");
        startActivity(intent);
        Toast.makeText(this, "You have selected Clothing category", Toast.LENGTH_LONG).show();
    }

    public void beautyToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,SpinnerActivity.class);
        intent.putExtra("msg","Food");
        startActivity(intent);
        Toast.makeText(this, "You have selected Beauty category", Toast.LENGTH_LONG).show();
    }

    public void electronicsToast(View view){
        Intent intent = new Intent(ShoppingActivity.this,SpinnerActivity.class);
        intent.putExtra("msg","Food");
        startActivity(intent);
        Toast.makeText(this, "You have selected Electronics category", Toast.LENGTH_LONG).show();
    }
}
