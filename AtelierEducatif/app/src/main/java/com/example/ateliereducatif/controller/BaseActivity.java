package com.example.ateliereducatif.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ateliereducatif.R;

public class BaseActivity extends AppCompatActivity {

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case android.R.id.home:
        // app icon in action bar clicked; go home
        Intent intent1 = new Intent(this, MenuActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return true;
      case R.id.menuButton:
        Intent intent2 = new Intent(this, ConnexionActivity.class);
        startActivity(intent2);
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);

    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    actionBar.setCustomView(R.layout.actionbar);
    actionBar.setHomeAsUpIndicator(R.drawable.btn_back_150);
    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    // first parameter is the file for icon and second one is menu
    return super.onCreateOptionsMenu(menu);
  }
}
