package network.other;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class urlReader2 {
	
	public static void main(String[] args) {
		
		String url = null;
		try {
			url = readStringFromURL("https://www.utg.gm/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(url);
	}
				
	public static String readStringFromURL(String requestURL) throws IOException {
		try (Scanner scanner = new Scanner(new URL(requestURL).openStream(), StandardCharsets.UTF_8.toString())) {
			scanner.useDelimiter("\\A");
			return scanner.hasNext() ? scanner.next() : "";
			
			} 
		}

}
