package pl.myGameCollection.searchEngine;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtractFromHLTBTest {

    @Test
    void testIfSelectorsWorksProperly() throws IOException {
        String title = "super mario galaxy";
        String platform = "Wii";
        Website website = Website.HLTB;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);
        ExtractFromHLTB extractFromHLTB = new ExtractFromHLTB(googleSearch);

        System.out.println(extractFromHLTB.getMainStory());
        System.out.println(extractFromHLTB.getMainPlusExtras());
        System.out.println(extractFromHLTB.getCompletionist());
        System.out.println(extractFromHLTB.getAllStyles());

    }

}