package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.model.MathQuiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MathActivity extends BaseActivity implements View.OnClickListener {

    Button bouton1, bouton2, bouton3, bouton4;
    TextView question;
    int reponse;
    int etape;
    static final int NOMBRE_ETAPE = 8;
    int vrai, faux = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        etape = 0;

        TextView myTitleText = findViewById(R.id.action_bar_title);
        myTitleText.setText("Mathématique");

        bouton1 = findViewById(R.id.button1);
        bouton2 = findViewById(R.id.button2);
        bouton3 = findViewById(R.id.button3);
        bouton4 = findViewById(R.id.button4);

        genererQuestion();

        bouton1.setOnClickListener(this);
        bouton2.setOnClickListener(this);
        bouton3.setOnClickListener(this);
        bouton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      String bouton1S = (String) bouton1.getText();
      String bouton2S = (String) bouton2.getText();
      String bouton3S = (String) bouton3.getText();
      String bouton4S = (String) bouton4.getText();
      switch(v.getId()) {
        case R.id.button1:
          if(bouton1S.compareTo(""+reponse) == 0) {
            Toast.makeText(this, "Vrai", Toast.LENGTH_SHORT).show();
            vrai++;
          } else {
            Toast.makeText(this, "Faux", Toast.LENGTH_SHORT).show();
            faux++;
          }
          break;
        case R.id.button2:
          if(bouton2S.compareTo(""+reponse) == 0) {
            Toast.makeText(this, "Vrai", Toast.LENGTH_SHORT).show();
            vrai++;
          } else {
            Toast.makeText(this, "Faux", Toast.LENGTH_SHORT).show();
            faux++;
          }
          break;
        case R.id.button3:
          if(bouton3S.compareTo(""+reponse) == 0) {
            Toast.makeText(this, "Vrai", Toast.LENGTH_SHORT).show();
            vrai++;
          } else {
            Toast.makeText(this, "Faux", Toast.LENGTH_SHORT).show();
            faux++;
          }
          break;
        case R.id.button4:
          if(bouton4S.compareTo(""+reponse) == 0) {
            Toast.makeText(this, "Vrai", Toast.LENGTH_SHORT).show();
            vrai++;
          } else {
            Toast.makeText(this, "Faux", Toast.LENGTH_SHORT).show();
            faux++;
          }
          break;
      }
      etape++;
      if(etape < NOMBRE_ETAPE) {
        genererQuestion();
      } else {
        open(v);
      }
    }

    public void genererQuestion() {

      question = findViewById(R.id.questionMath);

      MathQuiz math = new MathQuiz();
      math.genererQuestion();
      reponse = math.getReponse();
      question.setText(math.getQuestion());

      bouton1.setText(String.valueOf(math.getListeReponse()[0]));
      bouton2.setText(String.valueOf(math.getListeReponse()[1]));
      bouton3.setText(String.valueOf(math.getListeReponse()[2]));
      bouton4.setText(String.valueOf(math.getListeReponse()[3]));
    }

  public void open(View view){
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    alertDialogBuilder.setMessage("Vrai: "+vrai+"\nFaux: "+faux).setTitle("Score");
    alertDialogBuilder.setCancelable(false);
      alertDialogBuilder.setPositiveButton("Recommencer",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface arg0, int arg1) {
            Intent intent = new Intent(MathActivity.this, MathActivity.class);
            startActivity(intent);
          }
        });

      alertDialogBuilder.setNegativeButton("Menu",new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          Intent intent = new Intent(MathActivity.this, MenuActivity.class);
          startActivity(intent);
        }
    });

    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();

    Button buttonPositive = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
    buttonPositive.setTextColor(ContextCompat.getColor(this, R.color.black));
    Button buttonNegative = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
    buttonNegative.setTextColor(ContextCompat.getColor(this, R.color.black));
  }
}
