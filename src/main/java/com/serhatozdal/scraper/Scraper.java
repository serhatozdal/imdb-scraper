package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.Credits;
import com.serhatozdal.scraper.model.Media;
import com.serhatozdal.scraper.util.DateUtil;
import com.serhatozdal.scraper.regex.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author serhatozdal
 */
final public class Scraper extends Regex
{
    private Boolean downloadPoster = false;

    public Scraper() {

    }

    public Media findMediaById(String id) {

        final Media media = new Media();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Thread thread1 = new Thread(() -> parseMainPage(id, media));
        Thread thread2 = new Thread(() -> parseCreditsPage(id, media));

        executorService.execute(thread1);
        executorService.execute(thread2);

        executorService.shutdown();
        while (!executorService.isTerminated());

        return media;
    }

    private synchronized void parseMainPage(String id, Media media) {

        String imdbUrl = "http://www.imdb.com/title/" + id;
        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        if (!html.isEmpty()) {
            media.setId(id);
            media.setMediaType(match(MEDIA_TYPE, html));
            media.setOriginalTitle(match(IMDB_ORIGINAL_TITLE, html));
            media.setOtherTitle(match(IMDB_OTHER_TITLE, html));
            media.setYear(Short.valueOf(match(IMDB_YEAR, html)));
            media.setRating(Float.valueOf(match(IMDB_RATING, html).replace(",", "."))); // FIXME tr kontrolune gore noktayi virgul yapmak degisecek
            media.setRatingCount(Float.valueOf(match(IMDB_RATING_COUNT, html)));
            media.setGenres(matchAll(IMDB_GENRES, html));
            media.setDuration(Integer.valueOf(match(IMDB_DURATION, html)));
            media.setCountries(matchAll(A_HREF_ALL, match(IMDB_COUNTRIES, html)));
            media.setReleaseDate(match(IMDB_RELEASE_DATE, html));
            media.setReleaseDateFormatted(DateUtil.format(DateUtil.getDate(match(IMDB_RELEASE_DATE, html)), "yyyy-MM-dd"));
            media.setLanguages(matchAll(A_HREF_ALL, match(IMDB_LANGUAGES, html)));
            media.setRecommendedTitles(matchAll(IMDB_RECOMMENDED_TITLES, html));
            media.setBudget(match(IMDB_BUDGET, html));
            media.setCumulativeGross(match(IMDB_CUMULATIVE_GROSS, html));
            media.setPlotKeywords(matchAll(A_HREF_SPAN, match(IMDB_PLOT_KEYWORDS, html)));
            media.setAlsoKnownAs(match(IMDB_ALSO_KNOWN_AS, html));
            media.setStoryLine(match(IMDB_STORYLINE, html));
            media.setOscars(!match(IMDB_OSCARS, html).equals("") ? Integer.valueOf(match(IMDB_OSCARS, html)) : null);
            media.setAwards(!match(IMDB_AWARDS, html).equals("") ? Integer.valueOf(match(IMDB_AWARDS, html)) : null);
            media.setNominations(!match(IMDB_NOMINATIONS, html).equals("") ? Integer.valueOf(match(IMDB_NOMINATIONS, html)) : null);
            media.setPoster(match(IMDB_POSTER, html).replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_SMALL));
            media.setPosterLarge(match(IMDB_POSTER, html).replaceAll(IMDB_POSTER_REPLACE, IMDB_POSTER_LARGE));
            media.setMediaFound(true);
        }
    }

    private synchronized void parseCreditsPage(String id, Media media) {

        String creditsUrl = "http://www.imdb.com/title/" + id + "/fullcredits/";
        Url url = new Url();
        String html = url.fetchHtml(creditsUrl);

        if (!html.isEmpty()) {
            media.setDirectors(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_DIRECTORS, html), 1, 2));
            media.setWriters(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_WRITERS, html), 1, 2));
            media.setProducers(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_PRODUCERS, html), 1, 2));
            media.setMusicians(matchAllCredits(IMDB_PERSON_KEY_VALUE, match(IMDB_MUSICIANS, html), 1, 2));
            media.setCast(matchAllCredits(IMDB_CAST_KEY_VALUE, match(IMDB_CAST, html), 1, 2));
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
                media.setCast(casts);
            }
        }
    }

    public void downloadPoster(Boolean downloadPoster) {
        this.downloadPoster = downloadPoster;
    }
}
