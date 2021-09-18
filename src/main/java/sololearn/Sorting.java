package sololearn;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
	public static void main(String[] args) {
		
		ArrayList<String> animals = new ArrayList<String>();
		
		animals.add("Donkey");
		animals.add("Mouse");
		animals.add("Horse");
		animals.add("Goat");
		animals.add("Cow");
		
		System.out.println(animals);
		
		Collections.sort(animals);
		System.out.println("List now sorted: \n\t"+animals);
		
		Collections.reverse(animals);
		System.out.println("Wow! Reversed.\n\t"+animals);
		
	}

}
