
public class Q209_Minimum_Size_Subarray_Sum {
	// by ninechapter
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int front = 0, back = 0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        
        for(; back < n; ++back){
            while(front < n && sum < s){
                sum += nums[front++];
            }
            if(sum >= s){
                minLen = Math.min(minLen, front - back);
            }
            sum -= nums[back];     // 此步必须写在 if(sum>= s) 外头
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
