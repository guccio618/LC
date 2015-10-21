
public class Q053_Maximum_Subarray {
	//by ninechapter using DP
	public int maxSubArray(int[] A) {
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
		public int maxSubArray2(int[] A) {
	        if (A == null || A.length == 0) return 0;
	        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
	        for (int i = 0; i < A.length; i++) {
	            sum += A[i];
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(minSum, sum);
	        }
	        return max;
	    }
	
	//by jackie, but time limit exceeded
	public int maxSubArray3(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = nums[i];
            max = Math.max(f[i][i], max);
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                f[j][i] = f[j][i-1] + nums[i];
                max = Math.max(f[j][i], max);
            }
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
