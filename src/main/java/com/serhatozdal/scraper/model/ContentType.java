package com.serhatozdal.scraper.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author serhatozdal
 */
public enum ContentType {
    MOVIE("video.movie"),
    TV_SHOW("video.tv_show");

    private static final Map types = new HashMap();

    static {
        for (ContentType contentType : ContentType.values()) {
            types.put(contentType.getName(), contentType);
        }
    }

    private String name;

    ContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ContentType get(String contentValue) {
        return (ContentType) types.get(contentValue);
    }
}
