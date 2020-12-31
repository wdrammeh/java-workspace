package network.scrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Test3_ElementFinder {//only scraps
	
	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect("http://www.utg.gm/login/").get();
//			Elements temp = doc.select("div.panel-body");

            System.out.println(doc.title());
            System.out.println(doc.getElementsByTag("h1").text());
            System.out.println(doc.select("div.panel-body").text());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
