
public class Q053_Maximum_Subarray {
	// by Jackie using DP, time complexity O(n), space O(1)
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int ans = nums[0];
        int prevMax = nums[0];
        
        for(int i = 1; i < len; i++){
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            ans = Math.max(ans, prevMax);
        }
        
        return ans;
    }
	
	
	//by ninechapter using DP
	public int maxSubArray2(int[] A) {
		if (A == null || A.length == 0) return 0;  
        int n = A.length;
        int []global = new int[n];
        int []local = new int[n];
        global[0] = A[0];
        local[0] = A[0];
        for(int i = 1; i < n; i++) {  
            local[i] = Math.max(A[i],local[i-1]+A[i]);  
            global[i] = Math.max(local[i],global[i-1]);  
        }  
        return global[n-1];  
    }
	
	//by ninechapter
		public int maxSubArray3(int[] A) {
	        if (A == null || A.length == 0) return 0;
	        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
	        for (int i = 0; i < A.length; i++) {
	            sum += A[i];
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(minSum, sum);
	        }
	        return max;
	    }
		
		
		
		
		
	public static void main(String[] args){
		Q053_Maximum_Subarray t = new Q053_Maximum_Subarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4,6,3,-3,6};
		System.out.println(t.maxSubArray(nums));
		System.out.println(t.maxSubArray2(nums));
	}
	
}
