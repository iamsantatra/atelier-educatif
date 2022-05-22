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

public class BaseListActivity extends AppCompatActivity {

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case android.R.id.home:
        // app icon in action bar clicked; go home
        Intent intent1 = new Intent(this, MenuActivity.class);
        startActivity(intent1);
        return true;
      case R.id.menuButton:
        Intent intent2 = new Intent(this, SettingsActivity.class);
        startActivity(intent2);
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
    getMenuInflater().inflate(R.menu.liste_menu, menu);
    // first parameter is the file for icon and second one is menu
    return super.onCreateOptionsMenu(menu);
  }
}
