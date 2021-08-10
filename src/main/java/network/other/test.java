package network.other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {

    public static void main(String[] args) throws Exception {
        String url = "https://utg.gm/login";
        Document document = Jsoup.connect(url).get();

        String question = document.select("#question .post-text").text();
        System.out.println("Question: " + question);

        Elements answers = document.select("#answers .user-details a");
        for (Element answerer : answers) {
            System.out.println("Answerer: " + answerer.text());
        }
    }

}
