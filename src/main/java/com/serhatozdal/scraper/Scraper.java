package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Content;
import com.serhatozdal.scraper.regex.Regex;

/**
 * @author serhatozdal
 */
abstract public class Scraper extends Regex
{
    protected Boolean downloadPoster = false;

    public void downloadPoster(Boolean downloadPoster) {
        this.downloadPoster = downloadPoster;
    }

    public abstract Content findById(String id);
}
