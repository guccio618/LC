
public class Q396_Rotate_Function {
	public int maxRotateFunction(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int len = nums.length;
        int productSum = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++){
        	productSum += nums[i] * i;
        	sum += nums[i];
        }
        
        ans = productSum;
        
        for(int i = 1; i < len; i++){
        	productSum = productSum + sum - (nums[len - i] * len);
        	ans = Math.max(ans, productSum);
        }
              
        return ans;
    }
}
