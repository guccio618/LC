public class Q213_House_Robber_II {
	/****************************************************
	 * dp1 from 1 to n-1
	 * dp2 from 2 to n
	 * find the max(dp1[n - 2], dp2[n - 1]);
	 * 
	 ****************************************************/
	// by other using DP
	
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        
        for(int i = 2; i < n - 1; ++i){
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        
        for(int i = 3; i < n; ++i){
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
	
	
	
	/*****************************************************/
	//by jackie using DP
	public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int array1[] = new int[n-1];
        int array2[] = new int[n-1];
        for(int i = 0; i < n-1; i++)
        	array1[i] = nums[i];
        for(int i = 1; i < n; i++)
        	array2[i-1] = nums[i];       
        return Math.max(robArray(array1), robArray(array2));
    }
	
	public int robArray(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int n = nums.length;
        int res[] = new int[n];
        if(n >= 1) res[0] = nums[0];
        if(n >= 2) res[1] = Math.max(nums[0], nums[1]);
        if(n >= 3) res[2] = Math.max(nums[0] + nums[2], nums[1]);
        for(int i = 3; i < n; i++)
        	res[i] = Math.max(res[i-2], res[i-3]) + nums[i];
        if(n == 1) return res[0];
        else return Math.max(res[n-1], res[n-2]);
	}
	
	public static void main(String[] args){
		int[] array = {1,1,1,2};
		Q213_House_Robber_II test = new Q213_House_Robber_II();
		System.out.println(test.rob(array));
	}
}
