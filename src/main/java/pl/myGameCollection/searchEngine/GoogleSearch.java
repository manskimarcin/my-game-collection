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

        createGoogleSearchURL(this.gameTitle, this.platform, this.website);
    }

    public void createGoogleSearchURL(String title, String platform, Website website){
        String prefix = "http://www.google.com/search?q=";
        String search = title + platform;
        String suffix = "";

        if(website.equals(Website.METACRITIC))
            suffix = " metacritic site://metacritic.com";
        else
            suffix = " hltb site://howlongtobeat.com/";

        this.googleSeachURL = (prefix + search + suffix).replaceAll(" ", "+");
    }

    public String getWebsiteURL() throws IOException {

        Document document = Jsoup.connect(this.googleSeachURL).get();

        Elements sites = document.select("[class='r']");
        Element url = sites.select("a[href]").first();

        String result = url.absUrl("href");

        this.url = result;

        return result;
    }

    public String getGoogleSeachURL() {
        return googleSeachURL;
    }

}
