package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.Entite;
import com.example.ateliereducatif.model.reponse.EntiteRep;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EntiteService {
  static String BASE_URL = "entite/";

  @GET(BASE_URL+"liste_animaux")
  Call<EntiteRep> liste_animaux();

  @GET(BASE_URL+"liste_fruitsEtLegumes")
  Call<EntiteRep> liste_fruitsEtLegumes();

}
