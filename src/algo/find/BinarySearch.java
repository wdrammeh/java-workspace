package algo.find;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Implements the Binary Search Algorithm
 */
public class BinarySearch {

    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[30];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(101);
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(search(a, 36));

        String[] b = new String[]{"Maha", "Essou", "Salim", "Hagie", "Lamin", "Ali", "Sorry", "Alieu"};
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        System.out.println(search(b, "Maha"));
    }


    /**
     * Returns the arbitrary index of key in the given array,
     * or -1 if either the data is empty or does not contain key.
     * The array is sorted by the time this call returns.
     */
    public static int search(int[] data, int key){
        if (data.length == 0) {
            return -1;
        }
        Arrays.sort(data);
        int lowerBound = 0;
        int upperBound = data.length - 1;
        int index = upperBound / 2;
        int count = 0;  // useful for non-uniform data
        while (lowerBound != upperBound && count < data.length) {
            int midVal = data[index];
            if (midVal == key) {
                return index;
            } else if (midVal > key) {
                upperBound = index;
                index -= Math.ceil((upperBound - lowerBound) / 2D);
            } else {
                lowerBound = index;
                index += Math.ceil((upperBound - lowerBound) / 2D);
            }
            count++;
        }
        return -1;
    }

    /**
     * Returns the arbitrary index of key in the given array,
     * or -1 if either the data is empty or does not contain key.
     * The array is sorted by the time this call returns.
     */
    public static int search(String[] data, String key){
        if (data.length == 0) {
            return -1;
        }
        Arrays.sort(data);
        int lowerBound = 0;
        int upperBound = data.length - 1;
        int index = upperBound / 2;
        int count = 0;  // useful for non-uniform data
        while (lowerBound != upperBound && count < data.length) {
            String midVal = data[index];
            if (Objects.equals(midVal, key)) {
                return index;
            } else if (midVal.compareTo(key) > 0) {
                upperBound = index;
                index -= Math.ceil((upperBound - lowerBound) / 2D);
            } else {
                lowerBound = index;
                index += Math.ceil((upperBound - lowerBound) / 2D);
            }
            count++;
        }
        return -1;
    }

}
