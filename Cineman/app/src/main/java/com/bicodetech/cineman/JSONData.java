/**
 * Prepares advanced search preferences.
 *
 * @author Caleb Baird
 */


package com.bicodetech.cineman;

import java.util.List;

public class JSONData {
    private String query = null;
    private List<String> age_certifications = null;
    private List<String> content_types = null;
    private List<String> presentation_types = null;
    private List<String> providers = null;
    private List<String> genres = null;
    private Integer release_year_from = null;
    private Integer release_year_until = null;
    private List<String> monetization_types = null;
    private Integer min_price = null;
    private Integer max_price = null;
    private Boolean nationwide_cinema_releases_only = null;
    private String languages = null;
    private List<String> scoring_filter_types = null;

    /**
     * Inputs query string into variable.
     *
     * @param query sets user query string to variable query.
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * inputs age_certifications string into variable
     *
     * @param age_certifications sets user age_certifications string to variable .
     */
    public void setAge_certifications(List<String> age_certifications) {
        this.age_certifications = age_certifications;
    }

    /**
     * inputs content_types string into variable
     *
     * @param content_types sets user content_types string to variable .
     */
    public void setContent_types(List<String> content_types) {
        this.content_types = content_types;
    }

    /**
     * inputs presentation_types string into variable
     *
     * @param presentation_types sets user presentation_types string to variable .
     */
    public void setPresentation_types(List<String> presentation_types) {
        this.presentation_types = presentation_types;
    }

    /**
     * inputs providers string into variable
     *
     * @param providers sets user providers string to variable .
     */
    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    /**
     * inputs genres string into variable
     *
     * @param genres sets user genres string to variable .
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     * inputs release_year_from string into variable
     *
     * @param release_year_from sets user release_year_from string to variable .
     */
    public void setRelease_year_from(Integer release_year_from) {
        this.release_year_from = release_year_from;
    }

    /**
     * inputs release_year_until string into variable
     *
     * @param release_year_until sets user release_year_until string to variable .
     */
    public void setRelease_year_until(Integer release_year_until) {
        this.release_year_until = release_year_until;
    }

    /**
     * inputs monetization_types string into variable
     *
     * @param monetization_types sets user monetization_types string to variable .
     */
    public void setMonetization_types(List<String> monetization_types) {
        this.monetization_types = monetization_types;
    }

    /**
     * inputs min_price string into variable
     *
     * @param min_price sets user min_price string to variable .
     */
    public void setMin_price(Integer min_price) {
        this.min_price = min_price;
    }

    /**
     * inputs max_price string into variable
     *
     * @param max_price sets user max_price string to variable .
     */
    public void setMax_price(Integer max_price) {
        this.max_price = max_price;
    }

    /**
     * inputs nationwide_cinema_releases_only string into variable
     *
     * @param nationwide_cinema_releases_only sets user nationwide_cinema_releases_only string to variable .
     */
    public void setNationwide_cinema_releases_only(Boolean nationwide_cinema_releases_only) {
        this.nationwide_cinema_releases_only = nationwide_cinema_releases_only;
    }
}
