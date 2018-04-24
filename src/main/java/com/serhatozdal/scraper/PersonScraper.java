package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.ContentType;
import com.serhatozdal.scraper.model.Person;
import com.serhatozdal.scraper.thread.ScraperThreadFactory;
import com.serhatozdal.scraper.util.HtmlEntities;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PersonScraper extends Scraper<Person> {

    @Override
    public Person findById(String id) {

        this.id = id;
        content = new Person();

        ScraperThreadFactory threadFactory = new ScraperThreadFactory(exceptionHandler);
        ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);

        executorService.execute(this::parseMainPage);
        executorService.execute(this::parseBiographyPage);

        executorService.shutdown();
        while (!executorService.isTerminated());

        return content;
    }

    private void parseMainPage() {

        String imdbUrl = "https://www.imdb.com/name/" + id;

        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            content.setId(id);
            content.setName(match(IMDB_ORIGINAL_TITLE, html));
            content.setContentType(ContentType.get(match(IMDB_CONTENT_TYPE, html)));
            content.setKnownFor(matchAll(IMDB_PERSON_KNOWN_FOR_VALUE, match(IMDB_PERSON_KNOWN_FOR, html)));
            content.setJobCategories(matchAll(IMDB_PERSON_JOB_CATEGORY_VALUE, match(IMDB_PERSON_JOB_CATEGORY, html)));
            content.setFilmography(matchAll(IMDB_PERSON_FILMOGRAPHY_VALUE, match(IMDB_PERSON_FILMOGRAPHY, html)));
            String poster = Optional.ofNullable(match(IMDB_PERSON_POSTER, html)).map(s -> s.replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_SMALL)).orElse(null);
            String posterLarge = Optional.ofNullable(match(IMDB_PERSON_POSTER, html)).map(s -> s.replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_LARGE)).orElse(null);
            if (Optional.ofNullable(poster).isPresent() && Optional.ofNullable(posterLarge).isPresent() && downloadPoster) {
                poster = url.downloadFileAsBase64(poster);
                posterLarge = url.downloadFileAsBase64(posterLarge);
            }
            content.setPoster(poster);
            content.setPosterLarge(posterLarge);

            content.setFound(true);
        }
    }

    private void parseBiographyPage() {

        String imdbUrl = "https://www.imdb.com/name/" + id + "/bio";

        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            content.setBirthName(match(IMDB_PERSON_BIRTH_NAME, html));
            content.setHeight(Optional.ofNullable(match(IMDB_PERSON_HEIGHT, html)).map(HtmlEntities::decode).orElse(null));
            content.setBornDate(match(IMDB_PERSON_BORN_DATE, html));
            content.setBornPlace(match(IMDB_PERSON_BORN_PLACE, html));
            content.setDiedDate(match(IMDB_PERSON_DIED_DATE, html));
            content.setDiedPlace(match(IMDB_PERSON_DIED_PLACE, html));
            content.setBiography(Optional.ofNullable(match(IMDB_PERSON_BIOGRAPHY, html)).map(s -> s.replaceAll(ALL_HTML_TAGS, "")).orElse(null));
        }
    }
}
