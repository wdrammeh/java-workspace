package network.scrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Test1_Source {
	
	public static void main(String[] args) {
		try {
			final Document page = Jsoup.connect("https://utg.gm/login").get();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
