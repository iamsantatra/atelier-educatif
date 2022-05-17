package com.example.ateliereducatif.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;

    public static  Retrofit getInstance() {



        if(instance == null)
            instance = new Retrofit.Builder()
//                .baseUrl("http://127.0.0.1:3000/api/")
                    .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return instance;
    }
}
