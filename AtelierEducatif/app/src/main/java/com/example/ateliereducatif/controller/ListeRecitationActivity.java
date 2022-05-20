package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ateliereducatif.R;
import com.example.ateliereducatif.adapter.EntiteAdapter;
import com.example.ateliereducatif.adapter.RecitationAdapter;
import com.example.ateliereducatif.background.BackgroundService;
import com.example.ateliereducatif.model.Entite;
import com.example.ateliereducatif.model.Recitation;
import com.example.ateliereducatif.model.Terre;
import com.example.ateliereducatif.model.Youtube;
import com.example.ateliereducatif.model.reponse.RecitationRep;
import com.example.ateliereducatif.model.reponse.TerreRep;
import com.example.ateliereducatif.service.RecitationService;
import com.example.ateliereducatif.service.TerreService;
import com.example.ateliereducatif.service.YoutubeService;
import com.example.ateliereducatif.utils.RetrofitClient;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

  GridView youtube;
  YoutubeService yService;
  RecitationService rService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Intent intent = new Intent(ListeRecitationActivity.this, BackgroundService.class);
    startService(intent);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
    myTitleText.setText("Récitation et comptine");
    //Init service
    Retrofit retrofitClient = RetrofitClient.getInstance();
    yService = retrofitClient.create(YoutubeService.class);
    rService = retrofitClient.create(RecitationService.class);

    youtube = findViewById(R.id.idYoutubeGrid);

//    ArrayList<Youtube> youtubeArrayList = new ArrayList<Youtube>();
//    Call<RecitationRep> call = rService.liste();
//    call.enqueue(new Callback<RecitationRep>() {
//      @Override
//      public void onResponse(Call<RecitationRep> call, Response<RecitationRep> response) {
//        if(response.isSuccessful()) {
//          List<Recitation> listeRec = (List<Recitation>) response.body().getData();
//          ArrayList<Youtube> listeYoutube = new Youtube().getYoutube(listeRec, yService);
//          System.out.println(listeYoutube.get(0).getTitle());
//          RecitationAdapter rAdapter = new RecitationAdapter(ListeRecitationActivity.this, listeYoutube);
//          youtube.setAdapter(rAdapter);
//        }
//        else {
//          try {
//            JSONObject jObjError = new JSONObject(response.errorBody().string());
//            //                    System.out.println(jObjError);
////              Toast.makeText(ConnexionActivity.this, jObjError.getString("message"), Toast.LENGTH_SHORT).show();
//          } catch (Exception e) {
//          }
//        }
//      }
//
//      @Override
//      public void onFailure(Call<RecitationRep> call, Throwable t) {
//        System.out.println("erreur" + t);
////          Toast.makeText(ConnexionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//      }
//    });



//      RecitationAdapter rAdapter = new RecitationAdapter(ListeRecitationActivity.getContext(), new Youtube().getYoutube());
//      youtube.setAdapter(rAdapter);

  }
}
