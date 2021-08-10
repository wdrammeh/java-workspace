package network.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReader {

	public static void main(String[] args) throws Exception {
		// create the url
	    URL url = new URL("https://www.google.com");
	    
	    // open the url stream, wrap it an a few "readers"
	    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	    
	    // write the output to stdout
//	    String line;
	    while ((reader.readLine()) != null) {
	      System.out.println(reader.readLine());
	    }

	    // close our reader
	    reader.close();
	}

}
