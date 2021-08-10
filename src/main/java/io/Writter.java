package io;

import java.util.Formatter;

public class Writter {

	public static void main(String[] args) {
		
		try {
			Formatter f = new Formatter("/home/wdrammeh/Tmp/input.txt");
			String msg = "This is java.\nDo you enjoy learning java?";
			f.format(msg);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
