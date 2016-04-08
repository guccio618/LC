
public class Q045_Jump_Game_II {
	// by Jackie using Greedy, time complexity O(n)
	public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        
        int curFast = nums[0];
        int nextFast = nums[0];
        int n = nums.length;
        int index = 0;
        int count = 1;
        
        while(curFast < n - 1){
            count++;
            while(index <= curFast){
                nextFast = Math.max(nextFast, index + nums[index]);
                index++;
            }
            curFast = nextFast;
        }
        
        return count;
    }
	
	
	//by ninechapter using DP
	public int jump2(int[] nums) {
        int[] steps = new int[nums.length];
        
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[nums.length - 1];
    }
	
	//by ninechapter using Greedy
	public int jump3(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}
