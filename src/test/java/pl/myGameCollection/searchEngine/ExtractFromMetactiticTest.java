package pl.myGameCollection.searchEngine;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class ExtractFromMetactiticTest {

    @Test
    void testIfSelectorsWorksProperly() throws IOException {
//        String title = "witcher 3";
        String title = "super mario galaxy";
        String platform = "Wii";
        Website website = Website.METACRITIC;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);

        ExtractFromMetactitic extractFromMetactitic = new ExtractFromMetactitic(googleSearch);

        System.out.println(extractFromMetactitic.getGameTitle());
        System.out.println(extractFromMetactitic.getPlatform());
        System.out.println(extractFromMetactitic.getOtherPlatforms());

        System.out.println(extractFromMetactitic.getMetascore());
        System.out.println(extractFromMetactitic.getUserScore());

        System.out.println(extractFromMetactitic.getPublisher());
        System.out.println(extractFromMetactitic.getReleaseDate());
    }

}