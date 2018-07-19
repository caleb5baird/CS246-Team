/**
 * Search a class to get JSON search results
 */
package com.bicodetech.cineman;

import android.os.AsyncTask;

import java.util.List;

public class Search extends AsyncTask< List<String>, Void, List<Result> > {

    /**
     * doInBackround mades a json request and updates our results.
     * @param strings
     * @return
     */
    @Override
    protected List<Result> doInBackground(List<String>... strings) {
        //make the json request
        return null;
    }

    /**
     * onPostExicute checks after app is done.
     * @param results possible results.
     */
    @Override
    protected void onPostExecute(List<Result> results) {
        super.onPostExecute(results);
        //combine all of the Result opbjects into combinedResults objects
        //return the list of combinedResults
    }

    /**
     * onProgressUpdate updates progress
     *
     * @param values possible values.
     */
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
