package com.example.ateliereducatif.retrofit;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UtilisateurService {

    static String BASE_URL = "utilisateur/";

    @POST(BASE_URL+"connexion")
    Call<Void> connexion(@Body HashMap<String, String> connexionMap);
}
