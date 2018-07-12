package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private String title;

    @SerializedName("poster")
    private String image;

    @SerializedName("short_description")
    private String summary;

    private int runtime;

    @SerializedName("age_certification")
    private String rating;

    @SerializedName("offers")
    private List<Provider> providers;

    @SerializedName("original_release_year")
    private String date;


    public Result(String title, String image, String summary, int runtime, String rating, List<Provider> providers, String date) {
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.runtime = runtime;
        this.rating = rating;
        this.providers = providers;
        this.date = date;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getSummary() { return summary; }

    public void setSummary(String summary) { this.summary = summary; }

    public int getRuntime() { return runtime; }

    public void setRuntime(int runtime) { this.runtime = runtime; }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public List<Provider> getProviders() { return providers; }

    public void setProviders(List<Provider> providers) { this.providers = providers; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
