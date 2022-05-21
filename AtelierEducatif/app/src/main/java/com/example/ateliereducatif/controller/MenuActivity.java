package com.example.ateliereducatif.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;

public class MenuActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    Button boutonTerre, boutonRecitation, boutonAnimaux, boutonFruitEtLegume, boutonAlphabet, boutonTable;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

      ActionBar actionBar = getSupportActionBar();
      actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
      actionBar.setCustomView(R.layout.actionbar);
      TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
      myTitleText.setText("Menu");

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        // getting data from shared prefs and
        // storing it in our string variable.

//        Toast.makeText(this, sharedpreferences.getString("NOM_KEY", null), Toast.LENGTH_SHORT).show();

      boutonTerre = (Button) findViewById(R.id.notre_planete);
      boutonTerre.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MenuActivity.this, TerreActivity.class);
          startActivity(intent);
          finish();
        }
      });

      boutonRecitation = (Button) findViewById(R.id.recitation);
      boutonRecitation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MenuActivity.this, ListeRecitationActivity.class);
          startActivity(intent);
          finish();
        }
      });

      boutonAnimaux = (Button) findViewById(R.id.animaux);
      boutonAnimaux.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MenuActivity.this, ListeAnimauxActivity.class).putExtra("click", "animaux");
          startActivity(intent);
          finish();
        }
      });

      boutonFruitEtLegume = (Button) findViewById(R.id.fruitEtLegume);
      boutonFruitEtLegume.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MenuActivity.this, ListeAnimauxActivity.class).putExtra("click", "fruitEtLegume");
          startActivity(intent);
          finish();
        }
      });
      boutonAlphabet = (Button) findViewById(R.id.alphabet);
      boutonAlphabet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MenuActivity.this, AlphabetActivity.class);
          startActivity(intent);
          finish();
        }
      });

      boutonTable = (Button) findViewById(R.id.table_multiplication);
      boutonTable.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MenuActivity.this, TableActivity.class);
          startActivity(intent);
          finish();
        }
      });
    }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    // first parameter is the file for icon and second one is menu
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    // We are using switch case because multiple icons can be kept
    switch (item.getItemId()) {
      case R.id.logoutButton:
        SharedPreferences settings = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
        Intent intent = new Intent(MenuActivity.this, ConnexionActivity.class);
        startActivity(intent);
        finish();
        break;
    }
    return super.onOptionsItemSelected(item);
  }
}
