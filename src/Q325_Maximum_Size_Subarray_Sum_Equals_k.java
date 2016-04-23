import java.util.HashMap;
import java.util.Map;


public class Q325_Maximum_Size_Subarray_Sum_Equals_k {
	/********************************************************************/
	// by Jackie using HashMap, time complexity is O(n), space is O(1)
	public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                int pos = map.get(sum - k);
                ans = Math.max(ans, i - pos);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        
        return ans;
    }
    
	
	
	/********************************************************************/
	// by Jackie using DP, time complexity is O(n^2), space is O(n)
    public int maxSubArrayLen2(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        int ans = 0;
        sum[0] = 0;
        
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
            if(sum[i] == k){
                ans = i;
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(sum[i] - sum[j] == k){
                    ans = Math.max(ans, i - j);
                }
            }
        }
        
        return ans;
    }
}
