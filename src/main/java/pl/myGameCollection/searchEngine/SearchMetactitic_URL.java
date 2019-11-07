package pl.myGameCollection.searchEngine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SearchMetactitic_URL implements Search {
    private String gameTitle;
    private String platform;
    private String url;

    public SearchMetactitic_URL(String[] userInput){
        this.gameTitle = userInput[0];
        this.platform = userInput[1];
    }

    public String getWebsiteURL() {
        String userAgent = "user";
        String google = "http://www.google.com/search?q=";
        String charset = "UTF-8";
        String googleInputText = this.gameTitle + " " + this.platform + " metacritic site://metacritic.com";

        Elements links = null;

        try{
//            Document doc = Jsoup.connect(google + URLEncoder.encode(googleInputText, charset)).userAgent("Chrome").timeout(5000).get();
//            System.out.println(doc);
            links = Jsoup.connect(google + URLEncoder.encode(googleInputText, charset) + "&tbm=nws").userAgent(userAgent).get().select(".g>.r>.a");
            System.out.println(links.text());


        }
        catch (IOException e){
            e.printStackTrace();
        }

        for(Element link : links){
            String title = link.text();
            String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
            try{
                url = URLDecoder.decode(url.substring(url.indexOf("=") + 1, url.indexOf("&")), "UTF-8");
            }
            catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
            if(!url.startsWith("http"))
                continue;   //ads/news/etc

            this.url = url;
        }
        return url;
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
}
