package pl.myGameCollection.searchEngine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class GoogleSearch {
    private String googleSeachURL;

    private String gameTitle;
    private String platform;

    private String url;
    private Website website;

    public GoogleSearch(String title, String platform,  Website website){
        this.gameTitle = title;
        this.platform = platform;
        this.website = website;
        this.googleSeachURL = createGoogleSearchURL();

    }

    public String createGoogleSearchURL(){
        String prefix = "https://www.google.com/search?q=";
        String search = this.gameTitle + " " + this.platform;
        String suffix = "";

        if(this.gameTitle.isEmpty() || this.platform.isEmpty())
            return "";

        if(website.equals(Website.METACRITIC))
            suffix = " metacritic site://metacritic.com";
        else
            suffix = " hltb site://howlongtobeat.com/";

        return  (prefix + search + suffix).replaceAll(" ", "+");
    }

    public String getWebsiteURL() throws IOException {

        if(this.googleSeachURL.isEmpty())
            throw new IllegalArgumentException("Invalid URL");

        Document document = Jsoup.connect(this.googleSeachURL).timeout(4000).get();

        Elements sites = document.select("[class='r']");
        Element url = sites.select("a[href]").first();

        String result = url.absUrl("href");

        this.url = result;

        return result;
    }

    public String getGoogleSeachURL() {
        return googleSeachURL;
    }
    public void setGoogleSeachURL(String googleSeachURL) {
        this.googleSeachURL = googleSeachURL;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

}
