package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ateliereducatif.R;
import android.os.Bundle;
import android.widget.TextView;

public class AlphabetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        TextView myTitleText = findViewById(R.id.action_bar_title);
        myTitleText.setText("Alphabet");
    }
}
