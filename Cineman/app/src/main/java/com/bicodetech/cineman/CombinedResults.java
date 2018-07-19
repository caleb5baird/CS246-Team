/**
 * Combines retrieved data into single data packet.
 *
 * @author Caleb Baird
 */

package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinedResults {

    @SerializedName("items")
    private ArrayList<Result> results;

    /**
     * fetches and returns results
     *
     * @return results
     */
    public ArrayList<Result> getResults() { return results; }

    /**
     * inputs results into variable
     *
     * @param results search results.
     */
    public void setResults(ArrayList<Result> results) { this.results = results; }

    /**
     * inputs results into ArrayList of Results
     *
     * @param results array of search results.
     */
    public CombinedResults(ArrayList<Result> results) { this.results = results; }

}
