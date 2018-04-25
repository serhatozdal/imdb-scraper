package com.serhatozdal.scraper.model;

import java.util.List;

/**
 * @author serhatozdal
 */
public class Media extends Content {

    private String originalTitle;
    private String otherTitle;
    private Short year;
    private Float rating;
    private Integer ratingCount;
    private List<String> genres;
    private Integer duration;
    private List<String> countries;
    private String releaseDate;
    private List<String> languages;
    private List<String> recommendedTitles;
    private String budget;
    private String cumulativeGross;
    private List<String> plotKeywords;
    private String alsoKnownAs;
    private String storyLine;
    private Integer oscars;
    private Integer awards;
    private Integer nominations;
    private List<Credits> directors;
    private List<Credits> writers;
    private List<Credits> producers;
    private List<Credits> musicians;
    private List<Credits> cast;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(String otherTitle) {
        this.otherTitle = otherTitle;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getRecommendedTitles() {
        return recommendedTitles;
    }

    public void setRecommendedTitles(List<String> recommendedTitles) {
        this.recommendedTitles = recommendedTitles;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getCumulativeGross() {
        return cumulativeGross;
    }

    public void setCumulativeGross(String cumulativeGross) {
        this.cumulativeGross = cumulativeGross;
    }

    public List<String> getPlotKeywords() {
        return plotKeywords;
    }

    public void setPlotKeywords(List<String> plotKeywords) {
        this.plotKeywords = plotKeywords;
    }

    public String getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(String alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    public Integer getOscars() {
        return oscars;
    }

    public void setOscars(Integer oscars) {
        this.oscars = oscars;
    }

    public Integer getAwards() {
        return awards;
    }

    public void setAwards(Integer awards) {
        this.awards = awards;
    }

    public Integer getNominations() {
        return nominations;
    }

    public void setNominations(Integer nominations) {
        this.nominations = nominations;
    }

    public List<Credits> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Credits> directors) {
        this.directors = directors;
    }

    public List<Credits> getWriters() {
        return writers;
    }

    public void setWriters(List<Credits> writers) {
        this.writers = writers;
    }

    public List<Credits> getProducers() {
        return producers;
    }

    public void setProducers(List<Credits> producers) {
        this.producers = producers;
    }

    public List<Credits> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Credits> musicians) {
        this.musicians = musicians;
    }

    public List<Credits> getCast() {
        return cast;
    }

    public void setCast(List<Credits> cast) {
        this.cast = cast;
    }
}
