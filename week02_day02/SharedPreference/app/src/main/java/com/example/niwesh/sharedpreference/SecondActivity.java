package com.example.niwesh.sharedpreference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btn1;
    SharedPreferences spf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn1 = findViewById(R.id.logout);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Do you want to Logout?");

                AlertDialog.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==dialogInterface.BUTTON_POSITIVE){
                            dialogInterface.dismiss();
                            finish();
                            Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else if(i==dialogInterface.BUTTON_NEGATIVE){
                            dialogInterface.dismiss();
                        }
                    }
                };

                builder.setPositiveButton("Yes", listener);
                builder.setNegativeButton("No",listener);
                builder.show();
                spf = getSharedPreferences("spf", Context.MODE_PRIVATE);
                SharedPreferences.Editor spe = spf.edit();
                spe.clear();
                spe.commit();
            }
        });
    }
}
