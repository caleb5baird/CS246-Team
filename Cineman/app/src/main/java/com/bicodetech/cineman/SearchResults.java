/**
 * searchResults is a class that takes the search results from the main activity
 * and displays info to the user.
 */

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

    /**
     * onCreate gets everything ready to be displayed.
     * @param savedInstanceState
     */
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

        disableProgressBar();

        new JSONPostLoader(this).execute();

    }

    /**
     * Sets up the adapter and passes it to a listView
     * @param jsonData collection of JSON data.
     */
    public void displayDump(String jsonData) {
        Gson gson = new Gson();

        CombinedResults combinedResults = gson.fromJson(jsonData, CombinedResults.class);
//        listView.setText(jsonData);
        ArrayList<Result> results = combinedResults.getResults();
        adapter = new CustomAdapter(results, getApplicationContext());
        listView.setAdapter(adapter);
    }

    /**
     * enableProgressBar starts the progress bar.
     */
    public void enableProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * disablesProgressBar stops the progress bar.
     */
    public void disableProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
