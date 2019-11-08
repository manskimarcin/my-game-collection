import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractFromHLTB {

    static List<String[]> dlc_info = new ArrayList<>();
    static String main_story = null;
    static String main_plus_extras = null;
    static String completionists = null;
    static String all_styles = null;

    public ExtractFromHLTB(String url) throws IOException {
        try {
            System.out.println();
            Document doc = Jsoup.connect(url).get();


            //Elements times = doc.select("div[class=game_times]");
            Elements times = doc.select("li[class=short time_100]");


            //System.out.println("test "+doc.select("li[class=short time_100]").text());
            //System.out.println();


            String time = times.text();


            time = time.replaceAll("\\u00bd",".5"); // replacing ½ by 0.5
            time = time.replace("Main Story","");
            time = time.replace("Main + Extras","");
            time = time.replace("Completionist","");
            time = time.replace("All Styles","");



            String[] time_table = time.split("  ");

            main_story=time_table[0].trim();
            main_plus_extras = time_table[1];
            completionists = time_table[2];
            all_styles = time_table[3];

            System.out.println("Main story:"+main_story);
            System.out.println("Main + Extras:"+main_plus_extras);
            System.out.println("Completionist:"+completionists);
            System.out.println("All Styles:"+all_styles);

            // Checking for additional content
            Elements dlc = doc.select("td[style=min-width:175px;]");

            if(dlc.text().equals("Additional Content")){
                System.out.println("There are additional content in this game");


                Elements links = doc.select("tbody[class=spreadsheet]");
                String text = links.toString();
                String[] text_table =text.split("</tbody>");


                boolean find = false;
                int dlc_counter = 0;


                for(int x = 0; x <text_table.length; x++){

                    find = text_table[x].contains("Main Story") ;

                    if(find == true){
                        break;
                    }

                    Scanner scanner = new Scanner(text_table[x]);

                    int line_counter = 0;


                    String[] one_row = new String[5];

                    while(scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        if(line.equals(""))
                            line = scanner.nextLine();
                        switch(line_counter){
                            case 2:
                                line = line.replace("<td>","");
                                line = line.replace("</td>","");
                                line = line.replace("</a>","");
                                line = line.replace("<a href=\"game.php?id="," ");
                                line = line.replace("\">","");
                                line = line.replace("  ","");
                                String[] lines = line.split(" ",2);
                                line = lines[1];
                                one_row[0]= line;
                                break;
                            case 5:
                                line = line.replace("<td>","");
                                line = line.replace("</td>","");
                                line = line.trim();
                                one_row[1]= line;
                                break;
                            case 6:
                                line = line.replace("<td>","");
                                line = line.replace("</td>","");
                                line = line.replace(" ","");
                                one_row[2]= line;
                                break;
                            case 7:
                                line = line.replace("<td>","");
                                line = line.replace("</td>","");
                                line = line.trim();
                                one_row[3]= line;
                                break;
                            case 8:
                                line = line.replace("<td>","");
                                line = line.replace("</td>","");
                                line = line.trim();
                                one_row[4]= line;
                                break;
                            default:
                                break;
                        }
                        line_counter++;
                    }
                    dlc_counter=dlc_counter+1;

                    dlc_info.add(dlc_counter-1, one_row);
                }

            }

            else
                System.out.println("There are no DLCs");


            //Displaying the results

            for(int i = 0; i < dlc_info.size(); i++){
                System.out.println("DLC no: "+ (i+1));

                String[] results = dlc_info.get(i);

                for(int j = 0; j < results.length; j++){
                    System.out.println(results[j]);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
