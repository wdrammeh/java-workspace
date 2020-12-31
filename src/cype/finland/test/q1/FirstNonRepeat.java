package cype.finland.test.q1;

import java.util.Scanner;

/**
 * Question 1: How do you print the first non-repeated character from a string?
 *
 * Answer / Algorithm:
 * First, we break the down string to its character sequences, and loop through
 * the sequence in a linear fashion.
 * For every iteration, the corresponding character is removed.
 * And, if the string does no longer contains a similar character,
 * we referred to it as the first non-repeated, because the method will return,
 * causing not only the current iteration to continue,
 * but seizing the loop from carrying out further iterations.
 */
public class FirstNonRepeat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        try {
            char firstNonRepeatedChar = getFirstNonRepeatedChar(text);
            System.out.printf("The first non-repeated character is: \"%c\"%n", firstNonRepeatedChar);
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Returns the first non-repeated (and non-whitespace) character in
     * the given text's character sequence.
     * If all the characters are repeated, then an UnsupportedOperationException
     * is thrown with the appropriate message.
     * First, the text is stripped of all its whitespaces.
     * This avoids returning the blank string in case the text contains it,
     * and it's repeated.
     * @see #contains(String, char, boolean)
     */
    private static char getFirstNonRepeatedChar(String text){
        String charText = text.trim();
        charText = charText.replace(" ", "");
        for (char ch : charText.toCharArray()) {
            String temp = charText.replaceFirst(String.valueOf(ch), "");
            if (!(contains(temp, ch, false))) {
                return ch;
            }
        }

        String unsupported = String.format("There's no non-repeated character in the string: \"%s\"", text);
        throw new UnsupportedOperationException(unsupported);
    }

    /**
     * Returns true if the given text contains the given char, c.
     * This method might be lenient or not, depending on the given caseCheck.
     * If caseCheck is true, then returns true if and only if the text
     * contains a character with exactly the same case.
     */
    private static boolean contains(String text, char c, boolean caseCheck){
        if (caseCheck) {
            return text.contains(String.valueOf(c));
        } else {
            return text.contains(String.valueOf(c).toLowerCase()) ||
                    text.contains(String.valueOf(c).toUpperCase());
        }
    }

}
