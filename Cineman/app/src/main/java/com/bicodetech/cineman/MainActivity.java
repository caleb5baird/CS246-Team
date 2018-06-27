package com.bicodetech.cineman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Set<String> searchHistory;
    private EditText etSearchBar;

    @Override
    protected void onPause() {
        super.onPause();
        writeSharedPreferneces();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSharedPreferences();
    }


    //I got this from the My First App androi tutorial
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SearchResults.class);
        EditText editText = (EditText) findViewById(R.id.searchBar);
        String message = editText.getText().toString();
        searchHistory.add(message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    private void writeSharedPreferneces(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet("searchHistory", searchHistory);
    }

    private void readSharedPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        searchHistory = sp.getStringSet("searchHistory", null);
        Intent intent = new Intent(this, SearchResults.class);
        EditText editText = (EditText) findViewById(R.id.searchBar);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
