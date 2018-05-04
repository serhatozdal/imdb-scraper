package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class GetMediaByIdDownloadPosters {

    public static void main(String[] args) {
        Scraper scraper = new MediaScraper();
        scraper.downloadPoster(true);
        Media media = (Media) scraper.findById("tt0232500");
        if (media.isFound()) {
            // Base64 Strings of posters
            System.out.println("Poster URL         : " + media.getPoster());
            System.out.println("Poster Large URL   : " + media.getPosterLarge());
        }
    }
}
