import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

public class SearchEngine {

    public static String hltb_link;
    public static String metacritic_link;
    static int for_counter=1;

    public SearchEngine(){
        Scanner sc = new Scanner (System.in);

        System.out.println("What game are you looking for? ");
        String search = sc.nextLine();

        System.out.println("This are the results of the searching for "+search);

        String hltb_search = search+" hltb site://howlongtobeat.com";
        String metacritic_search=  search+" metascirtic site://metacritic.com";

        search(hltb_search);
        search(metacritic_search);
    }

    static void search(String search){
        String userAgent = "maniek94"; // Change this to your company's name and bot homepage!
        String google = "http://www.google.com/search?q=";
        String charset = "UTF-8";

        Elements links = null;

        try {
            links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (Element link : links) {
            String title = link.text();
            String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
            try {
                url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (!url.startsWith("http")) {
                continue; // Ads/news/etc.
            }

            switch(for_counter){
                case 1: {
                  hltb_link = url;
                  for_counter++;
                }   break;

                case 2:{
                    metacritic_link = url;
                } break;
                default:{
                    System.out.println("Something went wrong!");
                } break;
            }
            break; // gives only first result

        }
    }
}
