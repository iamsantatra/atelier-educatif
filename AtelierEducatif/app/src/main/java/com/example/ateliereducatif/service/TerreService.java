package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.reponse.TerreRep;
import com.example.ateliereducatif.model.reponse.UtilisateurRep;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TerreService {

  static String BASE_URL = "terre/";

  //{{base_url_atelier}}terre/liste?page=0&size=1
  @GET(BASE_URL+"liste")
  Call<TerreRep> liste(@Query("page") int page, @Query("size") int size);
}
