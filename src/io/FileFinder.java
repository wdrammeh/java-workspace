package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Question 4
 * 
 * Write a program Find that searches all files specified on the command line and prints
 * out all lines containing a specified word. For example, if you call
 * java Find ring report.txt address.txt Homework
 * PROVIDE A TESTER CLASS FOR PROGRAM
 */

public class FileFinder {

    public void findFiles(String[] fileNames) {
        for (int i = 1; i < fileNames.length; i++) {
            File file = new File(fileNames[i]);
            if (file.exists()) {
                try {
                    find(fileNames[0], file);
                } catch (FileNotFoundException e) {
                    System.err.printf("Error reading file: \"%s\" \n", file.getAbsolutePath());
                }
            } else {
                System.err.printf("File does not exist: \"%s\" \n", file.getAbsolutePath());
            }
        }
    }

    private void find(String text, File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.contains(text)) {
                System.out.println(String.join(": ", file.getName(), line));
            }
        }
        scan.close();
    }

}
