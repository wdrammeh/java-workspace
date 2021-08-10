package algo.sort;

import utility.ArrayUtility;

import java.util.Arrays;

/**
 * Implements the Selection Sort Algorithm.
 * In every iteration, we select and put the minimum (maximum) value
 * to the extreme left (right).
 * Time complexity: O(n-square)
 */
public class SelectionSort {

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
     * Selection sorts the given array in ascending order.
     */
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minPos] > array[j]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                ArrayUtility.swap(array, i, minPos);
            }
        }
    }

    /**
     * Selection sorts the given array in ascending order.
     */
    public static void sort(String[] array){
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minPos].compareTo(array[j]) > 0) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                ArrayUtility.swap(array, i, minPos);
            }
        }
    }

}
