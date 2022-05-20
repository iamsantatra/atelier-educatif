package com.example.ateliereducatif.background;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.ateliereducatif.adapter.RecitationAdapter;
import com.example.ateliereducatif.controller.ListeRecitationActivity;
import com.example.ateliereducatif.model.Youtube;

public class BackgroundService extends IntentService {

  public BackgroundService() {
    super("BackgroundService");
  }


  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
    int test = new Youtube().getYoutube().size();
    System.out.println("new Youtube().getYoutube().size()");
  }
}
