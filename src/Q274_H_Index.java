import java.util.Arrays;


public class Q274_H_Index {
	// by other using bucket sort
	public int hIndex(int[] citations) {
		int n = citations.length;
	    int[] buckets = new int[n + 1];
	    for(int c : citations) {
	        if(c >= n) {
	            buckets[n]++;
	        } else {
	            buckets[c]++;
	        }
	    }
	    int count = 0;
	    for(int i = n; i >= 0; i--) {
	        count += buckets[i];
	        if(count >= i) {
	            return i;
	        }
	    }
	    return 0;
    }
	
	
	public static void main(String[] args){
		Q274_H_Index t = new Q274_H_Index();
		int[] citations = {3, 0, 6, 1, 5}; // test case: {0}, {100}
		int[] citations2 = {6,7,3,6,6};
		System.out.println(t.hIndex(citations2));
	}
}
