package com.serhatozdal.scraper.model;

import java.io.Serializable;

public class Content implements Serializable {

    private Boolean found = false;

    private String id;
    private ContentType contentType;
    private String poster;
    private String posterLarge;

    public Boolean isFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPosterLarge() {
        return posterLarge;
    }

    public void setPosterLarge(String posterLarge) {
        this.posterLarge = posterLarge;
    }
}
