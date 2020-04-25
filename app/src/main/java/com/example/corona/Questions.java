package com.example.corona;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questions
{

    private String[][] fragen;
    private Scanner zeilenscan;
    private File questionsfile;

    public Questions()
    {
        this.fragen = new String[1][5]; // TODO: Anzahl angeben
        fillQuestions();

    }

    // Methode zum Auffülen der Fragen
    private void fillQuestions()
    {
        fragen[0][0] = "Begrüssung?";
        fragen[0][1] = "Begrüssung?";
        fragen[0][2] = "Begrüssung?";
        fragen[0][3] = "Begrüssung?";
        fragen[0][4] = "Begrüssung?";
    }
/*
    private void fillQuestionList(File file) throws FileNotFoundException
    {

        questionsfile = new File("../../../../../Corona/Fragen");
        zeilenscan = new Scanner(questionsfile);

        // Scanner holt sich die Fragen aus dem erstellten Textfile und speichert sie in das 2D-Array
        for(int i = 0; i < fragen.length; i++)
        {
            // -- 5 Spalten (Ein Frage-Antwort-Paket besteht aus 5 Strings)
            for(int j = 0; j < 5; j++)
            {
                fragen[i][j] = zeilenscan.nextLine();
            }
        }

        zeilenscan.close();
    }

    */


// Liefert die Liste der vorhandenen Fragen
    public String[][] getFragen()
    {
        return fragen;
    }



}
