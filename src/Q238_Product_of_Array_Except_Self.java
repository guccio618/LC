
public class Q238_Product_of_Array_Except_Self {
	// by other using DP, O(n) time complexity and O(1) space
	public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        int right = 1;
        
        for(int i = 1; i < len; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        for(int i = len - 1; i >= 0; i--){
            ans[i] *= right;
            right *= nums[i];
        }
        
        return ans;
    }
	
	/**********************************************/
	// by other using DP, O(n), O(n)space and without using division
	// res[i] = left[i] * right[i], seperate the product as left part and right
	public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        
        for(int i = 1; i < len; ++i)
            left[i] = left[i-1]*nums[i-1];
        for(int i = len-2; i >= 0; --i)
            right[i] = right[i+1]*nums[i+1];
        for(int i = 0; i < len; ++i)
            res[i] = left[i] * right[i];
        return res;
    }
}
