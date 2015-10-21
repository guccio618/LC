
public class Q198_House_Robber {
	//by ninechapter
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] res = new int[n];
        int answer = 0;
        if(n >= 1) res[0] = nums[0];
        if(n >= 2) res[1] = Math.max(nums[0], nums[1]);
        if(n >= 3) res[2] = Math.max(nums[0] + nums[2], nums[1]);
        if(n > 2){
            for(int i = 3; i < n; i++){
                res[i] = Math.max(res[i-3], res[i-2]) + nums[i];
            }
        }
        if(n == 1) return res[0];
        else return Math.max(res[n-2], res[n-1]);
    }
}
