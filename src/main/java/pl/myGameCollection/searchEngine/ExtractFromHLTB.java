package pl.myGameCollection.searchEngine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ExtractFromHLTB {
    private GoogleSearch googleSearch;
    private String hltbUrl;
    private Document hltbSourceCode;

    private String mainStory;
    private String mainPlusExtras;
    private String completionist;
    private String allStyles;
    private boolean hasAdditionalContent = false;

    public ExtractFromHLTB(GoogleSearch googleSearch) throws IOException {
        hltbUrl = googleSearch.getWebsiteURL();
        hltbSourceCode = Jsoup.connect(hltbUrl).get();
        this.googleSearch = googleSearch;
        checkIfGameHasAdditionalContent();
        getTimes();
    }

    public void getTimes(){
        Elements times = hltbSourceCode.select("li[class='short time_100']");
        this.mainStory = times.get(0).text();
        this.mainPlusExtras = times.get(1).text();
        this.completionist = times.get(2).text();
        this.allStyles = times.get(3).text();
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
