package com.bicodetech.cineman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    /*private Set<String> searchHistory;
    private EditText etSearchBar;*/

    private EditText etSearchBar;
    private static String SP_SEARCH_BAR = "com.bicodetech.searchBar";

    /*@Override
    protected void onPause() {
        super.onPause();
        writeSharedPreferneces();
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        writeSharedPreferneces();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSharedPreferences();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearchBar = findViewById(R.id.searchBar);
        readSharedPreferences();

        //This is the code that handles showing out advanced search options.
        Switch ourSwitch = (Switch) findViewById(R.id.AdvancedSearch);
        ourSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //This checks our switch to see if its toggled. If it is then we hide our constraint.
                if (isChecked) {
                    // The switch is enabled
                    findViewById(R.id.constraintLayout).setVisibility(View.VISIBLE); //this is to change our advanced search from visable to gone
                } else {
                    // The switch is disabled
                    findViewById(R.id.constraintLayout).setVisibility(View.GONE); //this is to change our advanced search from gone to visable
                }
            }
        });
    }


    //I got this from the My First App androi tutorial
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SearchResults.class);
        /*EditText editText = (EditText) findViewById(R.id.searchBar);
        String message = editText.getText().toString();
        searchHistory.add(message);*/
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void writeSharedPreferneces(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SP_SEARCH_BAR, etSearchBar.getText().toString());
        editor.apply();
    }

    /*private void writeSharedPreferneces(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet("searchHistory", searchHistory);
        editor.apply();
    }*/

    private void readSharedPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String searchBar = sp.getString(SP_SEARCH_BAR, "");
        etSearchBar.setText(searchBar);
        Toast.makeText(this, "Shared Preferences Loaded", Toast.LENGTH_SHORT).show();
    }

    /*private void readSharedPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        searchHistory = sp.getStringSet("searchHistory", null);
        Intent intent = new Intent(this, SearchResults.class);
        EditText editText = (EditText) findViewById(R.id.searchBar);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}
