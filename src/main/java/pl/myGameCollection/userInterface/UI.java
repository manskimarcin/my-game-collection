package pl.myGameCollection.userInterface;

import pl.myGameCollection.searchEngine.ExtractFromMetactitic;
import pl.myGameCollection.searchEngine.GoogleSearch;
import pl.myGameCollection.searchEngine.Website;

import java.io.IOException;
import java.util.Scanner;

public class UI {
    private String title;
    private String platform;
    private String hltb_URL;
    private String metacritic_URL;


    public UI() throws IOException {
        displayInfo();
        getInput();


        GoogleSearch metacriticGoogleSearch = new GoogleSearch(title, platform, Website.METACRITIC);
        metacritic_URL = metacriticGoogleSearch.getWebsiteURL();
        ExtractFromMetactitic extractFromMetactitic = new ExtractFromMetactitic(metacriticGoogleSearch);


        GoogleSearch hltbGoogleSearch = new GoogleSearch(title, platform, Website.HLTB);
        hltb_URL = hltbGoogleSearch.getWebsiteURL();

        /*
        instantiate HLTB_Info
        instantiate MetacriticInfo

        instantiate HLTB_Info and MetacriticInfo method for presenting data
         */

    }

    public void getInput(){
        Scanner titleScanner = new Scanner(System.in);
        Scanner platformScanner = new Scanner(System.in);

        System.out.println("Enter game title: ");
        this.title = titleScanner.nextLine();

        System.out.println("Enter game platform: ");
        this.platform = platformScanner.nextLine();
    }

    void displayInfo(){
        System.out.println("My game collection v2.0 app Marcin Manski 2019");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getHltb_URL() {
        return hltb_URL;
    }

    public String getMetacritic_URL() {
        return metacritic_URL;
    }
}
