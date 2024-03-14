package d240313;

import java.util.*;

public class MapEx1 {

	public static void main(String[] args) {
		String[] msg = {"Berlin", "Dortmund", "Frankfurt", "Gelsenkirchen", "Hamburg"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();	// HashMap 생성
		
		for(int i=0; i<msg.length; i++) {
			map.put(i, msg[i]);
		}
		
		Set<Integer> keys = map.keySet();
		for(Integer n: keys) {
			System.out.println(map.get(n));
		}
	
	}

}
