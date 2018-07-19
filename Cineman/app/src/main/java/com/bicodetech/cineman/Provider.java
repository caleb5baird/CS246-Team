/**
 * Provider is a class that hold the information about the providers the JSON results
 */
package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Provider {

    @SerializedName("provider_id")
    private int providerId;

    private Urls urls;

    @SerializedName("monetization_type")
    private String monetizationType;

    /**
     * Provides's constructor
     * @param providerId id from JSON results.
     * @param urls url from JSON results.
     * @param monotizationType monotization type from JSON results.
     */
    public Provider(int providerId, Urls urls, String monotizationType) {
        this.providerId = providerId;
        this.urls = urls;
        this.monetizationType = monotizationType;
    }

    /**
     * setProviderId sets the id of the movie to this->providerId
     * @param providerId the id of the provider.
     */
    public void setProviderId(int providerId) { this.providerId = providerId; }

    /**
     * setUrls adds any urls to this->urls
     * @param urls urls that link to pictures of movies.
     */
    public void setUrls(Urls urls) { this.urls = urls; }

    /**
     * setMonotizationType can be used to set how you can buy the movie
     *
     * @param monotizationType string of type of monotizaiotn.
     */
    public void setMonotizationType(String monotizationType) { this.monetizationType = monotizationType; }

    /**
     * getProviderId gets the provider
     *
     * @return returns this classes provider id.
     */
    public int getProviderId() { return providerId; }

    /**
     * getUrls gets the urls that are stored with this provider.
     *
     * @return returns url of urls
     */
    public Urls getUrls() { return urls; }

    /**
     * getMonotizationType gets what type of monetization this provider has
     *
     * @return string monetization Type.
     */
    public String getMonotizationType() { return monetizationType; }

}
