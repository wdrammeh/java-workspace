package network.other;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Question 1
 *
 * Write a program that reads all data from a web page and writes them to a file.
 * Prompt the user for the web page URL and the file.
 * Provide a tester program the implementation of the program.
 * 
 */
public class WebPageReader {

	/**
	 * Reads the data (the outer-html) of this url and stores it into the given file name.
	 *
	 * @param url the page to be read
	 * @param path the output file to which the url's data will be written
	 * @throws IOException if an IO error attempt fails;
	 * like if it's unable to settle connection with the specified url;
	 * or unable to write to the file with the specified path name.
	 */
    public void readPage(String url, String path) throws Exception {
		URL site = new URL(url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
		StringBuilder builder = new StringBuilder();
		String inputLine;
		while ((inputLine = reader.readLine()) != null) {
			builder.append(inputLine);
		}
		reader.close();
		FileWriter writer = new FileWriter(path);
		writer.write(builder.toString());
		writer.close();
    }
    
}
