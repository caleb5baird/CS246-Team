/**
 * Prepares URL object for call to API.
 */

package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("standard_web")
    private String standardUrl;

    @SerializedName("deeplink_ios")
    private String iosUrl;

    /**
     * Retrieves URL for caller
     *
     * @return standardURL returns formatted URL.
     */
    public String getStandardUrl() { return standardUrl; }

    /**
     * Inputs URL into variable.
     *
     * @param standardUrl URL of search.
     */
    public void setStandardUrl(String standardUrl) { this.standardUrl = standardUrl; }

    /**
     * Retrieves IOS URL for caller.
     *
     * @return iosUrl returns formated IOS URL
     */
    public String getIosUrl() { return iosUrl; }

    /**
     * Inputs IOS URL into variable.
     * @param iosUrl IOS URL of search
     */
    public void setIosUrl(String iosUrl) { this.iosUrl = iosUrl; }

    /**
     * Constructor of Urls class.
     *
     * @param standardUrl original URL.
     * @param iosUrl original IOS URL.
     */
    public Urls(String standardUrl, String iosUrl) {
        this.standardUrl = standardUrl;
        this.iosUrl = iosUrl;
    }

}
