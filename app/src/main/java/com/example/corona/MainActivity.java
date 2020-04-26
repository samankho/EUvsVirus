package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private Button playbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragenActivity.punkte = 0;

        playbtn = (Button)findViewById(R.id.playbtn);
        playbtn.setOnClickListener(this::starteQuiz);
    }


    private void starteQuiz(View v)
    {
        Intent nextActivty = new Intent(this, FragenActivity.class);
        startActivity(nextActivty);
        finish();

    }

}


