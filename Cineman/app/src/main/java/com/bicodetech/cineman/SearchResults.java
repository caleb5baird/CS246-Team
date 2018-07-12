package com.bicodetech.cineman;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textview;
    private Bundle parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        parameters = intent.getBundleExtra(MainActivity.EXTRA_MESSAGE);

        // make the json request
        setTitle("JSON Post");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textview = findViewById(R.id.searchResults);
        textview.setMovementMethod(new ScrollingMovementMethod());

        //TODO: figure out what this progress bar is for.
        disableProgressBar();

        new JSONPostLoader(this).execute();

//        ArrayList cast = new ArrayList<String>();
//        cast.add("Caleb Baird");
//        cast.add("Sam Gay");
//        cast.add("Sam Haymond");
//        cast.add("Chase Haymond");
//        Result r1 = new Result("Home Alone", "Netflix", "Boy is left at home", "PG", "120", "Horror", "1990", "Christopher Columbus", cast, 0, 0);
//        Result r2 = new Result("Home Alone", "Amazon Prime", "Boy is left at home", "PG", "120", "Horror", "1990", "Christopher Columbus", cast, 0, 0);
//        Result r3 = new Result("Home Alone", "Hulu", "Boy is left at home", "PG", "120", "Horror", "1990", "Christopher Columbus", cast, 0, 0);
//        Result r4 = new Result("Star Wars", "Netflix", "Jedi's rule the galaxy", "PG", "120", "Sci-Fi", "1990", "George Lucas", cast, 15, 100);
//        Result r5 = new Result("Star Wars", "Amazon Prime", "Jedi's rule the galaxy", "PG", "120", "Sci-Fi", "1990", "George Lucas", cast, 15, 100);
//        Result r6 = new Result("Star Wars", "Hulu", "Jedi's rule the galaxy", "PG", "120", "Sci-Fi", "1990", "George Lucas", cast, 15, 100);
//        ArrayList results = new ArrayList<Result>;
//        results.add(r1);
//        results.add(r2);
//        results.add(r3);
//        results.add(r4);
//        results.add(r5);
//        results.add(r6);
//        List<CombinedResults> combinedResults = combineResults(results);

    }

    public void displayDump(String jsonData) {
        Gson gson = new Gson();

        CombinedResults combinedResults = gson.fromJson(jsonData, CombinedResults.class);
    }

    public void enableProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void disableProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
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
        return combinedResults;
    }
}
