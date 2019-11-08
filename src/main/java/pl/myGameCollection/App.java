package pl.myGameCollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.myGameCollection.userInterface.UI;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

            UI ui = new UI();

            System.out.println(ui.getMetacritic_URL());
            System.out.println(ui.getHltb_URL());

    }
}
