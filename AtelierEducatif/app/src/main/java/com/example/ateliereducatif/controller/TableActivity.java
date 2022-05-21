package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ateliereducatif.R;

public class TableActivity extends BaseActivity implements View.OnClickListener {

    // define the global variable

    // variable number1, number2 for input input number
    // Add_button, result textView

    EditText editText;
    Button button;
    TextView result;
    int ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.idBoutonTable);
        result = (TextView)findViewById(R.id.idTextTable);

        // set clickListener on button
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
      switch (v.getId()) {

        case R.id.idBoutonTable:
          StringBuffer buffer = new StringBuffer();
          int res;
          // get the input number from editText
          String fs = editText.getText().toString();
          // convert it to integer
          int n = Integer.parseInt(fs);
          // build the logic for table
          for (int i = 1; i <= 10; i++) {
            ans = (i * n);
            buffer.append(n + " X " + i
              + " = " + ans + "\n\n");
          }
          // set the buffer textview
          result.setText(buffer);
          break;
      }
    }
}
