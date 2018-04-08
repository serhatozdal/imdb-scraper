package com.serhatozdal.scraper;

import com.google.gson.Gson;
import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class Test {

    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        scraper.downloadPoster(true);
        Media media = scraper.findMediaById("tt0232500");
        if (media.isMediaFound()) { // media is found
            System.out.println(new Gson().toJson(media));
        }
    }
}
