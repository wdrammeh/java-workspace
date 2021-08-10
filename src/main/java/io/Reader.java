package io;

import java.io.File;
import java.util.Scanner;

public class Reader  {
	public static void main(String[] args) {
		try {
			File x = new File("/home/wdrammeh/Tmp/input.txt");
			Scanner sc = new Scanner(x);
			System.out.println(sc.delimiter());
			System.out.println(sc.findAll("java").toString());

			sc.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
