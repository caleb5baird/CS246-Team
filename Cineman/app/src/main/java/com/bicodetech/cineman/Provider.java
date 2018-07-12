package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Provider {

    @SerializedName("provider_id")
    private int providerId;

    private Urls urls;

    @SerializedName("monetization_type")
    private String monetizationType;

    public Provider(int providerId, Urls urls, String monotizationType) {
        this.providerId = providerId;
        this.urls = urls;
        this.monetizationType = monotizationType;
    }

    public void setProviderId(int providerId) { this.providerId = providerId; }

    public void setUrls(Urls urls) { this.urls = urls; }

    public void setMonotizationType(String monotizationType) { this.monetizationType = monotizationType; }

    public int getProviderId() { return providerId; }

    public Urls getUrls() { return urls; }

    public String getMonotizationType() { return monetizationType; }

}
