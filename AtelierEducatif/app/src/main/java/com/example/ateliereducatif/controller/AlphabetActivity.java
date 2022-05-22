package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ateliereducatif.R;
import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AlphabetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        TextView myTitleText = findViewById(R.id.action_bar_title);
        myTitleText.setText("Alphabet");
        ImageView imageAlpha = findViewById(R.id.idAlphabet);
        Picasso.with(this).load("https://res.cloudinary.com/dyptj60q1/image/upload/v1653158880/Images/alphabet_aiuaxq.jpg").into(imageAlpha);

    }
}
