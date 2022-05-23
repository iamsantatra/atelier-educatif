package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.ateliereducatif.R;

public class PrivacyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_policy);

        TextView myTitleText = findViewById(R.id.action_bar_title);

        WebView webView=findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        if(getIntent().getExtras().getString("name").compareTo("politique") == 0) {
          myTitleText.setText("Politique de confidentialité");
          webView.loadUrl("file:///android_asset/privacy.html");
        } else {
          myTitleText.setText("Termes et conditions");
          webView.loadUrl("file:///android_asset/conditions.html");
        }
    }
}
