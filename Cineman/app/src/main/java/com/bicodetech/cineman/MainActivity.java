package com.bicodetech.cineman;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Set<String> searchHistory;
    private EditText etSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSharedPreferences();
    }

    @Override
    protected void onPause() {
        super.onPause();
        writeSharedPreferneces();
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        etSearchBar =(EditText) findViewById(R.id.searchBar);
        searchHistory.add(etSearchBar.getText().toString());
    }

    private void writeSharedPreferneces(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet("searchHistory", searchHistory);
    }

    private void readSharedPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        searchHistory = sp.getStringSet("searchHistory", null);
    }
}
