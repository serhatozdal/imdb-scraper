package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.Content;
import com.serhatozdal.scraper.model.ContentType;
import com.serhatozdal.scraper.model.Person;
import com.serhatozdal.scraper.util.HtmlEntities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PersonScraper extends Scraper {

    @Override
    public Content findById(String id) {

        final Person person = new Person();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Thread thread1 = new Thread(() -> parseMainPage(id, person));
        Thread thread2 = new Thread(() -> parseBiographyPage(id, person));

        executorService.execute(thread1);
        executorService.execute(thread2);

        executorService.shutdown();
        while (!executorService.isTerminated());

        return person;
    }

    private void parseMainPage(String id, Person person) {

        String imdbUrl = "http://www.imdb.com/name/" + id;

        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            person.setId(id);
            person.setName(match(IMDB_ORIGINAL_TITLE, html));
            person.setContentType(ContentType.get(match(IMDB_CONTENT_TYPE, html)));
            person.setKnownFor(matchAll(IMDB_PERSON_KNOWN_FOR_VALUE, match(IMDB_PERSON_KNOWN_FOR, html)));
            person.setJobCategories(matchAll(IMDB_PERSON_JOB_CATEGORY_VALUE, match(IMDB_PERSON_JOB_CATEGORY, html)));
            person.setFilmography(matchAll(IMDB_PERSON_FILMOGRAPHY_VALUE, match(IMDB_PERSON_FILMOGRAPHY, html)));
            String poster = match(IMDB_PERSON_POSTER, html).replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_SMALL);
            String posterLarge = match(IMDB_PERSON_POSTER, html).replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_LARGE);
            if (downloadPoster) {
                poster = url.downloadFileAsBase64(poster);
                posterLarge = url.downloadFileAsBase64(posterLarge);
            }
            person.setPoster(poster);
            person.setPosterLarge(posterLarge);

            person.setFound(true);
        }
    }

    private void parseBiographyPage(String id, Person person) {

        String imdbUrl = "http://www.imdb.com/name/" + id + "/bio";

        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            person.setBirthName(match(IMDB_PERSON_BIRTH_NAME, html));
            person.setHeight(HtmlEntities.decode(match(IMDB_PERSON_HEIGHT, html)));
            person.setBornDate(match(IMDB_PERSON_BORN_DATE, html));
            person.setBornPlace(match(IMDB_PERSON_BORN_PLACE, html));
            person.setDiedDate(match(IMDB_PERSON_DIED_DATE, html));
            person.setDiedPlace(match(IMDB_PERSON_DIED_PLACE, html));
            person.setBiography(match(IMDB_PERSON_BIOGRAPHY, html).replaceAll(ALL_HTML_TAGS, ""));
        }
    }
}
