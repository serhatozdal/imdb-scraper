package com.serhatozdal.scraper;

import com.google.gson.Gson;
import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class GetMediaById {

    public static void main(String[] args) {
        Scraper scraper = new MediaScraper();
        scraper.downloadPoster(true);
        //Media media = (Media) scraper.findById("tt0232500");
        Media media = (Media) scraper.findById("tt4428398");
        if (media.isFound()) {
            System.out.println(new Gson().toJson(media));
        }
    }
}
