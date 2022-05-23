package com.example.ateliereducatif.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ateliereducatif.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends BaseActivity {


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
        myTitleText.setText("Ecran de préférence");
    }

    public void conditionGenerale(View view)
    {
      intent = new Intent(this, PrivacyActivity.class).putExtra("name", "condition");
      startActivity(intent);
//      Log.d("test", "test");
    }

    public void politique(View view) {
      intent = new Intent(this, PrivacyActivity.class).putExtra("name", "politique");
      startActivity(intent);
//      Log.d("politique", "politique");
    }

    public void deconnexion(View view) {
      intent = new Intent(this, ConnexionActivity.class);
      startActivity(intent);
  //      Log.d("politique", "politique");
    }

    public void plusApplication(View view) {
      final String appPackageName = "com.kahoot.bignumbers"; // getPackageName() from Context or Activity object
      try {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
      } catch (android.content.ActivityNotFoundException anfe) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
      }
    }
}
