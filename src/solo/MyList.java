package solo;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	public static void main(String[] args) {
		
		//Non-generic list, open for all elements
		List<Object> ls = new ArrayList<>();
		
		ls.add(true);
		ls.add(null);
		ls.add(5);
		ls.add("String");
		
		for (Object object : ls) {
			System.out.println(object);
		}
		
		System.out.println("------------------------");
		//Generic list, specific to a data type!
		List<String> strg = new ArrayList<>();
		
		strg.add("Zero");
		strg.add("One");
		strg.add("Two");
		strg.add("Three");
		strg.add("Four");
		strg.add("Five");
//		strg.add(7);  This is not possible!
		
		strg.add(0, "Start");
		strg.remove(4);//by index
		strg.remove("Three");//by value
		System.out.println(strg.size());
		for (String string : strg) {
			System.out.println(string);
		}
	}

}
