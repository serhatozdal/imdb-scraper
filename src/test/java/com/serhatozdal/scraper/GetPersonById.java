package com.serhatozdal.scraper;

import com.serhatozdal.scraper.model.Person;

/**
 * @author serhatozdal
 */
public class GetPersonById {

    public static void main(String[] args) {
        Scraper scraper = new PersonScraper();
        scraper.downloadPoster(true);
        scraper.setExceptionHandler((t, e) -> e.printStackTrace());
        Person person = (Person) scraper.findById("nm0908094");
        if (person.isFound()) {
            System.out.println("Imdb Id          : " + person.getId());
            System.out.println("Birth Name       : " + person.getBirthName());
            System.out.println("Heigth           : " + person.getHeight());
            System.out.println("Born Date        : " + person.getBornDate());
            System.out.println("Born Place       : " + person.getBornPlace());
            System.out.println("Died Date        : " + person.getDiedDate());
            System.out.println("Died Place       : " + person.getDiedPlace());
            System.out.println("Biography        : " + person.getBiography());
            System.out.println("Known For        : " + person.getKnownFor());
            System.out.println("Job Categories   : " + person.getJobCategories());
            System.out.println("Filmography      : " + person.getFilmography());
            System.out.println("Poster           : " + person.getPoster());
            System.out.println("Poster Large     : " + person.getPosterLarge());
        }
    }
}
