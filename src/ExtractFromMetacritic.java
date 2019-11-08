import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ExtractFromMetacritic {

    static String game_title;
    static String platform;
    static String publisher;
    static String release_date;
    static String other_platforms;
    static String game_metascore;
    static String game_user_score;

 public ExtractFromMetacritic(String url){

        try{
            Document doc = Jsoup.connect(url).get();

            //get title of the page
            String title = doc.title();
            System.out.println("Title: "+title);
            System.out.println();
            System.out.println();

            //get all important data

//            String game_title = null;
//            String platform = null;
//            String publisher = null;
//            String release_date = null;
//            String other_platforms = null;
//            String game_metascore = null;
//            String game_user_score = null;

            //Title
            game_title = doc.select("h1").text();

            //Release date
            release_date = doc.select("li[class=summary_detail release_data]").text() ;
            release_date = release_date.replace("Release Date: ","");

            // Platform
            platform = doc.select("span[class=platform]").text() ;

            //Publisher
            publisher = doc.select("li[class=summary_detail publisher]").text();
            publisher  = publisher.replace("Publisher: ","");

            //Other platforms
            other_platforms = doc.select("li[class=summary_detail product_platforms]").text();

            if(other_platforms.isEmpty())
                other_platforms = "exclusive on "+platform;
            else
                other_platforms = other_platforms.replace("Also On: ","");

            Elements links = doc.select("a[href]");


            for (Element link : links){

                //Metascore
                if (link.getElementsByTag("span").attr("itemprop").equals("ratingValue"))
                    game_metascore = link.text();

                //User score
                if (link.getElementsByTag("div").attr("class").equals("metascore_w user large game positive"))
                    game_user_score = link.text();

            }

            System.out.println("Game title: "+game_title);
            System.out.println("Release date: "+release_date);
            System.out.println("Platform: "+platform);
            System.out.println("Publisher: "+publisher);
            System.out.println("Other plafrorms: "+other_platforms);
            System.out.println("Metascore: "+game_metascore);
            System.out.println("User score: "+game_user_score);

        }   catch(IOException e){
            e.printStackTrace();
        }
    }

}
