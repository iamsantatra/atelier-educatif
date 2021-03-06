package com.example.ateliereducatif.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
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
import com.example.ateliereducatif.fragment.MathFragment;

public class MenuActivity extends BaseActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    Button boutonTerre, boutonRecitation, boutonAnimaux, boutonFruitEtLegume, boutonAlphabet, boutonTable, boutonQuiz;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        if(getIntent().getExtras() != null) {
          addNotification();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
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

      boutonQuiz = (Button) findViewById(R.id.quiz);
      boutonQuiz.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(getApplicationContext(), MathActivity.class);
          startActivity(intent);
          finish();
        }
      });
    }

  private void addNotification() {
    NotificationCompat.Builder builder =
      new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_boy)
        .setContentTitle("Sauvons la plan??te Terre!")
        .setContentText("D??couvrez les gestes simples ?? adopter au quotidien");

    Intent notificationIntent = new Intent(this, TerreActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
      PendingIntent.FLAG_UPDATE_CURRENT);
    builder.setContentIntent(contentIntent);

    // Add as notification
    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(0, builder.build());
  }
}
