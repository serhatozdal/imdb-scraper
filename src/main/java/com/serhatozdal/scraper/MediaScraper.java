package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.ContentType;
import com.serhatozdal.scraper.model.Credits;
import com.serhatozdal.scraper.model.Media;
import com.serhatozdal.scraper.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MediaScraper extends Scraper<Media> {

    @Override
    public Media findById(String id) {

        this.id = id;
        content = new Media();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Thread thread1 = new Thread(this::parseMainPage);
        Thread thread2 = new Thread(this::parseCreditsPage);

        executorService.execute(thread1);
        executorService.execute(thread2);

        executorService.shutdown();

        while (!executorService.isTerminated());

        return content;
    }

    private void parseMainPage() {

        String imdbUrl = "http://www.imdb.com/title/" + id;
        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            content.setId(id);
            content.setContentType(ContentType.get(match(IMDB_CONTENT_TYPE, html)));
            content.setOriginalTitle(match(IMDB_ORIGINAL_TITLE, html));
            content.setOtherTitle(match(IMDB_OTHER_TITLE, html));
            content.setYear(Short.valueOf(match(IMDB_YEAR, html)));
            content.setRating(Float.valueOf(match(IMDB_RATING, html).replace(",", "."))); // FIXME tr kontrolune gore noktayi virgul yapmak degisecek
            content.setRatingCount(Float.valueOf(match(IMDB_RATING_COUNT, html)));
            content.setGenres(matchAll(IMDB_GENRES, html));
            content.setDuration(Integer.valueOf(match(IMDB_DURATION, html)));
            content.setCountries(matchAll(A_HREF_ALL, match(IMDB_COUNTRIES, html)));
            content.setReleaseDate(match(IMDB_RELEASE_DATE, html));
            content.setReleaseDateFormatted(DateUtil.format(DateUtil.getDate(match(IMDB_RELEASE_DATE, html)), "yyyy-MM-dd"));
            content.setLanguages(matchAll(A_HREF_ALL, match(IMDB_LANGUAGES, html)));
            content.setRecommendedTitles(matchAll(IMDB_RECOMMENDED_TITLES, html));
            content.setBudget(match(IMDB_BUDGET, html));
            content.setCumulativeGross(match(IMDB_CUMULATIVE_GROSS, html));
            content.setPlotKeywords(matchAll(A_HREF_SPAN, match(IMDB_PLOT_KEYWORDS, html)));
            content.setAlsoKnownAs(match(IMDB_ALSO_KNOWN_AS, html));
            content.setStoryLine(match(IMDB_STORYLINE, html));
            content.setOscars(!match(IMDB_OSCARS, html).equals("") ? Integer.valueOf(match(IMDB_OSCARS, html)) : null);
            content.setAwards(!match(IMDB_AWARDS, html).equals("") ? Integer.valueOf(match(IMDB_AWARDS, html)) : null);
            content.setNominations(!match(IMDB_NOMINATIONS, html).equals("") ? Integer.valueOf(match(IMDB_NOMINATIONS, html)) : null);
            String poster = match(IMDB_POSTER, html).replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_SMALL);
            String posterLarge = match(IMDB_POSTER, html).replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_LARGE);
            if (downloadPoster) {
                poster = url.downloadFileAsBase64(poster);
                posterLarge = url.downloadFileAsBase64(posterLarge);
            }
            content.setPoster(poster);
            content.setPosterLarge(posterLarge);
            content.setFound(true);
        }
    }

    private synchronized void parseCreditsPage() {

        String creditsUrl = "http://www.imdb.com/title/" + id + "/fullcredits/";
        Url url = new Url();
        String html = url.fetchHtml(creditsUrl);

        if (!html.isEmpty()) {
            content.setDirectors(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_DIRECTORS, html), 1, 2));
            content.setWriters(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_WRITERS, html), 1, 2));
            content.setProducers(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_PRODUCERS, html), 1, 2));
            content.setMusicians(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_MUSICIANS, html), 1, 2));
            content.setCast(matchAllCredits(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html), 1, 2));
            List<String> imdbIds = matchAll(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html));
            List<String> castNames = matchAll(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html), 2);
            List<String> castRoles = matchAll(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html), 4);

            List<Credits> casts = new ArrayList<>();
            if (imdbIds.size() == castNames.size()) {
                for (int i = 0; i < imdbIds.size(); i++) {
                    Credits credits = new Credits();
                    credits.setImdbId(imdbIds.get(i));
                    credits.setName(castNames.get(i));
                    credits.setRoleName(castRoles.get(i));
                    casts.add(credits);
                }
                content.setCast(casts);
            }
        }
    }
}
