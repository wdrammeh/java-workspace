package io;

import javax.swing.*;
import java.io.*;

public class FileCopy {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("/home/muhammed/instantFiles/os.txt");
			OutputStream out = new FileOutputStream("/home/muhammed/Programs/newos.txt");
			
			byte[] buf = new byte[1024];  // 1kB equivalence
			int len;
			
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();
			JOptionPane.showMessageDialog(null, "File Copied, Successfully.", "File transfer result", JOptionPane.PLAIN_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Operation failed!\n"+e.getMessage(), "File transfer result", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Unknown error", "File trasnfer result", JOptionPane.ERROR_MESSAGE);
		}
	}

}
