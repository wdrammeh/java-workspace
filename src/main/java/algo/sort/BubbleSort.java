package algo.sort;

import utils.ArrayUtility;

import java.util.Arrays;

/**
 * Implements the Bubble Sort Algorithm.
 * In each iteration, the 2-consecutive values are compared
 * and swapped, if necessary.
 * Time complexity: O(n-square)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{2,8,5,3,9,4,1};
        System.out.println("Original: "+Arrays.toString(a));
        sort(a);
        System.out.println("Sorted: "+Arrays.toString(a));

        int[] b = new int[]{3,-2,11,8,5,3,9,4,3,0,2,9,9,-1};
        System.out.println("Original: "+Arrays.toString(b));
        sort(b);
        System.out.println("Sorted: "+Arrays.toString(b));

        String[] c = new String[]{"Yusuf","Ibrahim","Hahmad","Waka","Amie","Fatou","Haja","Alhagie"};
        System.out.println("Original: "+Arrays.toString(c));
        sort(c);
        System.out.println("Sorted: "+Arrays.toString(c));
    }

    /**
     * Bubble sorts the given array in ascending order.
     */
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    ArrayUtility.swap(array, j, j+1);
                }
            }
        }
    }

    /**
     * Bubble sorts the given array in ascending order.
     */
    public static void sort(String[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    ArrayUtility.swap(array, j, j+1);
                }
            }
        }
    }

}
