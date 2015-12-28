
public class Q303_Range_Sum_Query_Immutable {
	// by Jackie using DP
	private int[] sum;

    public Q303_Range_Sum_Query_Immutable(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        sum[0] = 0;
        for(int i = 1; i < n+1; ++i){
            sum[i] = nums[i-1] + sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
    	for(int k = 0; k < sum.length; ++k)
    		System.out.print(sum[k] + ", ");
    	System.out.println();
        return sum[j+1] - sum[i];
    }
    
    public static void main(String[] args){
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	Q303_Range_Sum_Query_Immutable t = new Q303_Range_Sum_Query_Immutable(nums);
    	System.out.println(t.sumRange(0, 2));
    	System.out.println(t.sumRange(2, 5));
    	System.out.println(t.sumRange(0, 5));
    	
    }
}
