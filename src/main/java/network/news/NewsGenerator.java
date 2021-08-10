package network.news;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class NewsGenerator {


    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.utg.edu.gm/category/news/").get();

            List<Element> elements = doc.getElementsByTag("article");

            for(Element e : elements){
                System.out.println(e.select("h2.entry-title").text());
                System.out.println(e.getElementsByTag("p").text());
            }

            System.out.println(elements.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
