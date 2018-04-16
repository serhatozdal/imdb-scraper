package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.model.ContentType;
import com.serhatozdal.scraper.regex.Regex;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author msozdal
 */
public class RegexTests extends Regex {

    private String html = null;

    public RegexTests() {
        html = new Url().fetchHtml("http://www.imdb.com/title/tt0232500");
        if (html == null)
            fail("test is fail because of html is null!!");
    }

    @Test
    public void contentType() {
        assertEquals(ContentType.MOVIE, ContentType.get(match(IMDB_CONTENT_TYPE, html)));
    }

    @Test
    public void year() {
        Short year = Optional.ofNullable(match(IMDB_YEAR, html)).map(Short::valueOf).orElse(null);
        assertEquals(Short.valueOf("2001"), year);
    }

    @Test
    public void rating() {
        Float rating = Optional.ofNullable(match(IMDB_RATING, html))
                .map(s -> s.replace(",", ".")).map(Float::valueOf).orElse(null);
        assertEquals(Float.valueOf("6.7"), rating);
    }

    @Test
    public void ratingCount() {

    }
}
