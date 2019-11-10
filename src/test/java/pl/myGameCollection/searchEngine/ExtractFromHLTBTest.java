package pl.myGameCollection.searchEngine;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

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

        List<String[]> list = extractFromHLTB.getDlCs();

        for (String[] strings : list) {
            for (String string : strings) {
                System.out.println(string);
            }
        }
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

    @Test
    void testIfSelectorsWorksProperlyForMafia3() throws IOException {
        String title = "mafia 3";
        String platform = "XBOX ONE";
        Website website = Website.HLTB;
        GoogleSearch googleSearch = new GoogleSearch(title, platform, website);
        ExtractFromHLTB extractFromHLTB = new ExtractFromHLTB(googleSearch);

        System.out.println(extractFromHLTB.getMainStory());
        System.out.println(extractFromHLTB.getMainPlusExtras());
        System.out.println(extractFromHLTB.getCompletionist());
        System.out.println(extractFromHLTB.getAllStyles());
        System.out.println(extractFromHLTB.getHasAdditionalContent());

        List<String[]> list = extractFromHLTB.getDlCs();

        for (String[] strings : list) {
            for (String string : strings) {
                System.out.println(string);
            }
        }
    }

    @Test
    void checkTheRegex(){
        String input1 = "That";
        String input2 = "20m";
        String input3 = "3h";
        String input4 = "15h35m";
        String input5 = "sgsdg";

        Pattern pattern = Pattern.compile("^[0-9]");


        System.out.println(pattern.matcher(input1).matches());
        System.out.println(pattern.matcher(input2).matches());
        System.out.println(pattern.matcher(input3).matches());
        System.out.println(pattern.matcher(input4).matches());
        System.out.println(pattern.matcher(input5).matches());

//        assertThat(pattern.matcher(input1).matches()).isFalse();
//        assertThat(pattern.matcher(input2).matches()).isTrue();
//        assertThat(pattern.matcher(input3).matches()).isTrue();
//        assertThat(pattern.matcher(input4).matches()).isTrue();
//        assertThat(pattern.matcher(input5).matches()).isFalse();
    }

    @Test
    void checkTheRegexUdemy(){
        String input1 = "12345";
        String input2 = "12345s";

        Pattern pattern = Pattern.compile("^\\d+$");

        assertThat(pattern.matcher(input1).matches()).isTrue();
        assertThat(pattern.matcher(input2).matches()).isFalse();
    }

}