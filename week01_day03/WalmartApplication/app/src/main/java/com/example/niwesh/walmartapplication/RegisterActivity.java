package com.example.niwesh.walmartapplication;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText et1,et2,et3,et4;
    String fname, lname, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et1 = (TextInputEditText) findViewById(R.id.first_name);
        et2 = (TextInputEditText) findViewById(R.id.last_name);
        et3 = (TextInputEditText) findViewById(R.id.email_register);
        et4 = (TextInputEditText) findViewById(R.id.password_register);
    }

    public void registeredMsg(View view){
        fname = et1.getText().toString();
        lname = et2.getText().toString();
        email = et3.getText().toString();
        password = et4.getText().toString();

        if(!fname.equals("")&&!lname.equals("")&&!email.equals("")&&!password.equals("")){
            MainActivity.person.add(new User(fname, lname, email, password));
            Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Failed:Fill All Details", Toast.LENGTH_LONG).show();
        }
    }
}
