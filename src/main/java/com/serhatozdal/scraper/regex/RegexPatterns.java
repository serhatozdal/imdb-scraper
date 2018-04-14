package com.serhatozdal.scraper.regex;

/**
 * @author serhatozdal
 */
public class RegexPatterns {

    protected static final String A_HREF_ALL = "<a.*?>(.*?)</a>";
    protected static final String A_HREF_SPAN = "<a.*?<span.*?>(.*?)</span>";
    protected static final String ALL_HTML_TAGS = "\\<[^>]*>";

    protected static final String IMDB_CONTENT_TYPE = "'og:type' content=\"(.*?)\"";
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
    protected static final String IMDB_POSTER_REPLACE = "_V1_(.*?).jpg";
    protected static final String IMDB_POSTER_SMALL = "_V1_SY300.jpg";
    protected static final String IMDB_POSTER_LARGE = "_V1_SY500.jpg";
    protected static final String IMDB_PERSON_KEY_VALUE = "<a href=\"/name/(.*?)/.*?> (.*?)</a>";
    protected static final String IMDB_DIRECTORS = "<h4 class=\"dataHeaderWithBorder\">.*?Directed by(.*?)</table>";
    protected static final String IMDB_WRITERS = "<h4 class=\"dataHeaderWithBorder\">.*?Writing Credits(.*?)</table>";
    protected static final String IMDB_PRODUCERS = "<h4 class=\"dataHeaderWithBorder\">.*?Produced by(.*?)</table>";
    protected static final String IMDB_MUSICIANS = "<h4 class=\"dataHeaderWithBorder\">.*?Music by(.*?)</table>";
    protected static final String IMDB_CAST = "class=\"dataHeaderWithBorder\">.*?Cast(.*?)</table>";
    protected static final String IMDB_CAST_KEY_VALUE = "<a href=\"/name/(.*?)/.*?span.*?>(.*?)</span>.*?class=\"character\".*?div>(<a.*?>)?(.*?)(</a>|</div>)";

    protected static final String IMDB_PERSON_KNOWN_FOR = "id=\"knownfor\">(.*?)<script>";
    protected static final String IMDB_PERSON_KNOWN_FOR_VALUE = "class=\"knownfor-title-role\"><a href=\"/title/(.*?)/.*?</a>";
    protected static final String IMDB_PERSON_JOB_CATEGORY = "id=\"name-job-categories\">(.*?)</div>";
    protected static final String IMDB_PERSON_JOB_CATEGORY_VALUE = "<span class=\"itemprop.*?>(.*?)</span>";
    protected static final String IMDB_PERSON_BIRTH_NAME = "Birth Name</td><td>(.*?)</td";
    protected static final String IMDB_PERSON_HEIGHT = "Height</td><td>.*?\\((.*?)\\).*?</td>";
    protected static final String IMDB_PERSON_BORN_DATE = "Born.*?datetime=\"(.*?)\".*?>";
    protected static final String IMDB_PERSON_BORN_PLACE = "Born.*?</time.*?<a.*?>(.*?)</a>";
    protected static final String IMDB_PERSON_DIED_DATE = "Died.*?datetime=\"(.*?)\".*?>";
    protected static final String IMDB_PERSON_DIED_PLACE = "Died.*?</time.*?<a.*?>(.*?)</a>";
    protected static final String IMDB_PERSON_BIOGRAPHY = "Mini Bio.*?<p>(.*?)</p>.*?</p>";
    protected static final String IMDB_PERSON_FILMOGRAPHY = "id=\"filmography\">(.*?)</div><script";
    protected static final String IMDB_PERSON_FILMOGRAPHY_VALUE = "<b><a href=\"/title/(.*?)/.*?</b";
    protected static final String IMDB_PERSON_POSTER = "<div class=\"image\">.*?<img.*?src=\"(.*?)\"";
}
