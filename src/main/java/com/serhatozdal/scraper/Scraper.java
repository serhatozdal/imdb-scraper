package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author serhatozdal
 */
public class Scraper {

    private static final String A_HREF_ALL = "<a.*?>(.*?)</a>";
    private static final String IMDB_ORIGINAL_TITLE = "property='og:title' content=\"(.*?)(\"| \\()";
    private static final String IMDB_OTHER_TITLE = "<title>(.*?)( \\().*</title>";
    private static final String IMDB_YEAR = "property='og:title' content=\".*?([0-9]{4}).*?\"";
    private static final String IMDB_RATING = "<span itemprop=\"ratingValue\">(.*?)</span>";
    private static final String IMDB_RATING_COUNT = "<span class=\"small\" itemprop=\"ratingCount\">(.*?)</span>";
    private static final String IMDB_GENRES = "<span class=\"itemprop\" itemprop=\"genre\">(.*?)</span>";
    private static final String IMDB_DURATION = "Runtime:</h4><time itemprop=\"duration\" datetime=\"PT106M\">(.*?) min</time>";
    private static final String IMDB_COUNTRIES = "Country:(.*?)(</div>|>.?and)";
    private static final String IMDB_RELEASE_DATE = "Release Date:</h4>.*?(\\d{1,2} (January|February|March|April|May|June|July|August|September|October|November|December) (19|20)\\d{2})";
    private static final String IMDB_LANGUAGES = "Language:(.*?)(</div>)";
    private static final String IMDB_RECOMMENDED_TITLES = "<div class=\"rec_item\".*?<a href=\".*?/(tt.*?)/.*?\">.*?</a>";
    private static final String IMDB_BUDGET = "<h4.*?Budget:</h4>(.*?)(<span.*?|</div>)";
    private static final String IMDB_CUMULATIVE_GROSS = "class=\"inline\">Cumulative Worldwide Gross:</h4>(.*?)(<span.*?|</div)";

    private String id;
    private String originalTitle;
    private String otherTitle;
    private Short year;
    private Float rating;
    private Float ratingCount;
    private List<String> genres;
    private Integer duration;
    private List<String> countries;
    private String releaseDate;
    private String releaseDateFormatted;
    private List<String> languages;
    private List<String> recommendedTitles;
    private String budget;
    private String cumulativeGross;

    public Scraper() {

    }

    public void findMediaById(String id) {

        this.id = id;

        String imdbUrl = "http://www.imdb.com/title/" + id;
        Url url = new Url();
        String html = url.fetchHtml(imdbUrl);

        originalTitle = match(IMDB_ORIGINAL_TITLE, html);
        otherTitle = match(IMDB_OTHER_TITLE, html);
        year = Short.valueOf(match(IMDB_YEAR, html));
        rating = Float.valueOf(match(IMDB_RATING, html).replace(",", ".")); // FIXME tr kontrolune gore noktayi virgul yapmak degisecek
        ratingCount = Float.valueOf(match(IMDB_RATING_COUNT, html));
        genres = matchAll(IMDB_GENRES, html);
        duration = Integer.valueOf(match(IMDB_DURATION, html));
        countries = matchAll(A_HREF_ALL, match(IMDB_COUNTRIES, html));
        releaseDate = match(IMDB_RELEASE_DATE, html);
        releaseDateFormatted = DateUtil.format(DateUtil.getDate(match(IMDB_RELEASE_DATE, html)), "yyyy-MM-dd");
        languages = matchAll(A_HREF_ALL, match(IMDB_LANGUAGES, html));
        recommendedTitles = matchAll(IMDB_RECOMMENDED_TITLES, html);
        budget = match(IMDB_BUDGET, html);
        cumulativeGross = match(IMDB_CUMULATIVE_GROSS, html);

        System.out.println(html);

    }

    private String match(String regexPattern, String html) {
        return match(regexPattern, html, 1);
    }

    private String match(String regexPattern, String html, Integer groupIndex) {
        String result = "";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find())
            result = matcher.group(groupIndex);
        return result;
    }

    private List<String> matchAll(String regexPattern, String html) {
        return matchAll(regexPattern, html, 1);
    }

    private List<String> matchAll(String regexPattern, String html, Integer groupIndex) {
        List<String> resultList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find())
            resultList.add(matcher.group(groupIndex));
        return resultList;
    }

}
