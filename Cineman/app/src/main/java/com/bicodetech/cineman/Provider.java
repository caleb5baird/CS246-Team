package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Provider {

    @SerializedName("provider_id")
    private int providerId;
    private List<String> urls;
    @SerializedName("monotization_type")
    private String monotizationType;

    public Provider(int providerId, List<String> urls, String monotizationType) {
        this.providerId = providerId;
        this.urls = urls;
        this.monotizationType = monotizationType;
    }

    public void setProviderId(int providerId) { this.providerId = providerId; }

    public void setUrls(List<String> urls) { this.urls = urls; }

    public void setMonotizationType(String monotizationType) { this.monotizationType = monotizationType; }

    public int getProviderId() { return providerId; }

    public List<String> getUrls() { return urls; }

    public String getMonotizationType() { return monotizationType; }

}
