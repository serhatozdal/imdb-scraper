package com.serhatozdal.scraper.model;

import java.io.Serializable;

/**
 * @author serhatozdal
 */
public class Credits implements Serializable {

    private static final long serialVersionUID = 3884810911211244368L;

    private String imdbId;
    private String name;
    private String roleName;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
