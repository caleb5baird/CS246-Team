package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinedResults {

    @SerializedName("items")
    private ArrayList<Result> results;

    public ArrayList<Result> getResults() { return results; }

    public void setResults(ArrayList<Result> results) { this.results = results; }

    public CombinedResults(ArrayList<Result> results) { this.results = results; }

}
