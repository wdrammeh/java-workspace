package sololearn;


public class MyFirstChallenge {
	
	public static void main(String[] args) {
		System.out.println(f(4));
		System.out.println(rec(15, 9));
		output();
		
	}

	private static int f(int i) {
		if (i == 0) {
			System.out.println(i+" == 0, so condition returning... value: 2");
			return 2;
		} else {
			System.out.println(i+" was != 0, so returned 1 + f("+i+")");
			return  1+f(i-1);
		}
	}
	
	private static int rec(int m, int n) {
		if (m%n == 0) {
			return n;
		}else {
			return rec(n, m%n);
		}
	}
	
	private static void output() {//no param!
		for (int i = 1; i < 6; i += 2) {
			for(int j = 0; j < 3; j++) {
				if(i + j > 4) {
					break;
				}
				System.out.println(i * j);//01203
			}
		}
	}

}
