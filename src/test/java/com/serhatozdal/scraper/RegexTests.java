package com.serhatozdal.scraper;

import com.serhatozdal.scraper.http.Url;
import com.serhatozdal.scraper.regex.Regex;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author msozdal
 */
public class RegexTests extends Regex {

    String html = null;

    public RegexTests() {
        html = new Url().fetchHtml("http://www.imdb.com/title/tt0232500");
        if (html == null)
            System.exit(1);
    }

    @Test
    public void yearTest() {
        System.out.println(this.html);
        String html = "<meta property='og:title' content=\"Pulp Fiction (1994)\" />";
        assertEquals("1994", match(IMDB_YEAR, html));
    }
}
