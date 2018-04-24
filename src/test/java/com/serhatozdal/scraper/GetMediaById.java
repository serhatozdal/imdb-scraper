package com.serhatozdal.scraper;

import com.google.gson.Gson;
import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class GetMediaById {

    public static void main(String[] args) {
        Scraper scraper = new MediaScraper();
//        scraper.downloadPoster(true);
//        Media media = (Media) scraper.findById("tt0232500");
//        Media media = (Media) scraper.findById("tt0106582");
//        Media media = (Media) scraper.findById("tt0163151");
//        Media media = (Media) scraper.findById("tt1189031"); // 404 not found
//        Media media = (Media) scraper.findById("tt4428398");
//        Media media = (Media) scraper.findById("tt3032476");
//        Media media = (Media) scraper.findById("tt0176703");
        Media media = (Media) scraper.findById("tt6468322"); // la casa de papel
        if (media.isFound()) {
            System.out.println(new Gson().toJson(media));
        }
    }
}
