package com.bicodetech.cineman;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    private ProgressBar progressBar;
    private ListView listView;
    private Bundle parameters;
    private static CustomAdapter adapter;

    public Bundle getParameters() {
        return parameters;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Get the Intent that started this activity and extract the bundle
        Intent intent = getIntent();
        parameters = intent.getBundleExtra(MainActivity.EXTRA_MESSAGE);

        // make the json request
        setTitle("JSON Post");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = findViewById(R.id.searchResults);
//        listView.setMovementMethod(new ScrollingMovementMethod());

        disableProgressBar();

        new JSONPostLoader(this).execute();

    }

    public void displayDump(String jsonData) {
        Gson gson = new Gson();

        CombinedResults combinedResults = gson.fromJson(jsonData, CombinedResults.class);
//        listView.setText(jsonData);
        ArrayList<Result> results = combinedResults.getResults();
        adapter = new CustomAdapter(results, getApplicationContext());
        listView.setAdapter(adapter);
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
