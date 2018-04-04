package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;

/**
 * @author msozdal
 */
public class Test {

    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        scraper.findMediaById("tt0232500");
    }
}
