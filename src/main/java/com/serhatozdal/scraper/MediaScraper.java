package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.ContentType;
import com.serhatozdal.scraper.model.Credits;
import com.serhatozdal.scraper.model.Media;
import com.serhatozdal.scraper.thread.ScraperThreadFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MediaScraper extends Scraper<Media> {

    @Override
    public Media findById(String id) {

        this.id = id;
        content = new Media();

        ScraperThreadFactory threadFactory = new ScraperThreadFactory(exceptionHandler);
        ExecutorService executorService = Executors.newFixedThreadPool(2, threadFactory);

        executorService.execute(this::parseMainPage);
        executorService.execute(this::parseCreditsPage);

        executorService.shutdown();

        while (!executorService.isTerminated());

        return content;
    }

    private void parseMainPage() {

        String imdbUrl = "https://www.imdb.com/title/" + id;
        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            content.setId(id);
            content.setContentType(ContentType.get(match(IMDB_CONTENT_TYPE, html)));
            content.setOriginalTitle(match(IMDB_ORIGINAL_TITLE, html));
            content.setOtherTitle(match(IMDB_OTHER_TITLE, html));
            content.setYear(Optional.ofNullable(match(IMDB_YEAR, html)).map(Short::valueOf).orElse(null));
            content.setRating(Optional.ofNullable(match(IMDB_RATING, html))
                    .map(s -> s.replace(",", ".")).map(Float::valueOf).orElse(null)); // FIXME tr kontrolune gore noktayi virgul yapmak degisecek
            content.setRatingCount(Optional.ofNullable(match(IMDB_RATING_COUNT, html)).map(s -> s.replace(".", "")).map(Integer::valueOf).orElse(null));
            content.setGenres(matchAll(IMDB_GENRES, html));
            content.setDuration(Optional.ofNullable(match(IMDB_DURATION, html)).map(Integer::valueOf).orElse(null));
            content.setCountries(matchAll(A_HREF_ALL, match(IMDB_COUNTRIES, html)));
            content.setReleaseDate(match(IMDB_RELEASE_DATE, html));
            content.setLanguages(matchAll(A_HREF_ALL, match(IMDB_LANGUAGES, html)));
            content.setRecommendedTitles(matchAll(IMDB_RECOMMENDED_TITLES, html));
            content.setBudget(match(IMDB_BUDGET, html));
            content.setCumulativeGross(match(IMDB_CUMULATIVE_GROSS, html));
            content.setPlotKeywords(matchAll(A_HREF_SPAN, match(IMDB_PLOT_KEYWORDS, html)));
            content.setAlsoKnownAs(match(IMDB_ALSO_KNOWN_AS, html));
            content.setStoryLine(Optional.ofNullable(match(IMDB_STORYLINE, html)).map(String::trim).orElse(null));
            content.setOscars(Optional.ofNullable(match(IMDB_OSCARS, html)).map(Integer::valueOf).orElse(null));
            content.setAwards(Optional.ofNullable(match(IMDB_AWARDS, html)).map(Integer::valueOf).orElse(null));
            content.setNominations(Optional.ofNullable(match(IMDB_NOMINATIONS, html)).map(Integer::valueOf).orElse(null));
            String poster = Optional.ofNullable(match(IMDB_POSTER, html)).map(s -> s.replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_SMALL)).orElse(null);
            String posterLarge = Optional.ofNullable(match(IMDB_POSTER, html)).map(s -> s.replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_LARGE)).orElse(null);
            if (Optional.ofNullable(poster).isPresent() && Optional.ofNullable(posterLarge).isPresent() && downloadPoster) {
                poster = url.downloadFileAsBase64(poster);
                posterLarge = url.downloadFileAsBase64(posterLarge);
            }
            content.setPoster(poster);
            content.setPosterLarge(posterLarge);
            content.setFound(true);
        }
    }

    private void parseCreditsPage() {

        String creditsUrl = "https://www.imdb.com/title/" + id + "/fullcredits/";
        Url url = new Url();
        String html = url.fetchHtml(creditsUrl);

        if (!html.isEmpty()) {
            content.setDirectors(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_DIRECTORS, html), 1, 2));
            content.setWriters(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_WRITERS, html), 1, 2));
            content.setProducers(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_PRODUCERS, html), 1, 2));
            content.setMusicians(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_MUSICIANS, html), 1, 2));

            List<String> imdbIds = matchAll(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html));
            List<String> castNames = matchAll(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html), 2);
            List<String> castRoles = matchAll(IMDB_CAST_ROLE_NAMES, match(IMDB_CAST, html));

            List<Credits> casts = new ArrayList<>();
            if (Optional.ofNullable(imdbIds).isPresent() && Optional.ofNullable(castNames).isPresent()
                    && imdbIds.size() == castNames.size()) {
                for (int i = 0; i < imdbIds.size(); i++) {
                    Credits credits = new Credits();
                    credits.setImdbId(imdbIds.get(i));
                    credits.setName(castNames.get(i));
                    credits.setRoleName(castRoles.get(i).replaceAll(ALL_HTML_TAGS, "").replace("&nbsp;", ""));
                    casts.add(credits);
                }
                content.setCast(casts);
            }
        }
    }
}
