package com.serhatozdal.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serhatozdal.scraper.model.Media;
import com.serhatozdal.scraper.regex.Regex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author serhatozdal
 */
@RunWith(Parameterized.class)
public class MediaTests extends Regex {

    private Media expectedMedia;
    private Media actualMedia;

    public MediaTests(String movieId, Media expectedMedia) {
        this.expectedMedia = expectedMedia;
        this.actualMedia = new MediaScraper().findById(movieId);
    }

    @Parameterized.Parameters
    public static Collection prepareParams() throws Exception {
        Media media1 = new ObjectMapper().readValue("{\"originalTitle\":\"The Fast and the Furious\",\"otherTitle\":\"Hizli ve Öfkeli\",\"year\":2001,\"rating\":6.7,\"ratingCount\":303.664,\"genres\":[\"Action\",\"Crime\",\"Thriller\"],\"duration\":106,\"countries\":[\"USA\",\"Germany\"],\"releaseDate\":\"2 November 2001\",\"languages\":[\"English\"],\"recommendedTitles\":[\"tt0322259\",\"tt1013752\",\"tt0463985\",\"tt1596343\",\"tt1905041\",\"tt2820852\",\"tt4630562\",\"tt0293662\",\"tt1320253\",\"tt1764651\",\"tt0388482\",\"tt0418279\"],\"budget\":\"$38,000,000\",\"cumulativeGross\":\" $207,283,925, \",\"plotKeywords\":[\"illegal street racing\",\"undercover cop\",\"truck\",\"robbery\",\"trucker\"],\"alsoKnownAs\":\"Hizli ve Öfkeli\",\"storyLine\":\"Los Angeles street racer Dominic Toretto falls under the suspicion of the LAPD as a string of high-speed electronics truck robberies rocks the area. Brian O\\u0027Connor, an officer of the LAPD, joins the ranks of Toretto\\u0027s highly skilled racing crew undercover to convict Toretto. However, O\\u0027Connor finds himself both enamored with this new world and in love with Toretto\\u0027s sister, Mia. As a rival racing crew gains strength, O\\u0027Connor must decide where his loyalty really lies.                \",\"awards\":11,\"nominations\":12,\"directors\":[{\"imdbId\":\"nm0003418\",\"name\":\"Rob Cohen\"},{\"imdbId\":\"nm3094672\",\"name\":\"Mel City\"}],\"writers\":[{\"imdbId\":\"nm0508446\",\"name\":\"Ken Li\"},{\"imdbId\":\"nm0860155\",\"name\":\"Gary Scott Thompson\"},{\"imdbId\":\"nm0860155\",\"name\":\"Gary Scott Thompson\"},{\"imdbId\":\"nm0074980\",\"name\":\"Erik Bergquist\"},{\"imdbId\":\"nm0043742\",\"name\":\"David Ayer\"}],\"producers\":[{\"imdbId\":\"nm0069011\",\"name\":\"Creighton Bellinger\"},{\"imdbId\":\"nm0165602\",\"name\":\"Doug Claybourne\"},{\"imdbId\":\"nm0605775\",\"name\":\"Neal H. Moritz\"},{\"imdbId\":\"nm0688282\",\"name\":\"John Pogue\"}],\"musicians\":[{\"imdbId\":\"nm0117741\",\"name\":\"BT\"}],\"cast\":[{\"imdbId\":\"nm0908094\",\"name\":\"Paul Walker\",\"roleName\":\"Brian O\\u0027Conner\"},{\"imdbId\":\"nm0004874\",\"name\":\"Vin Diesel\",\"roleName\":\"Dominic Toretto\"},{\"imdbId\":\"nm0735442\",\"name\":\"Michelle Rodriguez\",\"roleName\":\"Letty\"},{\"imdbId\":\"nm0108287\",\"name\":\"Jordana Brewster\",\"roleName\":\"Mia Toretto\"},{\"imdbId\":\"nm0950935\",\"name\":\"Rick Yune\",\"roleName\":\"Johnny Tran\"},{\"imdbId\":\"nm0511349\",\"name\":\"Chad Lindberg\",\"roleName\":\"Jesse\"},{\"imdbId\":\"nm0835001\",\"name\":\"Johnny Strong\",\"roleName\":\"Leon\"},{\"imdbId\":\"nm0776580\",\"name\":\"Matt Schulze\",\"roleName\":\"Vince\"},{\"imdbId\":\"nm0505971\",\"name\":\"Ted Levine\",\"roleName\":\"Sgt. Tanner\"},{\"imdbId\":\"nm0750019\",\"name\":\"Ja Rule\",\"roleName\":\"Edwin\"},{\"imdbId\":\"nm0749490\",\"name\":\"Vyto Ruginis\",\"roleName\":\"Harry\"},{\"imdbId\":\"nm0058175\",\"name\":\"Thom Barry\",\"roleName\":\"Agent Bilkins\"},{\"imdbId\":\"nm0752092\",\"name\":\"Stanton Rutledge\",\"roleName\":\"Muse\"},{\"imdbId\":\"nm0346595\",\"name\":\"Noel Gugliemi\",\"roleName\":\"Hector\"},{\"imdbId\":\"nm1005202\",\"name\":\"R.J. de Vera\",\"roleName\":\"Danny Yamato\"},{\"imdbId\":\"nm0004425\",\"name\":\"Beau Holden\",\"roleName\":\"Ted Gassner\"},{\"imdbId\":\"nm0498046\",\"name\":\"Reggie Lee\",\"roleName\":\"Lance Nguyen\"},{\"imdbId\":\"nm0235011\",\"name\":\"David Douglas\",\"roleName\":\"Rasta Racer\"},{\"imdbId\":\"nm0876248\",\"name\":\"Peter Navy Tuiasosopo\",\"roleName\":\"Samoan Guard\"},{\"imdbId\":\"nm0605775\",\"name\":\"Neal H. Moritz\",\"roleName\":\"Ferrari Driver\"},{\"imdbId\":\"nm0030605\",\"name\":\"Doria Anselmo\",\"roleName\":\"Ferrari Passenger(as Doria Clare Anselmo)\"},{\"imdbId\":\"nm1004798\",\"name\":\"Glenn K. Ota\",\"roleName\":\"Johnny\\u0027s Father\"},{\"imdbId\":\"nm0602605\",\"name\":\"F. Valentino Morales\",\"roleName\":\"Dispatcher\"},{\"imdbId\":\"nm0925237\",\"name\":\"Mike White\",\"roleName\":\"Night Truck Driver\"},{\"imdbId\":\"nm0655392\",\"name\":\"Delphine Pacific\",\"roleName\":\"Racer\\u0027s Edge Clerk\"},{\"imdbId\":\"nm1005810\",\"name\":\"Monica Tamayo\",\"roleName\":\"Monica\"},{\"imdbId\":\"nm1005694\",\"name\":\"Megan Baker\",\"roleName\":\"Gimel\"},{\"imdbId\":\"nm1004364\",\"name\":\"Tammy Monica Gegamian\",\"roleName\":\"Edwin\\u0027s Babe\"},{\"imdbId\":\"nm4832195\",\"name\":\"Dan Andreiu\",\"roleName\":\"Driver(uncredited)\"},{\"imdbId\":\"nm1019707\",\"name\":\"Adam Carrera\",\"roleName\":\"Surfer(uncredited)\"},{\"imdbId\":\"nm0003418\",\"name\":\"Rob Cohen\",\"roleName\":\"Pizza Hut Delivery Guy\"},{\"imdbId\":\"nm0199594\",\"name\":\"Chic Daniel\",\"roleName\":\"LAPD Officer with Shotgun(uncredited)\"},{\"imdbId\":\"nm1121768\",\"name\":\"Renee Garcia\",\"roleName\":\"Racer babe(uncredited)\"},{\"imdbId\":\"nm4771802\",\"name\":\"Da Han\",\"roleName\":\"Driver(uncredited)\"},{\"imdbId\":\"nm3818850\",\"name\":\"Flora Huang\",\"roleName\":\"Biker Girl(uncredited)\"},{\"imdbId\":\"nm0253107\",\"name\":\"Michael G. Kehoe\",\"roleName\":\"Party Crew Member(uncredited)\"},{\"imdbId\":\"nm4036575\",\"name\":\"Sarai Koo\",\"roleName\":\"Asian Female(uncredited)\"},{\"imdbId\":\"nm2938458\",\"name\":\"Julie Krystina\",\"roleName\":\"Racer\\u0027s Girlfriend(uncredited)\"},{\"imdbId\":\"nm4753584\",\"name\":\"Raul Limon\",\"roleName\":\"Cholo Racer(uncredited)\"},{\"imdbId\":\"nm3228790\",\"name\":\"Talia O\\u0027Neal\",\"roleName\":\"Hotty with a body(uncredited)\"},{\"imdbId\":\"nm2526462\",\"name\":\"January Pugh\",\"roleName\":\"Edwin\\u0027s Girl(uncredited)\"},{\"imdbId\":\"nm2776641\",\"name\":\"Angela Rockwood\",\"roleName\":\"Hot Chick(uncredited)\"},{\"imdbId\":\"nm1613152\",\"name\":\"Felicia Tang\",\"roleName\":\"Hot Chick(uncredited)\"},{\"imdbId\":\"nm1466675\",\"name\":\"Vanessa Viola\",\"roleName\":\"Hot Chick(uncredited)\"}],\"id\":\"tt0232500\",\"contentType\":\"MOVIE\",\"poster\":\"https://ia.media-imdb.com/images/M/MV5BNzlkNzVjMDMtOTdhZC00MGE1LTkxODctMzFmMjkwZmMxZjFhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY300.jpg\",\"posterLarge\":\"https://ia.media-imdb.com/images/M/MV5BNzlkNzVjMDMtOTdhZC00MGE1LTkxODctMzFmMjkwZmMxZjFhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY500.jpg\"}", Media.class);
        return Arrays.asList(new Object[][] {
            {"tt0232500", media1}
        });
    }

    @Test
    public void contentType() {
        assertEquals(expectedMedia.getContentType(), actualMedia.getContentType());
    }

    // TODO title & original_title should be added

    @Test
    public void year() {
        assertEquals(expectedMedia.getYear(), actualMedia.getYear());
    }

    @Test
    public void rating() {
        assertEquals(expectedMedia.getRating(), actualMedia.getRating());
    }

    @Test
    public void ratingCount() {
        assertEquals(expectedMedia.getRatingCount(), actualMedia.getRatingCount());
    }
}
