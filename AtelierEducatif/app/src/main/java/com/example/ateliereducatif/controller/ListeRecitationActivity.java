package com.example.ateliereducatif.controller;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.adapter.RecitationAdapter;
import com.example.ateliereducatif.model.Youtube;
import com.example.ateliereducatif.model.reponse.YoutubeRep;
import com.example.ateliereducatif.service.RecitationService;
import com.example.ateliereducatif.utils.RetrofitClient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListeRecitationActivity extends BaseActivity {

  GridView youtubeGrid;
  List<Youtube> yListe;
  RecitationService recitationService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_liste_recitation);
    TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
    myTitleText.setText("Récitation et comptine");

    youtubeGrid = findViewById(R.id.idYoutubeGrid);

    getYoutube();

    youtubeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View v, int i, long id) {
        Intent intent = new Intent(ListeRecitationActivity.this, RecitationActivity.class).putExtra("data", yListe.get(i));
        startActivity(intent);
      }
    });
  }

  public void getYoutube() {

    Retrofit retrofitClient = RetrofitClient.getInstance();
    recitationService = retrofitClient.create(RecitationService.class);
    Call<YoutubeRep> call = recitationService.listeYoutube();
    System.out.println(call.request().toString());
    call.enqueue(new Callback<YoutubeRep>() {
      @Override
      public void onResponse(Call<YoutubeRep> call, Response<YoutubeRep> response) {
        if (response.isSuccessful()) {
          yListe = response.body().getData();
          RecitationAdapter rAdapter = new RecitationAdapter(ListeRecitationActivity.this, (ArrayList<Youtube>) yListe);
          youtubeGrid.setAdapter(rAdapter);
        } else {
          try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
            System.out.println(jObjError);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

      @Override
      public void onFailure(Call<YoutubeRep> call, Throwable t) {
        System.out.println("erreur" + t);
//        Toast.makeText(ListeAnimauxActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
