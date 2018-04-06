package com.example.niwesh.counterapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button convert;
    EditText output;
    String strVal;
    double val;
    double outVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input_lbs);
        convert = (Button) findViewById(R.id.convert_btn);
        output = (EditText) findViewById(R.id.output_kgs);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = Double.parseDouble(input.getText().toString());
                outVal = val/2.2;
                DecimalFormat twoForm = new DecimalFormat("#.##");
                outVal = Double.valueOf(twoForm.format(outVal));
                strVal = String.valueOf(outVal);
                output.setText(strVal);
            }
        });
    }
}
