package pl.myGameCollection.userInterface;

import pl.myGameCollection.searchEngine.Search;
import pl.myGameCollection.searchEngine.SearchHLTB_URL;
import pl.myGameCollection.searchEngine.SearchMetactitic_URL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UI {
    private Search userInputSearch;
    private String title;
    private String platform;



    public UI(){
        displayInfo();
        getInput();

        String[] userInput = new String[]{title, platform} ;

      //  Search searchHLTB_url = new SearchHLTB_URL(userInput);
        Search searchMetactitic_url = new SearchMetactitic_URL(userInput);
        System.out.println(searchMetactitic_url.getWebsiteURL());

        /*
        instantiate SearchHTLB_URL
        instantiate SearchMetactritic_URL

        instantiate ExtractFromMetacritic
        instatiate ExtractFromHLTB

        instantiate HLTB_Info
        instantiate MetacriticInfo

        instantiate HLTB_Info and MetacriticInfo method for presenting data
         */

    }

    void getInput(){
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

    public Search getUserInputSearch() {
        return userInputSearch;
    }

    public void setUserInputSearch(Search userInputSearch) {
        this.userInputSearch = userInputSearch;
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

}
