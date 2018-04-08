package com.serhatozdal.scraper.model;

/**
 * @author serhatozdal
 */
public enum ContentType {
    MOVIE("video.movie"),
    TV_SHOW("video.tv_show");

    private String name;

    ContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
