package network.scrapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Test2_IP {
	private final static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		trackFired();
		System.out.println("Enter 'r' to continue tracking, or any other key to quit.");
		if (scanner.nextLine().equalsIgnoreCase("r")) {
			trackFired();
		} else {
			scanner.close();
			System.exit(0);
		}
	}

	private static void trackFired(){
		System.out.println("Enter url:");
		String urlPath = scanner.nextLine();
		try {
			System.out.println("Please wait...");
			final InetAddress iNet = InetAddress.getByName(urlPath);
			System.out.println(urlPath+" := "+iNet.getHostAddress());
		} catch (InterruptedException | UnknownHostException e) {
			System.err.println(e);
		}
	}

}
