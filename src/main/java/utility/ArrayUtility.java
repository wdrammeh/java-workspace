package utility;

public class ArrayUtility {


	/**
	 * Returns the maximum value of the given array.
	 * @see #findMax(int[], int, int)
	 */
	public static int findMax(int[] A){
		return findMax(A, 0, A.length - 1);
	}

	/**
	 * Returns the position of the maximum of the given array.
	 * @see #findMaxPos(int[])
	 */
	public static int findMaxPos(int[] A) {
		return findMaxPos(A, 0, A.length - 1);
	}

	/**
	 * Returns the maximum value occurring in the array A,
	 * inclusively, between positions i and j.
	 * Where i and j must be ordered.
	 */
	public static int findMax(int[] A, int i, int j) {
		if (i < 0 || i > j || j >= A.length) {
			throw new IllegalArgumentException();
		}
		int max = A[i];
		for (; i <= j; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		return max;
	}

	/**
	 * Returns the position (index) of the maximum value in the array A,
	 * inclusively, between positions i and j.
	 * i and j must be ordered.
	 */
	public static int findMaxPos(int[] A, int i, int j) {
		final int maxValue = findMax(A, i, j);
		for (; i <= j; i++) {
			if (A[i] == maxValue) {
				return i;
			}
		}
		throw new UnknownError("unknown error occurred");
	}

	public static int findMin(int[] A){
		return findMin(A, 0, A.length - 1);
	}

	public static int findMinPos(int[] A){
		return findMinPos(A, 0, A.length - 1);
	}

	public static int findMin(int[] A, int i, int j) {
		if (i < 0 || i > j || j >= A.length) {
			throw new IllegalArgumentException();
		}
		int min = A[i];
		for (; i <= j; i++) {
			if (A[i] < min) {
				min = A[i];
			}
		}
		return min;
	}

	public static int findMinPos(int[] A, int i, int j) {
		final int minValue = findMin(A, i, j);
		for (; i <= j; i++) {
			if (A[i] == minValue) {
				return i;
			}
		}
		throw new UnknownError("unknown error occurred");
	}

	/**
	 * Swaps the element in position i to j,
	 * and vice-versa, in the give array A.
	 */
	public static void swap(int[] A, int i, int j) {
		final int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void swap(String[] A, int i, int j) {
		final String temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	/**
	 * Returns an array containing all of a[] followed by all of b[], respectively.
	 */
	public static Object[] concatenate(Object[] a, Object[] b) {
		final Object[] objects = new Object[a.length + b.length];
		int index = 0;
		for (; index < a.length; index++) {
			objects[index] = a[index];
		}
		for (Object o : b) {
			objects[index++] = o;
		}
		return objects;
	}

	/**
	 * Returns the Algebraic Inner-product of the two arrays x and y,
	 * considered as vectors.
	 */
	public static double innerProduct(double[] x, double[] y) {
		if (x.length != y.length) {
			throw new UnsupportedOperationException("cannot find inner product of different-sized vectors");
		}
		int innerProduct = 0;
		for (int i = 0; i < x.length; i++) {
			innerProduct += (x[i] * y[i]);
		}
		return innerProduct;
	}

	/**
	 * Returns the algebraic outer product of the two given arrays as (algebraic) vectors such that:
	 * p[i][j] = a[i]*b[j]
	 */
	public static  double[][] outerProduct(double[] x, double[] y){
		double[][] outerProduct = new double[x.length][y.length];
		for (int i = 0; i < outerProduct.length; i++) {
			for (int j = 0; j < outerProduct[i].length; j++) {
				outerProduct[i][j] = x[i]*y[j];
			}
		}
		return outerProduct;
	}

}
