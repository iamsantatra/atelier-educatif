package com.example.ateliereducatif.service;

import android.util.Log;

import com.example.ateliereducatif.model.Recitation;
import com.example.ateliereducatif.model.Youtube;
import com.example.ateliereducatif.model.reponse.RecitationRep;
import com.example.ateliereducatif.model.reponse.UtilisateurRep;
import com.example.ateliereducatif.utils.RetrofitClient;

import junit.framework.TestCase;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecitationServiceTest extends TestCase {

  @Test
  public void testListe() throws Exception {

    //Init service
    Retrofit retrofitClient = RetrofitClient.getInstance();
    RecitationService rService = retrofitClient.create(RecitationService.class);
    YoutubeService yService = retrofitClient.create(YoutubeService.class);

    String url = "https://www.youtube.com/oembed?url=http://www.youtube.com/watch?v="+"gaRhNHM2lZo";

//    Call<Youtube> callYoutube = yService.getYoutube(url);
    Call<RecitationRep> callRecitation = rService.liste();
    try {
      Response<RecitationRep> responseRec = callRecitation.execute();
      List<Recitation> listRec = responseRec.body().getData();
      for(Recitation rec: listRec) {
        Call<Youtube> callYoutube = yService.getYoutube("https://www.youtube.com/oembed?url=http://www.youtube.com/watch?v="+rec.getLien());
        System.out.println(callYoutube.request().toString());
        Response<Youtube> responseYoutube = callYoutube.execute();
        System.out.println(responseYoutube.body().getTitle());
      }
    } catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
