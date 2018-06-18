package com.bicodetech.cineman;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CombinedResults extends Result {
    public CombinedResults(String title, String provider, String summary, String rating, String title1, String runtime, String genre, String date, String director, ArrayList<String> cast, float price, float popularRating, ArrayList<String> providers) {
        super(title, provider, summary, rating, title1, runtime, genre, date, director, cast, price, popularRating);
        this.providers = providers;
    }

    private ArrayList<String> providers;

    public void setProviders(ArrayList<String> providers) {
        this.providers = providers;
    }

    public ArrayList<String> getProviders() {

        return providers;
    }
}
