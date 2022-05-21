package com.example.ateliereducatif.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TerreActivity extends BaseActivity {

    ImageButton boutonNext, boutonPrev;
    TextView textTitre, textDescription;
    ImageView imageTerre;
    List<Terre> listeTerre;
    TerreService tService;

    int increment = 0;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terre);

        TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
        myTitleText.setText("Notre planète");

        getTerre();
    }

    public void getTerre() {

      //Init service
      Retrofit retrofitClient = RetrofitClient.getInstance();
      tService = retrofitClient.create(TerreService.class);

      //Init view
      textTitre = (TextView) findViewById(R.id.terre_titre);
      textDescription = (TextView) findViewById(R.id.terre_description);

      imageTerre = (ImageView) findViewById(R.id.image_terre);
      boutonNext = (ImageButton) findViewById(R.id.next);
      boutonPrev = (ImageButton) findViewById(R.id.prev);

      Call<TerreRep> call = tService.liste();
      call.enqueue(new Callback<TerreRep>() {
        @Override
        public void onResponse(Call<TerreRep> call, Response<TerreRep> response) {
          if(response.isSuccessful()) {
            List<Terre> listeTerre = (List<Terre>) response.body().getTerres();
            Terre t = (Terre) listeTerre.get(0);
            System.out.println(t.getTitre());
            textTitre.setText(t.getTitre());
            textDescription.setText(t.getDescription());
            Picasso.with(getApplicationContext()).load(t.getImage()).into(imageTerre);
            boutonNext.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                if(increment<response.body().getTotalPages()) {
                  boutonPrev.setVisibility(View.VISIBLE);
                  increment++;
                  textTitre.setText(listeTerre.get(increment).getTitre());
                  textDescription.setText(listeTerre.get(increment).getDescription());
                  Picasso.with(getApplicationContext()).load(listeTerre.get(increment).getImage()).into(imageTerre);
                  if(increment == response.body().getTotalPages()-1) {
                    boutonNext.setVisibility(View.GONE);
                  }
                }
              }
            });

            boutonPrev.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                if(increment>0) {
                  boutonNext.setVisibility(View.VISIBLE);
                  increment--;
                  textTitre.setText(listeTerre.get(increment).getTitre());
                  textDescription.setText(listeTerre.get(increment).getDescription());
                  Picasso.with(getApplicationContext()).load(listeTerre.get(increment).getImage()).into(imageTerre);
                  if(increment == 0) {
                    boutonPrev.setVisibility(View.GONE);
                  }
                }
              }
            });
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
