package pl.myGameCollection.searchEngine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestCreateGoogleSearchURL {


    @Test
    void testInvalidTitleAndPlatform() {
        //given
        String title = "";
        String platform = "";
        Website website = Website.METACRITIC;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);

        //when
        //then
        assertThat(googleSearch.getGoogleSeachURL()).isEqualTo("").as("Should be empty");
    }

    @Test
    void testInvalidTitle() {
        //given
        String title = "witcher 3";
        String platform = "";
        Website website = Website.METACRITIC;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);

        //when
        //then
        assertThat(googleSearch.getGoogleSeachURL()).isEqualTo("").as("Should be empty");
    }

    @Test
    void testInvalidPlatform() {
        //given
        String title = "";
        String platform = "PS4";
        Website website = Website.METACRITIC;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);

        //when
        //then
        assertThat(googleSearch.getGoogleSeachURL()).isEqualTo("").as("Should be empty");
    }

    @Test
    void testSameGameDifferentPlatformDifferentWebsites() {
        //given
        String title = "Rayman Legends";
        String[] platforms = new String[]{"PS4", "XBOX ONE", "PSV", "WII U", "X360", "PS3", "PC"};
        Website website1 = Website.METACRITIC;
        Website website2 = Website.HLTB;

        GoogleSearch googleSearch1 = new GoogleSearch(title, platforms[0], website1);
        GoogleSearch googleSearch2 = new GoogleSearch(title, platforms[1], website2);
        GoogleSearch googleSearch3 = new GoogleSearch(title, platforms[2], website1);
        GoogleSearch googleSearch4 = new GoogleSearch(title, platforms[3], website2);
        GoogleSearch googleSearch5 = new GoogleSearch(title, platforms[4], website1);
        GoogleSearch googleSearch6 = new GoogleSearch(title, platforms[5], website2);
        GoogleSearch googleSearch7 = new GoogleSearch(title, platforms[6], website1);

        //when
        //then
        assertThat(googleSearch1.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+PS4+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+PS4+metacritic+site://metacritic.com");

        assertThat(googleSearch2.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+XBOX+ONE+hltb+site://howlongtobeat.com/")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+XBOX+ONE+hltb+site://howlongtobeat.com/");

        assertThat(googleSearch3.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+PSV+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+PSV+metacritic+site://metacritic.com");

        assertThat(googleSearch4.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+WII+U+hltb+site://howlongtobeat.com/")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+WII+U+hltb+site://howlongtobeat.com/");

        assertThat(googleSearch5.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+X360+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+X360+metacritic+site://metacritic.com");

        assertThat(googleSearch6.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+PS3+hltb+site://howlongtobeat.com/")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+PS3+hltb+site://howlongtobeat.com/");

        assertThat(googleSearch7.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+PC+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+PC+metacritic+site://metacritic.com");
    }

    @Test
    void testDifferentGameSamePlatformDifferentWebsites() {
        //given
        String[] titles = new String[]{"Rayman Legends", "Witcher 3", "Fifa 20"};
        String platform = "PS4";
        Website website1 = Website.METACRITIC;
        Website website2 = Website.HLTB;

        GoogleSearch googleSearch1 = new GoogleSearch(titles[0], platform, website1);
        GoogleSearch googleSearch2 = new GoogleSearch(titles[1], platform, website2);
        GoogleSearch googleSearch3 = new GoogleSearch(titles[2], platform, website1);

        //when
        //then
        assertThat(googleSearch1.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Rayman+Legends+PS4+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Rayman+Legends+PS4+metacritic+site://metacritic.com");

        assertThat(googleSearch2.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Witcher+3+PS4+hltb+site://howlongtobeat.com/")
                .as("Should be: https://www.google.com/search?q=Witcher+3+PS4+hltb+site://howlongtobeat.com/");

        assertThat(googleSearch3.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Fifa+20+PS4+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Fifa+20+PS4+metacritic+site://metacritic.com");

    }

    @Test
    void testSameGameSamePlatformDifferentWebsites() {
        //given
        String title = "Uncharted";
        String platform = "PS3";
        Website website1 = Website.METACRITIC;
        Website website2 = Website.HLTB;

        GoogleSearch googleSearch1 = new GoogleSearch(title, platform, website1);
        GoogleSearch googleSearch2 = new GoogleSearch(title, platform, website2);

        //when
        //then
        assertThat(googleSearch1.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Uncharted+PS3+metacritic+site://metacritic.com")
                .as("Should be: https://www.google.com/search?q=Uncharted+PS3+metacritic+site://metacritic.com");

        assertThat(googleSearch2.getGoogleSeachURL()).isEqualTo("https://www.google.com/search?q=Uncharted+PS3+hltb+site://howlongtobeat.com/")
                .as("Should be: https://www.google.com/search?q=Uncharted+PS3+hltb+site://howlongtobeat.com/");

    }


}