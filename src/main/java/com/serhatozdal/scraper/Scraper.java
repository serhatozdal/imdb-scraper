package com.serhatozdal.scraper;

import com.serhatozdal.scraper.regex.Regex;

/**
 * @author serhatozdal
 */
abstract public class Scraper<T> extends Regex
{
    protected volatile String id;
    protected volatile T content;

    protected Boolean downloadPoster = false;

    public void downloadPoster(Boolean downloadPoster) {
        this.downloadPoster = downloadPoster;
    }

    public abstract T findById(String id);
}
