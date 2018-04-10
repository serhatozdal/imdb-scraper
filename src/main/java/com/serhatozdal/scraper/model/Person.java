package com.serhatozdal.scraper.model;

import java.util.List;

public class Person extends Content {

    private String name;
    private String birthName;
    private String height;
    private String bornDate;
    private String bornPlace;
    private String diedDate;
    private String diedPlace;
    private String biography;
    private List<String> knownFor;
    private List<String> jobCategories;
    private List<String> filmography;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public String getDiedDate() {
        return diedDate;
    }

    public void setDiedDate(String diedDate) {
        this.diedDate = diedDate;
    }

    public String getDiedPlace() {
        return diedPlace;
    }

    public void setDiedPlace(String diedPlace) {
        this.diedPlace = diedPlace;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<String> getKnownFor() {
        return knownFor;
    }

    public void setKnownFor(List<String> knownFor) {
        this.knownFor = knownFor;
    }

    public List<String> getJobCategories() {
        return jobCategories;
    }

    public void setJobCategories(List<String> jobCategories) {
        this.jobCategories = jobCategories;
    }

    public List<String> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<String> filmography) {
        this.filmography = filmography;
    }
}
