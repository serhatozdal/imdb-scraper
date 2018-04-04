package com.serhatozdal.scraper.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author serhatozdal
 */
public class Media implements Serializable
{
    private static final long serialVersionUID = -2125462535911961247L;

    private String id;
    private String mediaType;
    private String originalTitle;
    private String otherTitle;
    private Short year;
    private Float rating;
    private Float ratingCount;
    private List<String> genres;
    private Integer duration;
    private List<String> countries;
    private String releaseDate;
    private String releaseDateFormatted;
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
    private String poster;
    private String posterLarge;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getMediaType()
    {
        return mediaType;
    }

    public void setMediaType(String mediaType)
    {
        this.mediaType = mediaType;
    }

    public String getOriginalTitle()
    {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle)
    {
        this.originalTitle = originalTitle;
    }

    public String getOtherTitle()
    {
        return otherTitle;
    }

    public void setOtherTitle(String otherTitle)
    {
        this.otherTitle = otherTitle;
    }

    public Short getYear()
    {
        return year;
    }

    public void setYear(Short year)
    {
        this.year = year;
    }

    public Float getRating()
    {
        return rating;
    }

    public void setRating(Float rating)
    {
        this.rating = rating;
    }

    public Float getRatingCount()
    {
        return ratingCount;
    }

    public void setRatingCount(Float ratingCount)
    {
        this.ratingCount = ratingCount;
    }

    public List<String> getGenres()
    {
        return genres;
    }

    public void setGenres(List<String> genres)
    {
        this.genres = genres;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }

    public List<String> getCountries()
    {
        return countries;
    }

    public void setCountries(List<String> countries)
    {
        this.countries = countries;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDateFormatted()
    {
        return releaseDateFormatted;
    }

    public void setReleaseDateFormatted(String releaseDateFormatted)
    {
        this.releaseDateFormatted = releaseDateFormatted;
    }

    public List<String> getLanguages()
    {
        return languages;
    }

    public void setLanguages(List<String> languages)
    {
        this.languages = languages;
    }

    public List<String> getRecommendedTitles()
    {
        return recommendedTitles;
    }

    public void setRecommendedTitles(List<String> recommendedTitles)
    {
        this.recommendedTitles = recommendedTitles;
    }

    public String getBudget()
    {
        return budget;
    }

    public void setBudget(String budget)
    {
        this.budget = budget;
    }

    public String getCumulativeGross()
    {
        return cumulativeGross;
    }

    public void setCumulativeGross(String cumulativeGross)
    {
        this.cumulativeGross = cumulativeGross;
    }

    public List<String> getPlotKeywords()
    {
        return plotKeywords;
    }

    public void setPlotKeywords(List<String> plotKeywords)
    {
        this.plotKeywords = plotKeywords;
    }

    public String getAlsoKnownAs()
    {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(String alsoKnownAs)
    {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getStoryLine()
    {
        return storyLine;
    }

    public void setStoryLine(String storyLine)
    {
        this.storyLine = storyLine;
    }

    public Integer getOscars()
    {
        return oscars;
    }

    public void setOscars(Integer oscars)
    {
        this.oscars = oscars;
    }

    public Integer getAwards()
    {
        return awards;
    }

    public void setAwards(Integer awards)
    {
        this.awards = awards;
    }

    public Integer getNominations()
    {
        return nominations;
    }

    public void setNominations(Integer nominations)
    {
        this.nominations = nominations;
    }

    public String getPoster()
    {
        return poster;
    }

    public void setPoster(String poster)
    {
        this.poster = poster;
    }

    public String getPosterLarge()
    {
        return posterLarge;
    }

    public void setPosterLarge(String posterLarge)
    {
        this.posterLarge = posterLarge;
    }
}
