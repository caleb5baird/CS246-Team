/**
 * Result stores the results that the user enters.
 */
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
    private ArrayList<Provider> providers;

    @SerializedName("original_release_year")
    private String date;


    /**
     * The Result constructor.
     *
     * @param title string containing the title.
     * @param image string containing the image.
     * @param summary string containing the summary.
     * @param runtime int containing the runtime.
     * @param rating string containing the rating.
     * @param providers ArrayList of type Provider containing the providers.
     * @param date string containing the date.
     */
    public Result(String title, String image, String summary, int runtime, String rating, ArrayList<Provider> providers, String date) {
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.runtime = runtime;
        this.rating = rating;
        this.providers = providers;
        this.date = date;
    }

    /**
     * getTitle gets the title
     * @return string title.
     */
    public String getTitle() { return title; }

    /**
     * setTitle sets the variable title.
     * @param title the title.
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * getImage gets the image
     * @return string image
     */
    public String getImage() { return image; }

    /**
     * setImage sets the variable title.
     * @param image the image.
     */
    public void setImage(String image) { this.image = image; }

    /**
     * getSummary gets the summary
     * @return string summary.
     */
    public String getSummary() { return summary; }

    /**
     * setSummary sets the variable title.
     * @param summary string summay.
     */
    public void setSummary(String summary) { this.summary = summary; }

    /**
     * getRuntime gets the runtime
     * @return int runtime.
     */
    public int getRuntime() { return runtime; }

    /**
     * setRuntime sets the variable title.
     * @param runtime int runtime.
     */
    public void setRuntime(int runtime) { this.runtime = runtime; }

    /**
     * getRating gets the rating
     * @return string rating.
     */
    public String getRating() { return rating; }

    /**
     * setRating sets the variable title.
     * @param rating string rating.
     */
    public void setRating(String rating) { this.rating = rating; }

    /**
     * getProviders gets the providers
     * @return array of providers.
     */
    public ArrayList<Provider> getProviders() { return providers; }

    /**
     * setProviders sets the variable title.
     * @param providers array of providers.
     */
    public void setProviders(ArrayList<Provider> providers) { this.providers = providers; }

    /**
     * getDate gets the date
     * @return string date.
     */
    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
