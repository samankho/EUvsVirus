package com.example.corona;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FragenActivity extends Activity implements View.OnClickListener {

    private static int aktuelleFrageCount;
    private static int maximaleAnzahlFragen;
    private int punkte;

    private TextView _aktuelleFrage;
    private Button _antwortbtn1, _antwortbtn2, _antwortbtn3, _antwortbtn4;
    private String[][] _fragenSammlung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragen);

        _aktuelleFrage = (TextView) findViewById(R.id.aktuelleFrage);

        // Initialisiere antwortButtons
        _antwortbtn1 = (Button) findViewById(R.id.antwortbtn1);
        _antwortbtn2 = (Button) findViewById(R.id.antwortbtn2);
        _antwortbtn3 = (Button) findViewById(R.id.antwortbtn3);
        _antwortbtn4 = (Button) findViewById(R.id.antwortbtn4);

        // Adde einen OnClickListener
        _antwortbtn1.setOnClickListener(this);
        _antwortbtn2.setOnClickListener(this);
        _antwortbtn3.setOnClickListener(this);
        _antwortbtn4.setOnClickListener(this);

        _fragenSammlung = new String[][]{
                {"Frage?", "richtige Antwort", "falsche Antwort1", "falsche Antwort 2", "falsche Antwort 3"}
        };  //new Questions().getFragen();

        maximaleAnzahlFragen = _fragenSammlung.length;

        ladeFrage();

    }

    private void ladeFrage()
    {
        String aktuelleFrage = _fragenSammlung[aktuelleFrageCount][0];
        String richtigeAntwort1 = _fragenSammlung[aktuelleFrageCount][1];
        String falscheAntwort2 = _fragenSammlung[aktuelleFrageCount][2];
        String falscheAntwort3 = _fragenSammlung[aktuelleFrageCount][3];
        String falscheAntwort4 = _fragenSammlung[aktuelleFrageCount][4];

        _aktuelleFrage.setText(aktuelleFrage);

        // Zufällige Anordnungen der Antworten (4!/3!)
        int randomAnordnung = new Random().nextInt(8) + 1;

        switch(randomAnordnung)
        {
            case 1:
                _antwortbtn1.setText(richtigeAntwort1);
                _antwortbtn2.setText(falscheAntwort2);
                _antwortbtn3.setText(falscheAntwort3);
                _antwortbtn4.setText(falscheAntwort4);
                break;

            case 2:
                _antwortbtn1.setText(falscheAntwort4);
                _antwortbtn2.setText(richtigeAntwort1);
                _antwortbtn3.setText(falscheAntwort2);
                _antwortbtn4.setText(falscheAntwort3);
                break;

            case 3:
                _antwortbtn1.setText(falscheAntwort3);
                _antwortbtn2.setText(falscheAntwort4);
                _antwortbtn3.setText(richtigeAntwort1);
                _antwortbtn4.setText(falscheAntwort2);
                break;

            case 4:
                _antwortbtn1.setText(falscheAntwort2);
                _antwortbtn2.setText(falscheAntwort3);
                _antwortbtn3.setText(falscheAntwort4);
                _antwortbtn4.setText(richtigeAntwort1);
                break;



        }

    }



    // Antwort wird geklickt
    @Override
    public void onClick(View v)
    {
        ladeFrage();
    }

}
