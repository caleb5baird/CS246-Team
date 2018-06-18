package com.bicodetech.cineman;

import android.os.AsyncTask;

import java.util.List;

public class Search extends AsyncTask< List<String>, Void, List<Result> > {

    @Override
    protected List<Result> doInBackground(List<String>... strings) {
        //make the json request
        return null;
    }

    @Override
    protected void onPostExecute(List<Result> results) {
        super.onPostExecute(results);
        //combine all of the Result opbjects into combinedResults objects
        //return the list of combinedResults
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
