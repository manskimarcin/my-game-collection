package pl.myGameCollection.searchEngine;

public class ExtractFromMetactitic {
    private GoogleSearch googleSearch;
    private String title;
    private String platform;


    public ExtractFromMetactitic(GoogleSearch googleSearch){
        this.googleSearch = googleSearch;
        this.title = googleSearch.getGameTitle();
        this.platform = googleSearch.getPlatform();
    }



}