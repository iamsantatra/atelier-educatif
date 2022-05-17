package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.reponse.UtilisateurRep;
import com.example.ateliereducatif.utils.RetrofitClient;

import junit.framework.TestCase;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UtilisateurServiceTest extends TestCase {

    @Test
    public void testConnexion() throws Exception {
        //Init service
        Retrofit retrofitClient = RetrofitClient.getInstance();
        UtilisateurService uService = retrofitClient.create(UtilisateurService.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("nomUtilisateur", "leo2018");
        map.put("motDePasse", "1234568");
        Call<UtilisateurRep> call = uService.connexion(map);

        try {
            //Magic is here at .execute() instead of .enqueue()
            Response<UtilisateurRep> response = call.execute();
            UtilisateurRep authResponse = response.body();

            if(response.isSuccessful()) {
            }
            else {
                JSONObject jObjError = new JSONObject(response.errorBody().string());
                System.out.println(jObjError);
                assertEquals(jObjError.getString("message"), "Mt de passe incorrect");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
