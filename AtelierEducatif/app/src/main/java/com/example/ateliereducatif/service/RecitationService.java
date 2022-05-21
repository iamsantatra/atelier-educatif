package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.reponse.EntiteRep;
import com.example.ateliereducatif.model.reponse.RecitationRep;
import com.example.ateliereducatif.model.reponse.YoutubeRep;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecitationService {
  static String BASE_URL = "recitation/";

  @GET(BASE_URL+"liste")
  Call<RecitationRep> liste();

  @GET(BASE_URL+"liste-youtube")
  Call<YoutubeRep> listeYoutube();
}
