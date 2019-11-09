package pl.myGameCollection.searchEngine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ExtractFromMetactitic {

    private GoogleSearch googleSearch;
    private Document metacriticSourceCode;
    private String metacriticUrl;

    private String gameTitle;
    private String platform;
    private String releaseDate;
    private String otherPlatforms;
    private String metascore;
    private String userScore;
    private String publisher;


    public ExtractFromMetactitic(GoogleSearch googleSearch) throws IOException {
        metacriticUrl = googleSearch.getWebsiteURL();
        metacriticSourceCode = Jsoup.connect(metacriticUrl).get();
        this.googleSearch = googleSearch;
        this.platform = googleSearch.getPlatform();
    }

    public String getMetacriticUrl() {
        return metacriticUrl;
    }

    public String getGameTitle() {
        this.gameTitle = metacriticSourceCode.select("h1").text();
        return gameTitle;
    }

    public String getPlatform() {

        return platform;
    }

    public String getReleaseDate() {
        releaseDate = metacriticSourceCode.select("li[class=summary_detail release_data]").text() ;
        releaseDate = releaseDate.replace("Release Date: ","");
        return releaseDate;
    }

    public String getPublisher() {
        publisher = metacriticSourceCode.select("li[class=summary_detail publisher]").text();
        publisher  = publisher.replace("Publisher: ","");
        return publisher;
    }


    public String getOtherPlatforms() {
        otherPlatforms = metacriticSourceCode.select("li[class=summary_detail product_platforms]").text();

        if(otherPlatforms.isEmpty())
            otherPlatforms = "exclusive on "+platform;
        else
            otherPlatforms = otherPlatforms.replace("Also On: ","");

        return otherPlatforms;
    }

    public String getMetascore() {
        this.metascore = metacriticSourceCode.select("span[itemprop='ratingValue']").text();
        return metascore;
    }

    public String getUserScore() {
        this.userScore = metacriticSourceCode.select("[class='metascore_w user large game positive']").text(); //.substring(0,3);
        if(this.userScore.isEmpty())
            this.userScore = metacriticSourceCode.select("[class='metascore_w user large game negative']").text(); //.substring(0,3);

        if(this.userScore.length() >= 3)
            this.userScore  = this.userScore.substring(0,3);

        return userScore;
    }
}