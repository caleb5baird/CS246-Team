package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SerializedName("total_results")
public class CombinedResults {

    private List<Result> results;

    public List<Result> getResults() { return results; }

    public void setResults(List<Result> results) { this.results = results; }

    public CombinedResults(List<Result> results) { this.results = results; }

}
