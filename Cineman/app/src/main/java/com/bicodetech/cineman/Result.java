package com.bicodetech.cineman;

import java.util.ArrayList;

public class Result {
    public Result(String title, String provider, String summary, String rating, String title1, String runtime, String genre, String date, String director, ArrayList<String> cast, float price, float popularRating) {
        this.title = title;
        this.provider = provider;
        this.summary = summary;
        this.rating = rating;
        this.title = title1;
        this.runtime = runtime;
        this.genre = genre;
        this.date = date;
        this.director = director;
        this.cast = cast;
        this.price = price;
        this.popularRating = popularRating;
    }

    private String title;
    private String provider;
    private String summary;
    private String rating;
    private String runtime;
    private String genre;
    private String date;
    private String director;
    private ArrayList<String> cast;
    private float price;
    private float popularRating;

    public String getTitle() { return title; }

    public String getRuntime() { return runtime; }

    public String getGenre() { return genre; }

    public String getDate() { return date; }

    public String getDirector() { return director; }

    public ArrayList<String> getCast() { return cast; }

    public float getPrice() { return price; }

    public float getPopularRating() { return popularRating; }

    public String getProvider() { return provider; }

    public String getSummary() { return summary; }

    public String getRating() { return rating; }

    public void setTitle(String title) { this.title = title; }

    public void setRuntime(String runtime) { this.runtime = runtime; }

    public void setGenre(String genre) { this.genre = genre; }

    public void setDate(String date) { this.date = date; }

    public void setDirector(String director) { this.director = director; }

    public void setCast(ArrayList<String> cast) { this.cast = cast; }

    public void setPrice(float price) { this.price = price; }

    public void setPopularRating(float popularRating) { this.popularRating = popularRating; }

    public void setProvider(String provider) { this.provider = provider; }

    public void setSummary(String summary) { this.summary = summary; }

    public void setRating(String rating) { this.rating = rating; }

}
