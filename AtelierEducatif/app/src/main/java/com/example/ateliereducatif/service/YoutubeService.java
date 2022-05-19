package com.example.ateliereducatif.service;

import com.example.ateliereducatif.model.Youtube;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface YoutubeService {

  @GET()
  Call<Youtube> getYoutube(@Url String url);

}
