package com.example.corona;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.util.Random;

public class FragenActivity extends Activity implements View.OnClickListener
{
    private static int aktuelleFrageCount;
    private static int maximaleAnzahlFragen;
    public static int punkte;

    private TextView _aktuelleFrage;
    private TextView _punktzahl;
    private Button _antwortbtn1, _antwortbtn2, _antwortbtn3, _antwortbtn4;
    private String[][] _fragenSammlung;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragen);

        _aktuelleFrage = (TextView) findViewById(R.id.aktuelleFrage);
        _punktzahl = (TextView) findViewById(R.id.aktuellePunkte);

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


        _fragenSammlung = Questions.Fragen;
        maximaleAnzahlFragen = _fragenSammlung.length;

        ladeFrage();

    }

    // Lädt die nächste Frage und ihre Antwortmöglichkeiten
    private void ladeFrage()
    {
        // Aktualisiere aktuelle Punktzahl
        _punktzahl.setText("PUNKTE: " + punkte);

        // Alle Fragen richtig beantwortet?
        if(aktuelleFrageCount == maximaleAnzahlFragen)
            startActivity(new Intent(this, Gewinner.class));

        String aktuelleFrage = _fragenSammlung[aktuelleFrageCount][0];
        String richtigeAntwort1 = _fragenSammlung[aktuelleFrageCount][1];
        String falscheAntwort2 = _fragenSammlung[aktuelleFrageCount][2];
        String falscheAntwort3 = _fragenSammlung[aktuelleFrageCount][3];
        String falscheAntwort4 = _fragenSammlung[aktuelleFrageCount][4];

        _aktuelleFrage.setText(aktuelleFrage);

        // Zufällige Anordnungen der Antworten (4!/3!)
        int randomAnordnung = new Random().nextInt(4) + 1;

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

        switch(v.getId())
        {
            case R.id.antwortbtn1:
                if(isCorrect(_antwortbtn1.getText().toString()))
                {
                    punkte++;
                    aktuelleFrageCount++;
                    ladeFrage();
                }
                else
                {
                    punkte = aktuelleFrageCount;
                    startActivity(new Intent(this, Gameover.class));
                }
                break;

                case R.id.antwortbtn2:
                if(isCorrect(_antwortbtn2.getText().toString()))
                {
                    punkte++;
                    aktuelleFrageCount++;
                    ladeFrage();
                }
                else
                {
                    punkte = aktuelleFrageCount;
                    startActivity(new Intent(this, Gameover.class));
                }
                break;

            case R.id.antwortbtn3:
                if(isCorrect(_antwortbtn3.getText().toString()))
                {
                    punkte++;
                    aktuelleFrageCount++;
                    ladeFrage();
                }
                else
                {
                    punkte = aktuelleFrageCount;
                    startActivity(new Intent(this, Gameover.class));
                }
                break;

            case R.id.antwortbtn4:
                if(isCorrect(_antwortbtn4.getText().toString()))
                {
                    punkte++;
                    aktuelleFrageCount++;
                    ladeFrage();
                }
                else
                {
                    punkte = aktuelleFrageCount;
                    startActivity(new Intent(this, Gameover.class));
                }
                break;
        }
    }


    // Überprüfe, ob geklickter Buttontext der korrekten Antwort entspricht
    private boolean isCorrect(String buttontext)
    {
        if(_fragenSammlung[aktuelleFrageCount][1].equals(buttontext))
            return true;

        return false;
    }

}
