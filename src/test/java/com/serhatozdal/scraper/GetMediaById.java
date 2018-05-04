package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Media;

/**
 * @author serhatozdal
 */
public class GetMediaById {

    public static void main(String[] args) {
        Scraper scraper = new MediaScraper();
        Media media = (Media) scraper.findById("tt0232500");
        if (media.isFound()) {
            System.out.println("Imdb Id            : " + media.getId());
            System.out.println("Content Type       : " + media.getContentType());
            System.out.println("Original Title     : " + media.getOriginalTitle());
            System.out.println("Other Title        : " + media.getOtherTitle());
            System.out.println("Year               : " + media.getYear());
            System.out.println("Rating             : " + media.getRating());
            System.out.println("Rating Count       : " + media.getRatingCount());
            System.out.println("Genres             : " + media.getGenres());
            System.out.println("Duration           : " + media.getDuration());
            System.out.println("Countries          : " + media.getCountries());
            System.out.println("Release Date       : " + media.getReleaseDate());
            System.out.println("Languages          : " + media.getLanguages());
            System.out.println("Recommended Titles : " + media.getRecommendedTitles());
            System.out.println("Budget             : " + media.getBudget());
            System.out.println("Cumulative Gross   : " + media.getCumulativeGross());
            System.out.println("Plot Keywords      : " + media.getPlotKeywords());
            System.out.println("Also Known As      : " + media.getAlsoKnownAs());
            System.out.println("Story Line         : " + media.getStoryLine());
            System.out.println("Oscars             : " + media.getOscars());
            System.out.println("Awards             : " + media.getAwards());
            System.out.println("Nominations        : " + media.getNominations());
            System.out.print("Directors          : ");
                media.getDirectors().forEach(i -> System.out.print(i.getImdbId() + " " + i.getName() + " "));
                System.out.println();
            System.out.print("Writers            : ");
                media.getWriters().forEach(i -> System.out.print(i.getImdbId() + " " + i.getName() + " "));
                System.out.println();
            System.out.print("Producers          : ");
                media.getProducers().forEach(i -> System.out.print(i.getImdbId() + " " + i.getName() + " "));
                System.out.println();
            System.out.print("Musicians          : ");
                media.getMusicians().forEach(i -> System.out.print(i.getImdbId() + " " + i.getName() + " "));
                System.out.println();
            System.out.print("Cast               : ");
                media.getCast().forEach(i -> System.out.print(i.getImdbId() + " " + i.getName() + " " + i.getRoleName() + " "));
                System.out.println();
            System.out.println("Poster URL         : " + media.getPoster());
            System.out.println("Poster Large URL   : " + media.getPosterLarge());
        }
    }
}
