package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.Utilisateur;
import com.example.ateliereducatif.model.reponse.UtilisateurRep;
import com.example.ateliereducatif.utils.RetrofitClient;

import junit.framework.TestCase;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UtilisateurServiceTest {

    @Test
    public void testConnexion() throws Exception {

      Retrofit retrofitClient = RetrofitClient.getInstance();
      UtilisateurService uService = retrofitClient.create(UtilisateurService.class);
        //Init service
      HashMap<String, String> map = new HashMap<>();
      map.put("nomUtilisateur", "leo2018");
      map.put("motDePasse", "12345678");

      Call<UtilisateurRep> call = uService.connexion(map);
      call.enqueue(new Callback<UtilisateurRep>() {
        @Override
        public void onResponse(Call<UtilisateurRep> call, Response<UtilisateurRep> response) {
          System.out.println("ato");
          if(response.isSuccessful()) {
            UtilisateurRep resultat = response.body();
//                  Utilisateur user = (Utilisateur) resultat.getData();
            Utilisateur user = (Utilisateur) response.body().getUtilisateur();
//                    System.out.println(user.getNom());
//                    Utilisateur user = (Utilisateur) objectUser;
////                    Toast.makeText(ConnexionActivity.this,  user.getNom(), Toast.LENGTH_SHORT).show();

//                    editor.apply();
          }
          else {

            try {
              JSONObject jObjError = new JSONObject(response.errorBody().string());
              //                    System.out.println(jObjError)
            } catch (Exception e) {
            }
          }
        }

        @Override
        public void onFailure(Call<UtilisateurRep> call, Throwable t) {
          System.out.println("erreur" + t);

        }
      });
    }
}
