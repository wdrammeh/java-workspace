package algo.sort;

import utility.ArrayUtility;

import java.util.Arrays;

/**
 * Implements the Insertion Sort Algorithm.
 * An improved version of Bubble Sort.
 * In every iteration, instead of swapping,
 * we push the element as far as possible;
 * i.e until it is eventually inserted such that
 * no smaller element is to its right (ascending),
 * or to its left (descending).
 * Time complexity: 2n to n-square
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[]{2,8,5,3,9,4,1};
        System.out.println("Original: "+ Arrays.toString(a));
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
     * Insertion sorts the given array in ascending order.
     */
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j-1] > array[j]) {
                ArrayUtility.swap(array, j, j-1);
                j--;
            }
        }
    }

    /**
     * Insertion sorts the given array in ascending order.
     */
    public static void sort(String[] array){
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j-1].compareTo(array[j]) > 0) {
                ArrayUtility.swap(array, j, j-1);
                j--;
            }
        }
    }

}
