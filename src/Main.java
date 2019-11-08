import java.io.IOException;


public class Main {


    public static void main(String[] args) throws IOException {

    SearchEngine se = new SearchEngine();
    String hltb_url = se.hltb_link;
    String metacritic_url = se.metacritic_link;

   // ExtractFromMetacritic metacritic_result = new ExtractFromMetacritic(metacritic_url);

    System.out.println("-------------------------------------------------------------------");

    ExtractFromHLTB hltb_result = new ExtractFromHLTB(hltb_url);

    }
}
