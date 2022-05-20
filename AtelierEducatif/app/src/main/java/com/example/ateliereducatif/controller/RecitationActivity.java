package com.example.ateliereducatif.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.model.Youtube;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class RecitationActivity extends AppCompatActivity {

    Youtube youtube;
    TextView titre;

    private YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recitation);

        Intent intent = getIntent();
        titre = findViewById(R.id.idTitreYoutube);
        if(intent.getExtras() != null) {
          youtube = (Youtube) intent.getSerializableExtra("data");
          titre.setText(youtube.getTitle());
        }

        youTubePlayerView = findViewById(R.id.yt);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
          @Override
          public void onReady(@NonNull YouTubePlayer youTubePlayer) {
            String videoId = youtube.getLien();
            youTubePlayer.loadVideo(videoId, 0);
          }
        });
    }
}
