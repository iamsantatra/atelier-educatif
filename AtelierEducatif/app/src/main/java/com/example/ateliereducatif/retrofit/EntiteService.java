package com.example.ateliereducatif.retrofit;

import com.example.ateliereducatif.model.EntiteRep;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EntiteService {
  static String BASE_URL = "entite/";

  @GET(BASE_URL+"liste_animaux")
  Call<EntiteRep> liste_animaux();
}
