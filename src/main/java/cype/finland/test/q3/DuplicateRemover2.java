package cype.finland.test.q3;

import java.util.StringJoiner;

/**
 * Question 3: How are duplicates removed from an array without using any library?
 *
 * Answer / Algorithm:
 * Without using any library, we may get rid of duplicate elements
 * of an array in two common ways:
 * 1. Using temporal array - a temporal array will be used to keep the
 * distinct elements. This approach is similar to the one in Problem 2,
 * except that the array might need to be sorted in this case.
 * 2. Using a separate index.
 *
 * As for our algorithm in this class, it is a fortified approach
 * of both the above, and no sort is required.
 * And it does not use any library.
 * @see #removeDuplicates(Object[])
 */
public class DuplicateRemover2 {

    public static void main(String[] args) {
//        declare arrays here
        Object[] boys = new String[]{"Tom", "Muhammed", "Herry", "Peter", "Tom", "Dick", "Herry",
                "Paul", "Dick", "Muhammed", "Alpha", "Alpha"};
        Object[] ladies = new Object[]{"Fatou", "Aji", "Oumie", "Jatou", "Aji", "Jatou", "Matty",
                "Fatoumata", "Fatou", "Janinaba"};
        Object[] numbs = new Object[]{17, 15, 15, 17, 24, 26, 30, 33, 30, 17, 24, 24, 30, 26};
        Object[] chars = new Object[]{'A', 'B', 'C', 'A', 'A', 'C', 'E', 'G', 'C', 'X'};

//        print the original data
        System.out.println("Original data:");
        print(boys);
        print(numbs);
        print(ladies);
        print(chars);

//        remove duplicates
        boys = removeDuplicates(boys);
        numbs = removeDuplicates(numbs);
        ladies = removeDuplicates(ladies);
        chars = removeDuplicates(chars);

//        print new arrays
        System.out.println("Duplicates removed:");
        print(boys);
        print(numbs);
        print(ladies);
        print(chars);
    }

    /**
     * Returns an array that contains only the distinct
     * elements of the given array.
     * This does no use any library.
     * @see #contains(Object[], Object)
     */
    private static Object[] removeDuplicates(Object[] array){
        int length = array.length;
        Object[] tmpArray = new Object[length];
        int distinctCount = 0;
        for (int i = 0; i < length; i++) {
            Object e = array[i];
            if (!contains(tmpArray, e)) {
                tmpArray[distinctCount++] = e;
            }
        }

        Object[] objs = new Object[distinctCount];
        for (int i = 0; i < distinctCount; i++) {
            objs[i] = tmpArray[i];
        }
        return objs;
    }

    /**
     * Returns true if the given array contains the object o;
     * false otherwise.
     * It's worth stating that this returns true if o is null
     * and objects contains null as well.
     */
    private static boolean contains(Object[] objects, Object o){
        for (Object obj : objects) {
            if (obj == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a line of the given objects, comma-separated,
     * and enclosed in square braces.
     */
    private static void print(Object... objects){
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Object obj : objects) {
            sj.add(String.valueOf(obj));
        }
        System.out.println(sj);
    }

}
