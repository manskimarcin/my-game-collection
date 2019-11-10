package pl.myGameCollection.searchEngine;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtractFromHLTBTest {

    @Test
    void testIfSelectorsWorksProperlyForWitcher3() throws IOException {
        String title = "witcher 3";
        String platform = "PS4";
        Website website = Website.HLTB;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);
        ExtractFromHLTB extractFromHLTB = new ExtractFromHLTB(googleSearch);

        System.out.println(extractFromHLTB.getMainStory());
        System.out.println(extractFromHLTB.getMainPlusExtras());
        System.out.println(extractFromHLTB.getCompletionist());
        System.out.println(extractFromHLTB.getAllStyles());
        System.out.println(extractFromHLTB.getHasAdditionalContent());
    }

    @Test
    void testIfSelectorsWorksProperlyForSuperMarioGalaxy() throws IOException {
        String title = "Super Mario Galaxy";
        String platform = "WII";
        Website website = Website.HLTB;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);
        ExtractFromHLTB extractFromHLTB = new ExtractFromHLTB(googleSearch);

        System.out.println(extractFromHLTB.getMainStory());
        System.out.println(extractFromHLTB.getMainPlusExtras());
        System.out.println(extractFromHLTB.getCompletionist());
        System.out.println(extractFromHLTB.getAllStyles());
        System.out.println(extractFromHLTB.getHasAdditionalContent());
    }

}