package com.example.niwesh.webviewintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Niwesh Chandra Rai on 4/15/2018.
 */

public class MainActivity extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_layout);

        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/login.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.addJavascriptInterface(MainActivity.this,"myInterface");


       }

        @JavascriptInterface

        public void displayMsg(String user, String pwd) {

            if (user.equals("a") && pwd.equals("a")) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Login Credential", Toast.LENGTH_LONG).show();
            }
        }
    }



