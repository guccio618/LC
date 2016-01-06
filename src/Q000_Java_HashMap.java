import java.util.HashMap;
import java.util.Iterator;


public class Q000_Java_HashMap {
	public static void main(String[] args){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 1);
		map.put('b', 2);
		map.put('c', 3);
		
		/**************** travel 1 ******************/
		for (char in : map.keySet()) {      // there is at most 2 numbers that appear more than 1/3 times.
			System.out.print(in + ", ");
		}
		System.out.println();
		
		/**************** travel 2 ******************/
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry entry = (HashMap.Entry) iter.next();
			char key = (char) entry.getKey();
			int value = (int) entry.getValue();
			System.out.print(key + ", ");
		}
		System.out.println();
		
	}
}
