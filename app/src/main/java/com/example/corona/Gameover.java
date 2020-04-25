package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gameover extends AppCompatActivity {

    private Button _nochmal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        _nochmal = (Button)findViewById(R.id.nochmal);
        _nochmal.setOnClickListener(this::loadMenue);

    }


    private void loadMenue(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

}
