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

    public JSONPostLoader(SearchResults activity) {
        activityRef = new WeakReference<SearchResults>(activity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (activityRef.get() != null) {
            activityRef.get().enableProgressBar();
        }
    }

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
            data.setQuery(title);

            //add rating
            List<String> rating = new ArrayList<String>();
            if (parameters.getBoolean("checkRatingG"))
            {
                rating.add(parameters.getString("G"));
            }
            else if (parameters.getBoolean("checkRatingPG"))
            {
                rating.add(parameters.getString("PG"));
            }
            else if (parameters.getBoolean("checkRatingPG13"))
            {
                rating.add(parameters.getString("PG-13"));
            }
            else if (parameters.getBoolean("checkRatingR"))
            {
                rating.add(parameters.getString("R"));
            }
            data.setAge_certifications(rating);

            //add content type (movie vs tv)
//            List<String> contactType = new ArrayList<String>();
//            contactType.add("movie");
//            data.setContent_types(contactType);

            // add provider
//            List<String> providers = new ArrayList<String>();
//            providers.add("amp");
//            data.setProviders(providers);

            //add genres
            List<String> genres = new ArrayList<String>();
            if (parameters.getBoolean("checkAction"))
                genres.add("act");
            else if (parameters.getBoolean("checkRomance"))
                genres.add("rma");
            else if (parameters.getBoolean("checkComedy"))
                genres.add("cmy");
            else if (parameters.getBoolean("checkMusical"))
                genres.add("msc");
            else if (parameters.getBoolean("checkDocumentary"))
                genres.add("doc");
            else if (parameters.getBoolean("checkWestern"))
                genres.add("wsn");

            data.setGenres(genres);

            // stream/rent
            List<String> monitizationTypes = new ArrayList<String>();
            if (parameters.getBoolean("checkStream"))
                genres.add("flatrate");
            else if (parameters.getBoolean("checkRent"))
                genres.add("rent");
//            else if (parameters.getBoolean("checkBuy"))
//                genres.add("buy");


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

    protected void onPostExecute(String result) {
        if (activityRef.get() != null && result != null) {
            activityRef.get().displayDump(result);
            activityRef.get().disableProgressBar();
        }
    }
}
