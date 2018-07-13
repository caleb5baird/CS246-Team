package com.bicodetech.cineman;

import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("standard_web")
    private String standardUrl;

    @SerializedName("deeplink_ios")
    private String iosUrl;

    public String getStandardUrl() { return standardUrl; }

    public void setStandardUrl(String standardUrl) { this.standardUrl = standardUrl; }

    public String getIosUrl() { return iosUrl; }

    public void setIosUrl(String iosUrl) { this.iosUrl = iosUrl; }

    public Urls(String standardUrl, String iosUrl) {
        this.standardUrl = standardUrl;
        this.iosUrl = iosUrl;
    }

}
