package com.example.ateliereducatif.service;

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

    ArrayList<Youtube> youtubeArrayList = new ArrayList<Youtube>();
    Call<Youtube> call = yService.getYoutube("");
    call.enqueue(new Callback<Youtube>() {
      @Override
      public void onResponse(Call<Youtube> call, Response<Youtube> response) {
        System.out.println("ato");
        if(response.isSuccessful()) {
          List<Youtube> listeRec = (List<Youtube>) response.body();

          assertEquals(listeRec.get(0).getAuthor_name(), "Bouchoo!");
        }
        else {
          System.out.println("ato");
          try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
                                System.out.println(jObjError);
//              Toast.makeText(ConnexionActivity.this, jObjError.getString("message"), Toast.LENGTH_SHORT).show();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

      @Override
      public void onFailure(Call<Youtube> call, Throwable t) {
        System.out.println("ato");
        System.out.println("erreur" + t);
//          Toast.makeText(ConnexionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
//    assertEquals(youtubeArrayList.size(), 7);
  }
}
