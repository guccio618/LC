
public class Q238_Product_of_Array_Except_Self {
	/**********************************************/
	// by other using DP, O(n), O(n)space and without using division
	// res[i] = left[i] * right[i], seperate the product as left part and right
	public int[] productExceptSelf(int[] nums) {
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
	
	
	/**********************************************/
	// by Jackie, O(n), O(1)space, but using division
	// two cases: one is not zero at nums[], the other is at least 1 zero at nums[];
	public int[] productExceptSelf2(int[] nums) {
        long sum = 1;
        int count = 0;
        int pos = -1;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                count++;
                pos = i;
            }
            else
                sum *= nums[i];
            if(count > 1) break;
        }
        
        if(count == 0){
            for(int i = 0; i < nums.length; ++i)
                nums[i] = (int)(sum/nums[i]);
        }
        
        else{
            for(int i = 0; i < nums.length; ++i)
                nums[i] = 0;
            if(count == 1) nums[pos] = (int) sum;
        }
        return nums;
    }
}
