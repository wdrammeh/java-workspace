package solo;
import java.util.LinkedList;

public class Iterating {
	public static void main(String[] args) {
		
		LinkedList<Integer> nomb = new LinkedList<>();
		
		nomb.add(23);
		nomb.add(66);
		nomb.add(67);
		nomb.add(89);
		nomb.add(90);
		nomb.add(100);
		
		System.out.println(nomb);
		
		/*
		 * 
		 * 		Iterator<Integer> it = nomb.iterator();

				while (it.hasNext()) {
					System.out.println(it.next());
		}
		
		*/
	}

}
