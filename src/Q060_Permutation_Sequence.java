import java.util.HashMap;
import java.util.LinkedList;

public class Q060_Permutation_Sequence {
	/*********************************************************************
	 * The core idea is that denote (k-1) / (n-1)! by nth, nth represents 
	 * the nth element in the candidate array should be appended to the 
	 * answer string. Let's be more clear and take n = 4, k = 9 as example.
     * First build you candidate array list = {1,2,3,4}; 
     * Then nth = (k-1) / (n-1)! = 8/6 = 1. which mean arrayList[1] should 
     * be removed and place to your answer string. Now answer is "2". 
     * Then assign k = (k-1) % (n-1)! +1 = 8%6 +1 = 3, and n= n -1 to decide 
     * the next digit. Similarly nth = (k-1) / (n-1)! = 3/2 = 1; 
     * note that now arrayList[1] = 3 since 2 has been removed in the previous 
     * iteration. Now answer is "23". Repeat that procedure until n ==0.
	 * *********************************************************************/
		
	// by other
	public String getPermutation(int n, int k) {
	    int[] factorial = new int[n];
	    LinkedList<Integer> candidate = new LinkedList<Integer>();

	    // Build factorial array
	    for (int i = 0; i < n; i++) {
	        candidate.add(i + 1);
	        factorial[i] = (i == 0) ? 1 : i * factorial[i - 1];
	    }

	    StringBuilder sb = new StringBuilder();

	   // Iteratively generates answer
	    while (n > 0) {
	        int remain = ((k - 1) % factorial[n - 1]) + 1;
	        sb.append(candidate.remove(((k - 1) / factorial[n - 1])));
	        n--;
	        k = remain;
	    }

	    return sb.toString();
	}
	
	
	/****************************************************/
	// by other but too slow
	public String getPermutation2(int n, int k) {
        int fac = 1;
        for(int i = 1; i < n; i++)   fac *= i;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int pos = n-1; pos >= 0; pos--){
            int num = (k-1)/fac+1;
            int temp = num;
            for(int i = 1; i <= temp; i++)   if(map.containsKey(i))    temp++;
            sb.append(temp);
            map.put(temp, 1);
            k -= (num-1)*fac;
            fac /= ((pos==0)?1:pos);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		Q060_Permutation_Sequence t = new Q060_Permutation_Sequence();
		System.out.println(t.getPermutation(3, 5));
	}
}