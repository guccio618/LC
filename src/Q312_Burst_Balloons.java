
public class Q312_Burst_Balloons {
	// by other using DP
	public int maxCoins(int[] iNums) {
		if (iNums == null || iNums.length == 0) {
			return 0;
		}

		int[] nums = new int[iNums.length + 2];
		int n = nums.length;
		nums[0] = nums[n - 1] = 1;
		int[][] dp = new int[n][n];

		for (int i = 1; i < n - 1; ++i) {
			nums[i] = iNums[i - 1];
		}

		for (int length = 2; length < n; ++length) { // length从2开始，表示start和end间至少有一个气球
			for (int start = 0; start + length < n; ++start) {
				int end = start + length;
				for (int k = start + 1; k < end; ++k) { // k的起点和终点选择，相当于从原数组的 1 到 n-1!    注意这里用start + 1 !!!
					dp[start][end] = Math.max(dp[start][end], dp[start][k] + dp[k][end] + nums[start] * nums[k] * nums[end]);  // 这里用[start][k], [k][end] !!!
				}
			}
		}

		return dp[0][n - 1];
	}
	
	/****************************************************/
	// by other using Divide & Conquer with Memoization, very fast
	public int maxCoins2(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums)
	    	nums[n++] = x;

	    nums[0] = nums[n] = 1;
	    int[][] memo = new int[nums.length][nums.length];
	    return burst(memo, nums, 0, nums.length-1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    for (int i = left + 1; i < right; ++i)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        					+ burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}
	
	
	/****************************************************/
	// by other using DP, fast
	public int maxCoins3(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums)
	    		nums[n++] = x;

	    nums[0] = nums[n] = 1;
	    int[][] dp = new int[nums.length][nums.length];
	    for (int k = 2; k < nums.length; ++k)
	        for (int left = 0; left < nums.length-k; ++left) {
	            int right = left + k;
	            for (int i = left + 1; i < right; ++i)
	                dp[left][right] = Math.max(dp[left][right], 
	                nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
	        }

	    return dp[0][nums.length-1];
	}
	
	/****************************************************/
	// by Jackie using backtrack, exceed time limit
	public int maxCoins4(int[] nums) {
        if(nums.length == 0) return 0;
        boolean[] visited = new boolean[nums.length];
        int max = -1;
        for(int i = 0; i < nums.length; ++i){
            max = Math.max(max, backtrack(nums, i, visited));
        }
        return max;
    }
    
    public int backtrack(int[] nums, int pos, boolean[] visited){
        if(pos == nums.length || visited[pos]) return 0;
        visited[pos] = true;
        int score = -1;
        int curScore = nums[pos];
        if(pos > 0){
            for(int i = pos-1; i >= 0; --i){
                if(visited[i] != true){
                    curScore *= nums[i];
                    break;
                }
            }
        }
        if(pos < nums.length-1){
            for(int i = pos+1; i < nums.length; ++i){
                if(visited[i] != true){
                    curScore *= nums[i];
                    break;
                }
            }
        }
        
        for(int i = 0; i < nums.length; ++i){
            score = Math.max(score, backtrack(nums, i, visited));
        }
        visited[pos] = false;
        return score+curScore;
    }
    
    
    public static void main(String[] args){
    	Q312_Burst_Balloons t = new Q312_Burst_Balloons();
    	int[] nums = {7,9,8,0,7,1,3,5,5,2,3};
    	System.out.println(t.maxCoins(nums));
    	System.out.println(t.maxCoins2(nums));
    	System.out.println(t.maxCoins3(nums));
    }
}
