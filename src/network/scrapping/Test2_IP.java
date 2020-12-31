package network.scrapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Test2_IP {//gets the address /this is java-core
	private final static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		trackFired();

		System.out.println("Enter in 'r' to continue tracking, or any other key to quit");
		if (scanner.nextLine().equalsIgnoreCase("r")) {
			trackFired();
		}else {
			scanner.close();
			System.exit(0);
		}

	}

	private static void trackFired(){
		System.out.println("Write the url you want to track ip of:");
		String urlPath = scanner.nextLine();
		try {
			System.out.println("Please wait...");
			Thread.sleep(1000);
			final InetAddress iNet = InetAddress.getByName(urlPath);
			System.out.println(urlPath+" = "+iNet.getHostAddress());
		} catch (InterruptedException | UnknownHostException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

}
