package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ateliereducatif.R;
import com.example.ateliereducatif.adapter.RecitationAdapter;
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

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListeRecitationActivity extends AppCompatActivity {

  GridView youtube;
  YoutubeService yService;
  RecitationService rService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Init service
    Retrofit retrofitClient = RetrofitClient.getInstance();
    yService = retrofitClient.create(YoutubeService.class);
    rService = retrofitClient.create(RecitationService.class);

    youtube = findViewById(R.id.idYoutubeGrid);

    ArrayList<Youtube> youtubeArrayList = new ArrayList<Youtube>();
    Call<RecitationRep> call = rService.liste();
    call.enqueue(new Callback<RecitationRep>() {
      @Override
      public void onResponse(Call<RecitationRep> call, Response<RecitationRep> response) {
        System.out.println("aty");
        if(response.isSuccessful()) {
          List<Recitation> listeRec = (List<Recitation>) response.body().getData();
          for (Recitation rec :
            listeRec) {
              Call<Youtube> callYoutube = yService.getYoutube("https://www.youtube.com/oembed?url=http://www.youtube.com/watch?v="+rec.getLien());
              try {
                Youtube yt = callYoutube.execute().body();
                youtubeArrayList.add(new Youtube(yt.getTitle(), yt.getThumbnail_url()));

              } catch (Exception e) {
                e.printStackTrace();
              }
          }

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
      public void onFailure(Call<RecitationRep> call, Throwable t) {
        System.out.println("erreur" + t);
//          Toast.makeText(ConnexionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
    System.out.println(youtubeArrayList.size());
    RecitationAdapter rAdapter = new RecitationAdapter(this, youtubeArrayList);
    youtube.setAdapter(rAdapter);
  }
}
