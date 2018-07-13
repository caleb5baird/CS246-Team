package com.bicodetech.cineman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    /*private Set<String> searchHistory;
    private EditText etSearchBar;*/

    private EditText etSearchBar;
    private static String SP_SEARCH_BAR = "com.bicodetech.searchBar";
    private static final String[] Countries = new String[] {
            "junk1", "junk2", "junk3", "junk4", "junk5", "junk6", "junk7", "junk8" , "junk9", "junk10", "junk11"
            //"1", "Belgium", "France", "Italy", "Germany", "Spain", "Frammel", "eded" , "Toon Town", "PEOPLE", "Sam is sad"
    };

    Queue<String> searchHistory = new LinkedList<>();



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
        readSharedPreferences();                               // It crashed here!!!

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


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Countries);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.searchBar);
        textView.setAdapter(adapter);
    }


    //I got this from the My First App androi tutorial
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button

        EditText searchBarEntry = (EditText) findViewById(R.id.searchBar);

        CheckBox checkNetflix = (CheckBox) findViewById(R.id.checkBox3); //Netflix
        CheckBox checkAmazon = (CheckBox) findViewById(R.id.checkBox4); //Amazon

        CheckBox checkAction = (CheckBox) findViewById(R.id.checkBox10); //action
        CheckBox checkRomance = (CheckBox) findViewById(R.id.checkBox12); //Romance
        CheckBox checkComedy = (CheckBox) findViewById(R.id.checkBox11); //Comedy
        CheckBox checkMusical = (CheckBox) findViewById(R.id.checkBox8);  //Musical
        CheckBox checkDocumentary = (CheckBox) findViewById(R.id.checkBox7);  //Documentuary
        CheckBox checkReligious = (CheckBox) findViewById(R.id.checkBox9);  //Religionus

        CheckBox checkRent = (CheckBox) findViewById(R.id.checkBox);  //rent
        CheckBox checkStream = (CheckBox) findViewById(R.id.checkBox2); //stream



        Bundle b = new Bundle();

        b.putString("title", searchBarEntry.getText().toString());
        b.putBoolean("checkNetflix", checkNetflix.isChecked());
        b.putBoolean("checkAmazon", checkAmazon.isChecked());
        b.putBoolean("checkAction", checkAction.isChecked());
        b.putBoolean("checkRomance", checkRomance.isChecked());
        b.putBoolean("checkComedy", checkComedy.isChecked());
        b.putBoolean("checkMusical", checkMusical.isChecked());
        b.putBoolean("checkDocumentary", checkDocumentary.isChecked());
        b.putBoolean("checkReligious", checkReligious.isChecked());
        b.putBoolean("checkRent", checkRent.isChecked());
        b.putBoolean("checkStream", checkStream.isChecked());

        //String name = b.getString("title");

        updateHistoryStuff(b.getString("title"));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Countries);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.searchBar);
        textView.setAdapter(adapter);

        Intent intent = new Intent(this, SearchResults.class);
        intent.putExtra(EXTRA_MESSAGE, b);

        startActivity(intent);
    }

    private void writeSharedPreferneces(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Countries.length; i++) {
            sb.append(Countries[i]).append(",");
        }

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SP_SEARCH_BAR, sb.toString());
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

        String[] C = searchBar.split(",");


        int x = Countries.length;
        int num = 0;
        for (int i = 0; i < C.length; i++) {
            if ((i == 1) || (i == 2) || (i == 3))  //for some reason index 1 2 and 3 are junk. we just want to copy 0 and 4-12
                i = 4;

            Countries[num] = C[i];
            num++;
        }

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

    private void updateHistoryStuff(String searchBarEntry) {

        int number = Integer.parseInt(Countries[0].toString()); //element 0 in our array is the number.
        Countries[number] = searchBarEntry;
        if(number >= 10)
            number = 1;
        else
            number++;

        Countries[0] = Integer.toString(number);
    }
}
