package graph;

import java.util.HashMap;
import java.util.Map;

public class equality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> a = new HashMap(), b = new HashMap();
		a.put("c", 130); // put ints into the map
		b.put("c", 130);
		boolean x=a.get("c") == b.get("c");// → ?? // what do we get out of the map?
		System.out.println(x);
	}

}
