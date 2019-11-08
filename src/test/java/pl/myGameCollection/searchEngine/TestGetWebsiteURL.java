package pl.myGameCollection.searchEngine;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGetWebsiteURL {

    @Test
    void testIfInvalidURLThrowsException() {
        //given
        String title = "";
        String platform = "";
        Website website = Website.METACRITIC;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> googleSearch.getWebsiteURL());
    }

    @Test
    void testIfReturnsFirstGooglePage() throws IOException {
        //given
        GoogleSearch googleSearch1 = new GoogleSearch("", "", Website.METACRITIC);
        GoogleSearch googleSearch2 = new GoogleSearch("", "", Website.METACRITIC);
        GoogleSearch googleSearch3 = new GoogleSearch("", "", Website.METACRITIC);

        googleSearch1.setGoogleSeachURL("https://www.google.com/search?q=gda%C5%84sk");
        googleSearch2.setGoogleSeachURL("https://www.google.com/search?q=java&oq=java");
        googleSearch3.setGoogleSeachURL("https://www.google.com/search?q=assertj");

        //when
        //then
        assertThat(googleSearch1.getWebsiteURL()).isEqualTo("https://www.gdansk.pl/")
                .as("Should be: https://www.gdansk.pl/");

        assertThat(googleSearch2.getWebsiteURL()).isEqualTo("https://www.java.com/pl/download/")
                .as("Should be: https://www.java.com/pl/download/");

        assertThat(googleSearch3.getWebsiteURL()).isEqualTo("https://joel-costigliola.github.io/assertj/")
                .as("Should be: https://joel-costigliola.github.io/assertj/");

    }

}
