package io;

import java.util.Scanner;

public class FileFinderTester {

    public static void main(String[] args) {
        if (args.length <= 0) {//meaning, the program was not command-line triggered, so request inputs from the uer
            Scanner input = new Scanner(System.in);
            System.out.print("Enter word: ");
            String word = input.nextLine().trim();
            System.out.print("Enter files: ");
            String[] temp = input.nextLine().replace(", ", "").split(" ");
            args = new String[temp.length + 1];
            args[0] = word;
            for (int i = 1, j = 0; i < args.length; i++, j++) {
                args[i] = temp[j];
            }
        }
        new FileFinder().findFiles(args);
    }

}
