package network.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Readhtml2 {

	public static void main(String[] args) {
		try {
			URL google = new URL("https://utg.gm/login");
			BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()));
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}
			reader.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
