package math.arithmetic;

import io.MyClass;

public class Operator {
	private int count = 0;
	
	public static void main(String[] args) {
		int[] argum = {2,4,6,8,10,11,15,20,45};
		
		new Operator().performBinarySearch(argum, 6);
		
		for (int i : MyClass.considerLowerHalf(argum)) {
			System.out.print(i+", ");
		}
		System.out.println();
		for (int i : MyClass.considerUpperHalf(argum)) {
			System.out.print(i+", ");
		}
		
	}

	protected int performBinarySearch(int[] a, int target) {
		int mid = a.length/2;
			
		for (int i = 0; i < a.length; i++) {
			if (target == a[mid]) {
				System.out.println(target+" is found @ index "+(count+mid));
					return mid;
					}
				}
				
			if (target > a[mid]) {
				
				if (MyClass.considerLowerHalf(a).length %2 == 0) {
					count += MyClass.considerLowerHalf(a).length;
				} else {
					count += MyClass.considerLowerHalf(a).length;
					count--;
				}
				return performBinarySearch(MyClass.considerUpperHalf(a), target);
			}
			if (target < a[mid]) {
				count += MyClass.considerUpperHalf(a).length;
				return performBinarySearch(MyClass.considerLowerHalf(a), target);
			}
			
		return -1;
	}
	

}
