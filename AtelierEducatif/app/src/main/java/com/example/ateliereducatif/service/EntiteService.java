package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.reponse.EntiteRep;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntiteService {
  static String BASE_URL = "entite/";

  @GET(BASE_URL+"liste_animaux")
  Call<EntiteRep> liste_animaux();
}
