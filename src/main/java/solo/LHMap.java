package solo;

import java.util.LinkedHashMap;

public class LHMap {
	public static void main(String[] args) {
		
		LinkedHashMap<String, Integer> group = new LinkedHashMap<>();
		
		group.put("Yusuf", 1998);
		group.put("Modie", 1998);
		group.put("Mammed", 2001);
		
		System.out.println(group.keySet().toArray()[0]);
		
		
		
	}

}
