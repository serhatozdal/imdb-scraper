package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Media;

/**
 * @author msozdal
 */
public class GetMediaByIdExceptionHandler {

    public static void main(String[] args) {
        Scraper scraper = new MediaScraper();
        scraper.downloadPoster(true);
        // custom exception handler for threads
        scraper.setExceptionHandler((t, e) -> e.printStackTrace());
        Media media = (Media) scraper.findById("tt0232500");
        if (media.isFound()) {
            System.out.println("Imdb Id            : " + media.getId());
            System.out.println("Content Type       : " + media.getContentType());
            System.out.println("Original Title     : " + media.getOriginalTitle());
            // Base64 Strings of posters
            System.out.println("Poster             : " + media.getPoster());
            System.out.println("Poster Large       : " + media.getPosterLarge());
        }
    }
}
