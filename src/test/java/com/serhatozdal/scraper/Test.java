package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class Test {

    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        Media media = scraper.findMediaById("tt0232500");
    }
}
