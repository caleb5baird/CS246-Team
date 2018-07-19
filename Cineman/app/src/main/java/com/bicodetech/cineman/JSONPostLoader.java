/**
 * Prepares request to JustWatch API, requests data per search, receives data and parses to
 * individual variables, then returns variables.
 *
 * @author Caleb Baird
 */




package com.bicodetech.cineman;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class JSONPostLoader extends AsyncTask<Void, Void, String> {

    private WeakReference<SearchResults> activityRef;

    /**
     * Constructs JSONPostLoader using search's current activity
     *
     * @param activity activity from search
     */
    public JSONPostLoader(SearchResults activity) {
        activityRef = new WeakReference<SearchResults>(activity);
    }

    /**
     * onPreExecute overrides super class to enable progress bar
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (activityRef.get() != null) {
            activityRef.get().enableProgressBar();
        }
    }

    /**
     * Requests data from JustWatch API which returns JSON string. JSON string is parsed into
     * variables and returns all lines of data.
     *
     * @param dummy no true variable
     * @return allLines all lines from JSON string
     * @throws MalformedURLException Throws MalformedURLException for incorrect URL exception
     * @throws IOException throws IOException for input or output exception
     */
    protected String doInBackground(Void... dummy) {
        try {
            // Create a stream to the URL
            URL urlObj = new URL("https://api.justwatch.com/titles/en_US/popular");
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setChunkedStreamingMode(0);
            connection.setRequestProperty("User-Agent", "Java client");
            connection.setRequestProperty("Content-Type", "application/json");

            JSONData data = new JSONData();
            Bundle parameters = activityRef.get().getParameters();


            String title = parameters.getString("title");
            if (title.length() > 0)
                data.setQuery(title);

            //add rating
            List<String> rating = new ArrayList<String>();
            if (parameters.getBoolean("checkRatingG"))
                rating.add("G");
            if (parameters.getBoolean("checkRatingPG"))
                rating.add("PG");
            if (parameters.getBoolean("checkRatingPG13"))
                rating.add("PG-13");
            if (rating.size() > 0)
                data.setAge_certifications(rating);

            // add provider
            List<String> providers = new ArrayList<String>();
            if (parameters.getBoolean("checkAmazon"))
                providers.add("amp");
            if (parameters.getBoolean("checkNetflix"))
                providers.add("nfx");
            if (providers.size() > 0)
                data.setProviders(providers);

            //add genres
            List<String> genres = new ArrayList<String>();
            if (parameters.getBoolean("checkAction"))
                genres.add("act");
            if (parameters.getBoolean("checkRomance"))
                genres.add("rma");
            if (parameters.getBoolean("checkComedy"))
                genres.add("cmy");
            if (parameters.getBoolean("checkMusical"))
                genres.add("msc");
            if (parameters.getBoolean("checkDocumentary"))
                genres.add("doc");
            if (parameters.getBoolean("checkWestern"))
                genres.add("wsn");
            if (genres.size() > 0)
                data.setGenres(genres);

            // stream/rent
            List<String> monitizationTypes = new ArrayList<String>();
            if (parameters.getBoolean("checkStream"))
                genres.add("flatrate");
            if (parameters.getBoolean("checkRent"))
                genres.add("rent");
//            else if (parameters.getBoolean("checkBuy"))
//                genres.add("buy");
            if (monitizationTypes.size() > 0)
                data.setMonetization_types(monitizationTypes);

            Gson gson = new Gson();
            String body = gson.toJson(data);

            DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
            wr.writeBytes(body);
            wr.flush ();
            wr.close ();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Read all data from the website into a single string
            String line = "";
            String allLines = "";
            do {
                line = reader.readLine();
                if (line != null) {
                    allLines += line;
                }
            }
            while (line != null);
            return allLines;
        } catch (MalformedURLException murle) {
            return null;
        } catch (IOException ioe) {
            return null;
        }
    }

    /**
     * Returns result data if no previous search results were populated.
     *
     * @param result
     */
    protected void onPostExecute(String result) {
        if (activityRef.get() != null && result != null) {
            activityRef.get().displayDump(result);
            activityRef.get().disableProgressBar();
        }
    }
}
