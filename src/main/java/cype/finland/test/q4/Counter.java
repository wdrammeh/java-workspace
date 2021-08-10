package cype.finland.test.q4;

import java.util.Scanner;

/**
 * Question 4: How do you count a number of vowels and consonants in a given string?
 *
 * Answer / Algorithm:
 * We can loop through the individual characters of the string,
 * and apply the necessary checks, while keeping track of the number / count.
 * To make the algorithm faster, we check for the vowel condition only;
 * since every alphabet is either a vowel, or a consonant.
 * @see #isVowel(char)
 */
public class Counter {

    /**
     * Calculates and prints the number of distinct vowels and consonants
     * that made up the given text.
     * This means, every vowel and consonant is calculated only once
     * if though it may appear multiple times.
     * The calculation is done simultaneously to save time.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String vowels = "";
        String consonants = "";
        for (char ch : text.toCharArray()) {
            if(Character.isAlphabetic(ch)){
                if (isVowel(ch)) {
                    vowels += vowels.contains(String.valueOf(ch)) ? "" : ch;
                } else {
                    consonants += consonants.contains(String.valueOf(ch)) ? "" : ch;
                }
            }
        }
        System.out.println("Vowels found: "+vowels.length());
        System.out.println("Consonants found: "+consonants.length());
    }

    /**
     * Returns true if the given character is a vowel; false otherwise.
     * This makes the computation faster but must be checked
     * to ensure it's an alphabet least the consonants count
     * will be unnecessarily incremented.
     */
    private static boolean isVowel(char c){
        String ch = String.valueOf(c);
        return ch.equalsIgnoreCase("a") || ch.equalsIgnoreCase("e") ||
                ch.equalsIgnoreCase("i") || ch.equalsIgnoreCase("o") ||
                ch.equalsIgnoreCase("u");
    }

}
