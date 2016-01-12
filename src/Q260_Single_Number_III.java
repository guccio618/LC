import java.util.Arrays;
import java.util.HashSet;


public class Q260_Single_Number_III {
	/***************************************************************
	 * flag is the last "1" bit of n, the two elements which appear 
	 * only once must be different in this bit, so we can use flag to
	 * divide all the elements into two parts, one contains a and the 
	 * other one contains b
	 ***************************************************************/
	// by other using bit manipulation, faster
    public int[] singleNumber(int[] nums) {
    	if(nums == null || nums.length <= 1) return null;
    	int n = 0;
    	for(int i = 0; i < nums.length; i++) {
            n = n ^ nums[i]; 
        }
    	int flag = n & (~(n - 1));
//    	System.out.println("n = " + n);
//    	System.out.println("flag = " + flag);
    	int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++) {
            if((flag & nums[i]) == 0) 
            	a ^= nums[i];
            else 
            	b ^= nums[i];
        }
        int[] res = new int[2];
        res[0] = a;
        res[1] = b;
        return res;
    }
	
	
	// by Jackie
	public int[] singleNumber2(int[] nums) {
        if(nums == null || nums.length <= 1) return null;
        int[] res = new int[2];
        int pos = 0;
        Arrays.sort(nums);
        for(int i = 0, len = nums.length; i+1 < len; i += 2){
        	if(nums[i] != nums[i+1])
        		res[pos++] = nums[i--];
        }
        if(pos == 1) res[pos] = nums[nums.length-1];
        return res;
    }
	
	
	// by Jackie, a little bit slow
	public int[] singleNumber3(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0, len = nums.length; i < len; ++i){
        	if(!set.contains(nums[i]))
        		set.add(nums[i]);
        	else
        		set.remove(nums[i]);
        }
        int[] res = new int[2];
        int pos = 0;
        for(int n : set)
        	res[pos++] = n;
        return res;
    }
	
	public static void main(String[] args){
		Q260_Single_Number_III t = new Q260_Single_Number_III();
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] res = t.singleNumber(nums);
		for(int i = 0; i < res.length; ++i)
			System.out.print(res[i] + ", ");
	}
}
