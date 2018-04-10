package com.serhatozdal.scraper;

import com.google.gson.Gson;
import com.serhatozdal.scraper.model.Person;

/**
 * @author serhatozdal
 */
public class GetPersonById {

    public static void main(String[] args) {
        Scraper scraper = new PersonScraper();
        scraper.downloadPoster(true);
        Person person = (Person) scraper.findById("nm0908094");
        if (person.isFound()) {
            System.out.println(new Gson().toJson(person));
        }
    }
}
