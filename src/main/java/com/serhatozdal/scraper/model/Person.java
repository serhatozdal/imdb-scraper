package com.serhatozdal.scraper.model;

import java.io.Serializable;

public class Person implements Serializable {

    private Boolean personFound = false;

    public Boolean isPersonFound() {
        return personFound;
    }

    public void setPersonFound(Boolean personFound) {
        this.personFound = personFound;
    }
}
