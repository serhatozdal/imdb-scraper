package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.Content;
import com.serhatozdal.scraper.model.Person;

public class PersonScraper extends Scraper {

    @Override
    public Content findById(String id) {

        final Person person = new Person();

        return person;
    }

    private void parseMainPage(String id, Person person) {

        String imdbUrl = "http://www.imdb.com/title/" + id;

        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);
    }
}
