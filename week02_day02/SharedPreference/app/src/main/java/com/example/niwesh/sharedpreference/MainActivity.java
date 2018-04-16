package com.example.niwesh.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText et1, et2;
    String email, password, getEmail, getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences spf2 = getSharedPreferences("spf", Context.MODE_PRIVATE);
        getEmail = spf2.getString("email","None");
        getPassword = spf2.getString("password","None");

        if (!getEmail.equals("None")&&!getPassword.equals("None")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else {

            setContentView(R.layout.activity_main);

            et1 = (TextInputEditText) findViewById(R.id.email_field);
            et2 = (TextInputEditText) findViewById(R.id.password_field);

            email = et1.getText().toString();
            password = et2.getText().toString();
        }
    }

    public void onLogin(View view){
        SharedPreferences sp = getSharedPreferences("spf", Context.MODE_PRIVATE);

        SharedPreferences.Editor spe = sp.edit();

        spe.putString("email",email);
        spe.putString("password",password);
        spe.commit();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void onForgotPassword(View view){
        Toast.makeText(this, "Please Try to Remember your password", Toast.LENGTH_LONG).show();
    }
}
