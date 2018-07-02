package com.bicodetech.cineman;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        ArrayList cast = new ArrayList<String>();
        cast.add("Caleb Baird");
        cast.add("Sam Gay");
        cast.add("Sam Haymond");
        cast.add("Chase Haymond");
        Result r1 = new Result("Home Alone", "Netflix", "Boy is left at home", "PG", "120", "Horror", "1990", "Christopher Columbus", cast, 0, 0);
        Result r2 = new Result("Home Alone", "Amazon Prime", "Boy is left at home", "PG", "120", "Horror", "1990", "Christopher Columbus", cast, 0, 0);
        Result r3 = new Result("Home Alone", "Hulu", "Boy is left at home", "PG", "120", "Horror", "1990", "Christopher Columbus", cast, 0, 0);
        Result r4 = new Result("Star Wars", "Netflix", "Jedi's rule the galaxy", "PG", "120", "Sci-Fi", "1990", "George Lucas", cast, 15, 100);
        Result r5 = new Result("Star Wars", "Amazon Prime", "Jedi's rule the galaxy", "PG", "120", "Sci-Fi", "1990", "George Lucas", cast, 15, 100);
        Result r6 = new Result("Star Wars", "Hulu", "Jedi's rule the galaxy", "PG", "120", "Sci-Fi", "1990", "George Lucas", cast, 15, 100);
        ArrayList results = new ArrayList<Result>;
        results.add(r1);
        results.add(r2);
        results.add(r3);
        results.add(r4);
        results.add(r5);
        results.add(r6);
        List<CombinedResults> combinedResults = combineResults(results);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    private ArrayList<CombinedResults> combineResults(ArrayList<Result> results) {
        ArrayList combinedResults = new ArrayList<CombinedResults>();
        for (int i = 0; i < results.size(); ++i) {
            boolean foundMatch = false;
            for (int j = i + 1; j < results.size(); ++j) {
//               if (results[i].getProvider() == results[j].getProviderjk
//               }
            }
        }
    }
}
