/**
 * The class MainActivity is where the app starts. It creates an activity that will
 * take user input and then send that to the next activity for results to be displayed.
 */
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

public class MainActivity extends AppCompatActivity {

    private EditText etSearchBar;
    private static String SP_SEARCH_BAR = "com.bicodetech.searchBar";
    private static final String[] Countries = new String[] {
            "1", "a", "b", "c", "d", "e", "f", "g" , "h", "i", "j"
    };

    Queue<String> searchHistory = new LinkedList<>();


    /**
     * onPause is called whenever the user closes the app or changes to another app.
     */
    @Override
    protected void onPause() {
        super.onPause();
        writeSharedPreferneces();
    }

    /**
     * onCreate sets up everything the app needs to run. It gets the shared prefrences and add an
     * onUpdate functionality to our switch.
     * @param savedInstanceState the past saved search history. You get this from shared preferences.
     */
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

    /**
     * sendMessage gets called when the button on mainActivity gets clicked. It gathers
     * all the info that the user inputed and bundles it. Then it send that bundle to a
     * new activity.
     * @param view this is the view of the activity it was called from. It needs this so that
     *             it can reference all the check boxes and buttons.
     */
    public void sendMessage(View view) {
        // Do something in response to button

        EditText searchBarEntry = (EditText) findViewById(R.id.searchBar);

        CheckBox checkNetflix = (CheckBox) findViewById(R.id.netflix); //Netflix
        CheckBox checkAmazon = (CheckBox) findViewById(R.id.amazon); //Amazon

        CheckBox checkAction = (CheckBox) findViewById(R.id.action); //action
        CheckBox checkRomance = (CheckBox) findViewById(R.id.romance); //Romance
        CheckBox checkComedy = (CheckBox) findViewById(R.id.comedy); //Comedy
        CheckBox checkMusical = (CheckBox) findViewById(R.id.musical);  //Musical
        CheckBox checkDocumentary = (CheckBox) findViewById(R.id.documnetary);  //Documentuary
        CheckBox checkWestern = (CheckBox) findViewById(R.id.western);  //Religionus

        CheckBox checkRent = (CheckBox) findViewById(R.id.rent);  //rent
        CheckBox checkBuy = (CheckBox) findViewById(R.id.buy);  //rent
        CheckBox checkStream = (CheckBox) findViewById(R.id.stream); //stream

        CheckBox checkRatingG = (CheckBox) findViewById(R.id.g);
        CheckBox checkRatingPG = (CheckBox) findViewById(R.id.pg);
        CheckBox checkRatingPG13 = (CheckBox) findViewById(R.id.pg13);





        Bundle b = new Bundle();

        b.putString("title", searchBarEntry.getText().toString());

        b.putBoolean("checkNetflix", checkNetflix.isChecked());
        b.putBoolean("checkAmazon", checkAmazon.isChecked());

        b.putBoolean("checkAction", checkAction.isChecked());
        b.putBoolean("checkRomance", checkRomance.isChecked());
        b.putBoolean("checkComedy", checkComedy.isChecked());
        b.putBoolean("checkMusical", checkMusical.isChecked());
        b.putBoolean("checkDocumentary", checkDocumentary.isChecked());
        b.putBoolean("checkWestern", checkWestern.isChecked());

        b.putBoolean("checkRent", checkRent.isChecked());
        b.putBoolean("checkBuy", checkBuy.isChecked());
        b.putBoolean("checkStream", checkStream.isChecked());

        b.putBoolean("checkRatingG", checkRatingG.isChecked());
        b.putBoolean("checkRatingPG", checkRatingPG.isChecked());
        b.putBoolean("checkRatingPG13", checkRatingPG13.isChecked());

        writeSharedPreferneces();
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

    /**
     * writeSharedPreferneces takes the global variable Countries and saves it to shared preferences.
     */
    private void writeSharedPreferneces(){

        //If you havent searched before than you need to fill in Countries or it will seg fault.
        if (!isNumeric(Countries[0].toString()))
        {
            final String[] Countries = new String[] {
                    "1", "a", "b", "c", "d", "e", "f", "g" , "h", "i", "j"
                    //"1", "Belgium", "France", "Italy", "Germany", "Spain", "Frammel", "eded" , "Toon Town", "PEOPLE", "Sam is sad"
            };

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Countries.length; i++) {
                sb.append(Countries[i]).append(",");
            }

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(SP_SEARCH_BAR, sb.toString());
            editor.apply();
        }
        else {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Countries.length; i++) {
                sb.append(Countries[i]).append(",");
            }

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(SP_SEARCH_BAR, sb.toString());
            editor.apply();
        }


    }

    /**
     * readSharedPreferences it reads what was in the shared preferences.
     */
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


    /**
     * updateHistoryStuff updates the global variable Countries.
     * @param searchBarEntry the string to be inserted into the bundle.
     */
    private void updateHistoryStuff(String searchBarEntry) {

        int number = Integer.parseInt(Countries[0].toString()); //element 0 in our array is the number.
        Countries[number] = searchBarEntry;
        if(number >= 10)
            number = 1;
        else
            number++;

        Countries[0] = Integer.toString(number);
    }

    /**
     * isNumeric is used to check if a string is a number or not.
     * @param str the string to be checked.
     * @return true if the string is a number.
     */
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
