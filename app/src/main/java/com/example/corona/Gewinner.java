package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gewinner extends AppCompatActivity {

    private Button _nochmal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gewinner);


        _nochmal = (Button)findViewById(R.id.nochmal);
        _nochmal.setOnClickListener(this::loadMenue);
    }

    private void loadMenue(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
