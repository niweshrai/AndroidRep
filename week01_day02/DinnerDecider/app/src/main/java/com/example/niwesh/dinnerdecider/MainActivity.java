package com.example.niwesh.dinnerdecider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random randomGenerator;
    EditText getFoodRef;
    Button add, decide;
    TextView display;
    String displayfood, newFood;
    ArrayList<String> dine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //generate randomGenerate object
        randomGenerator = new Random();

        add = (Button) findViewById(R.id.addFood_btn);
        decide = (Button) findViewById(R.id.decide_btn);
        display = (TextView) findViewById(R.id.text_food);
        getFoodRef = (EditText) findViewById(R.id.edit_food);

        dine = new ArrayList<String>(Arrays.asList("Hamburger","Pizza",
                "Pizza","Mexican","American","Chinese"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFood = String.valueOf(getFoodRef.getText());
                if (newFood.equals("")) {
                    Toast.makeText(getApplicationContext(), "Failed to Add", Toast.LENGTH_LONG).show();
                }
                else {
                        dine.add(newFood);
                        Log.e("here","hollolkj");
                        Toast.makeText(getApplicationContext(), "Add Successfully", Toast.LENGTH_LONG).show();
                    }
                getFoodRef.setText("");
            }
        });

        decide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = randomGenerator.nextInt(dine.size());
                String s = String.valueOf(dine.size());
                Log.e("here",s);
                displayfood = dine.get(index);
                display.setText(displayfood);
            }
        });


    }
}
