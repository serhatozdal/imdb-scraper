package com.serhatozdal.scraper.regex;

/**
 * @author serhatozdal
 */
public class RegexPatterns
{
    protected static final String A_HREF_ALL = "<a.*?>(.*?)</a>";
    protected static final String A_HREF_SPAN = "<a.*?<span.*?>(.*?)</span>";
    protected static final String MEDIA_TYPE = "'og:type' content=\"(.*?)\"";
    protected static final String IMDB_ORIGINAL_TITLE = "property='og:title' content=\"(.*?)(\"| \\()";
    protected static final String IMDB_OTHER_TITLE = "<title>(.*?)( \\().*</title>";
    protected static final String IMDB_YEAR = "property='og:title' content=\".*?([0-9]{4}).*?\"";
    protected static final String IMDB_RATING = "<span itemprop=\"ratingValue\">(.*?)</span>";
    protected static final String IMDB_RATING_COUNT = "<span class=\"small\" itemprop=\"ratingCount\">(.*?)</span>";
    protected static final String IMDB_GENRES = "<span class=\"itemprop\" itemprop=\"genre\">(.*?)</span>";
    protected static final String IMDB_DURATION = "Runtime:</h4><time.*?>(\\d+) min</time>";
    protected static final String IMDB_COUNTRIES = "Country:(.*?)(</div>|>.?and)";
    protected static final String IMDB_RELEASE_DATE = "Release Date:</h4>.*?(\\d{1,2} (January|February|March|April|May|June|July|August|September|October|November|December) (19|20)\\d{2})";
    protected static final String IMDB_LANGUAGES = "Language:(.*?)(</div>)";
    protected static final String IMDB_RECOMMENDED_TITLES = "<div class=\"rec_item\".*?<a href=\".*?/(tt.*?)/.*?\">.*?</a>";
    protected static final String IMDB_BUDGET = "<h4.*?Budget:</h4>(.*?)(<span.*?|</div>)";
    protected static final String IMDB_CUMULATIVE_GROSS = "class=\"inline\">Cumulative Worldwide Gross:</h4>(.*?)(<span.*?|</div)";
    protected static final String IMDB_PLOT_KEYWORDS = "<div class=\"see-more inline canwrap\" itemprop=\"keywords\">(.*?)</div>";
    protected static final String IMDB_ALSO_KNOWN_AS = "Also Known As:</h4> (.*?)(<span.*?>|</div>)";
    protected static final String IMDB_STORYLINE = "itemprop=\"description\"><p>(.*?)(<em.*|</p>)";
    protected static final String IMDB_OSCARS = "itemprop=\"awards\"><b>.*Won(\\d+)Oscars.*</b";
    protected static final String IMDB_AWARDS = "(\\d+) wins";
    protected static final String IMDB_NOMINATIONS = "(\\d+) nominations";
    protected static final String IMDB_POSTER = "<div class=\"poster\">.*?<img.*?src=\"(.*?)\"";
}
