package pl.myGameCollection.searchEngine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExtractFromHLTB {
    private GoogleSearch googleSearch;
    private String hltbUrl;
    private Document hltbSourceCode;

    private String mainStory;
    private String mainPlusExtras;
    private String completionist;
    private String allStyles;
    private boolean hasAdditionalContent = false;
    private List<String[]> dlcs;

    public ExtractFromHLTB(GoogleSearch googleSearch) throws IOException {
        hltbUrl = googleSearch.getWebsiteURL();
        hltbSourceCode = Jsoup.connect(hltbUrl).timeout(4000).get();
        this.googleSearch = googleSearch;
        checkIfGameHasAdditionalContent();
        getTimes();

        if(this.hasAdditionalContent) {
           this.dlcs = getDLCsTitlesAndTimes();
        }

    }

    private List<String[]> getDLCsTitlesAndTimes() {
        List<String[]> dlc = new ArrayList<>();
        Elements dlcSection = this.hltbSourceCode.select("[class='in scrollable back_primary shadow_box'] [class='spreadsheet']");

        for (Element element : dlcSection) {

            String dlcTitle = element.select("a[href]").text();
            String[] dlcTimes = new String[4];
            int timePointer = 0;

            Pattern pattern = Pattern.compile("^\\d $");

            for (String dlcSectionField : element.text().split(" ")) {

                if(dlcSectionField.contains("h") || (dlcSectionField.contains("m"))){
//                if(pattern.matcher(dlcSectionField).matches()){
                    System.out.println(dlcSectionField);
                    dlcTimes[timePointer] = dlcSectionField;
                    timePointer++;
                }
            }
            String[] dlcInfo = new String[]{dlcTitle, dlcTimes[0], dlcTimes[1], dlcTimes[2], dlcTimes[3]};
            dlc.add(dlcInfo);
        }
        return dlc;
    }

    public void getTimes(){
        Elements times = hltbSourceCode.select("li[class='short time_100']");
        this.mainStory = times.get(0).text();
        this.mainPlusExtras = times.get(1).text();
        this.completionist = times.get(2).text();
        this.allStyles = times.get(3).text();
    }

    public List<String[]> getDlCs() {
        return dlcs;
    }

    public boolean getHasAdditionalContent() {
        return hasAdditionalContent;
    }

    public String getMainStory() {
        return mainStory;
    }

    public String getMainPlusExtras() {
        return mainPlusExtras;
    }

    public String getCompletionist() {
        return completionist;
    }

    public String getAllStyles() {
        return allStyles;
    }


    public void checkIfGameHasAdditionalContent(){
        this.hasAdditionalContent = hltbSourceCode.select("[class='in scrollable back_primary shadow_box']").text().length() != 0;
    }
}
