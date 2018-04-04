package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.Media;
import com.serhatozdal.scraper.util.DateUtil;
import com.serhatozdal.scraper.regex.Regex;

/**
 * @author serhatozdal
 */
final public class Scraper extends Regex
{

    public Scraper() {

    }

    public Media findMediaById(String id) {

        String imdbUrl = "http://www.imdb.com/title/" + id;
        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);
        Media media = new Media();

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
        media.setPoster(match(IMDB_POSTER, html).replaceAll("_V1_(.*?).jpg", "_V1_SY300.jpg"));
        media.setPosterLarge(match(IMDB_POSTER, html).replaceAll("_V1_(.*?).jpg", "_V1_SY500.jpg"));

        System.out.println(html);

        return media;
    }



}
