package pl.myGameCollection.searchEngine;

public class SearchHLTB_URL implements Search {

    private String gameTitle;
    private String platform;

    public SearchHLTB_URL(String[] userInput){
        this.gameTitle = userInput[0];
        this.platform = userInput[1];
    }

    public String getWebsiteURL() {
        return "";
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
