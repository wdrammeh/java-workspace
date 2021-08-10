package utility;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		final int[] A = {49, 2, 9, 5, 6, 7, 8, 37, 20, 110, 23, 30, 41, 34, 12, 160};
		System.out.println(Arrays.toString(A));
		System.out.println(ArrayUtility.findMax(A));
		System.out.println(ArrayUtility.findMaxPos(A));
		System.out.println(ArrayUtility.findMin(A));
		System.out.println(ArrayUtility.findMinPos(A));
		ArrayUtility.swap(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));

		final String[] B = {"Muhammed", "Waka", "Drammeh"};
		final Object[] C = {10, 11, 12, 13, 15};
		System.out.println(Arrays.toString(ArrayUtility.concatenate(B, C)));

		final double[] D = {3, 5, 9, 12};
		final double[] E = {0, 3, 6, 7};
		System.out.println(ArrayUtility.innerProduct(D, E));

		double[][] outerProduct = ArrayUtility.outerProduct(D, E);
		for (double[] vector : outerProduct) {
			for (double value : vector) {
				System.out.print(value+"  ");
			}
			System.out.println();
		}
	}

}
