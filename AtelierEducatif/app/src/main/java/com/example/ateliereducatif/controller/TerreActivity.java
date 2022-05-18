package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.model.Terre;
import com.example.ateliereducatif.model.Utilisateur;
import com.example.ateliereducatif.model.reponse.TerreRep;
import com.example.ateliereducatif.model.reponse.UtilisateurRep;
import com.example.ateliereducatif.service.TerreService;
import com.example.ateliereducatif.service.UtilisateurService;
import com.example.ateliereducatif.utils.RetrofitClient;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TerreActivity extends AppCompatActivity {

    ImageButton boutonPrev, boutonNext;
    TextView textTitre, textDescription;
    ImageView imageTerre;

    TerreService tService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terre);

        //Init service
        Retrofit retrofitClient = RetrofitClient.getInstance();
        tService = retrofitClient.create(TerreService.class);


        //Init view
        textTitre = (TextView) findViewById(R.id.terre_titre);
        textDescription = (TextView) findViewById(R.id.terre_description);
        imageTerre = (ImageView)  findViewById(R.id.image_terre);

        Call<TerreRep> call = tService.liste(0, 1);
        call.enqueue(new Callback<TerreRep>() {
        @Override
        public void onResponse(Call<TerreRep> call, Response<TerreRep> response) {
          if(response.isSuccessful()) {
            Terre terre = (Terre) response.body().getTerres().get(0);
            textTitre.setText(terre.getTitre());
            textDescription.setText(terre.getDescription());
            Picasso.with(getApplicationContext()).load(terre.getImage()).into(imageTerre);
//            boutonNext.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//
//              }
//            });
          }
          else {
            try {
              JSONObject jObjError = new JSONObject(response.errorBody().string());
              //                    System.out.println(jObjError);
//              Toast.makeText(ConnexionActivity.this, jObjError.getString("message"), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
            }
          }
        }

        @Override
        public void onFailure(Call<TerreRep> call, Throwable t) {
          System.out.println("erreur" + t);
//          Toast.makeText(ConnexionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
      });
    }
}
