package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class GetMediaById {

    public static void main(String[] args) {
        Scraper scraper = new MediaScraper();
        scraper.downloadPoster(true);
        Media media = (Media) scraper.findById("tt0232500");
        if (media.isFound()) {
            System.out.println(media);
        }
    }
}
