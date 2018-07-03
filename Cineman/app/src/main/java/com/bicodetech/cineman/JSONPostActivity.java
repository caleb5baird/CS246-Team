package com.bicodetech.cineman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class JSONPostActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        setTitle("JSON Post");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textview = findViewById(R.id.searchBar);
        textview.setMovementMethod(new ScrollingMovementMethod());
        disableProgressBar();
        new JSONPostLoader(this).execute();
    }

    public void displayDump(String jsonData) {
        textview.setText(jsonData);
    }

    public void enableProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void disableProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
