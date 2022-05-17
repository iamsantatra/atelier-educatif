package com.example.ateliereducatif.service;


import com.example.ateliereducatif.model.reponse.UtilisateurRep;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UtilisateurService {

    static String BASE_URL = "utilisateur/";

    @POST(BASE_URL+"connexion")
    Call<UtilisateurRep> connexion(@Body HashMap<String, String> connexionMap);
}
