package cype.finland.test;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Question 2: How do you remove duplicates from an array in place
 *
 * Answer / Algorithm:
 * Since arrays are fix-sized, it won't be possible to squeeze
 * their sizes by removing duplicate elements by themselves.
 * However, we can create an array with the non-duplicate (distinct)
 * elements of an existing array.
 * In this implementation, we translate the existing array into
 * a set, which automatically filters out the duplicate elements.
 * Finally, we reconstruct the set into an array containing
 * only the distinct elements.
 *
 * This is based on the Java Collections Framework.
 * In Problem 3, i.e {@link DuplicateRemover2},
 * I've implemented this without the use of library assistance -
 * as specified by the question.
 *
 * Note that we stick to using the Object type so that our arrays
 * may accept all data types.
 */
public class DuplicateRemover {

    public static void main(String[] args) {
//        declare arrays here
        Object[] alps = new Object[]{"a", "b", "c", "a", "b", "c"};
        Object[] numbs = new Object[]{17, 15, 15, 17, 24, 26, 30, 33, 30, 17, 24, 24, 30, 26};

//        print the original data
        System.out.println("Original data:");
        print(alps);
        print(numbs);

//        remove duplicates
        alps = removeDuplicates(alps);
        numbs = removeDuplicates(numbs);

//        print new arrays
        System.out.println("Duplicates removed:");
        print(alps);
        print(numbs);
    }

    /**
     * Returns an array that contains only the distinct elements
     * of the given objects array.
     * This uses the collections framework.
     * As specified by Question 3, I've implemented this with
     * no library at {@link DuplicateRemover2}.
     */
    private static Object[] removeDuplicates(Object[] objects){
        Set<Object> set = new HashSet<>();
        for (Object obj : objects) {
            set.add(obj);
        }
        Object[] a = set.toArray();
        return a;
    }

    /**
     * Prints a line of the given objects, comma-separated,
     * and enclosed in square braces.
     */
    private static void print(Object... a){
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Object o : a) {
            sj.add(o.toString());
        }
        System.out.println(sj);
    }

}
