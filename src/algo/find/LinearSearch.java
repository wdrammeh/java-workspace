package algo.find;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Implements the Linear Search Algorithm
 */
public class LinearSearch {

	public static void main(String[] args) {
		final Random r = new Random();

		Object[] objets = new Object[]{"Maha", "Essou", 21, "Amie", 33, "Jalia"};
		System.out.println(Arrays.toString(objets));
		System.out.println(searchFirst(objets, "Essou"));
		System.out.println(searchLast(objets, 33));

		int[] values = new int[25];
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextInt(31);
		}
		final int x = r.nextInt(31);
		System.out.println(Arrays.toString(values));
		System.out.println(x+": index = "+search(values, x));
	}


	public static int search(int[] data, int key){
		return searchFirst(data, key);
	}

	public static int searchFirst(int[] data, int key){
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int searchLast(int[] data, int key){
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int search(String[] data, String key){
		return searchFirst(data, key);
	}

	public static int searchFirst(String[] data, String key){
		for (int i = 0; i < data.length; i++) {
			if (Objects.equals(data[i], key)) {
				return i;
			}
		}
		return -1;
	}

	public static int searchLast(String[] data, String key){
		for (int i = data.length - 1; i >= 0; i--) {
			if (Objects.equals(data[i], key)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the first index of key in the given array,
	 * or -1 if key does not exist in the data.
	 * If such a key in unique (distinct) in the array, then this
	 * is effectively equivalent to {@link #searchLast(Object[], Object)}.
	 * This is ideal if the key is supposedly in the first-half of the array.
	 * @see #searchLast(Object[], Object).
	 */
	public static int search(Object[] data, Object key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @see #search(Object[], Object)
	 */
	public static int searchFirst(Object[] data, Object key) {
		return search(data, key);
	}

	/**
	 * Returns the last index of key in the given array,
	 * or -1 if key does not exist in the data.
	 * If such a key in unique (distinct) in the array, then this
	 * is effectively equivalent to {@link #searchFirst(Object[], Object)}.
	 * This is ideal if the key is supposedly in the last-half of the array.
	 * @see #searchFirst(Object[], Object).
	 */
	public static int searchLast(Object[] data, Object key) {
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}

}
