import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.myGameCollection.userInterface.UI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class App {
    public static void main(String[] args) throws IOException {

//            UI ui = new UI();
//            System.out.println("Game title: " + ui.getTitle());
//            System.out.println("Platform: " + ui.getPlatform());

        String google = "http://www.google.com/search?q=";

        String search = "stackoverflow";

        String charset = "UTF-8";

        String news="&tbm=nws";

        String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

//        Elements links = Jsoup.connect(google + URLEncoder.encode(search , charset) + news).userAgent(userAgent).get().select( ".g>.r>.a");
        Document links = Jsoup.connect(google + URLEncoder.encode(search , charset) + news).get();


        System.out.println(links);

//        for (Element link : links) {
//            String title = link.text();
//            String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
//            url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
//
//            if (!url.startsWith("http")) {
//                continue; // Ads/news/etc.
//            }
//            System.out.println("Title: " + title);
//            System.out.println("URL: " + url);
//        }
        }
}
