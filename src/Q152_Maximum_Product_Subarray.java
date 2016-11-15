
public class Q152_Maximum_Product_Subarray {
	// by Jackie using DP, time complexity O(n), space O(1)
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int max = nums[0], min = nums[0];
        int preMax = max, preMin = min;
        int ans = nums[0];
        
        for(int i = 1; i < n; ++i){
            if(nums[i] > 0){
                max = Math.max(preMax * nums[i], nums[i]);
                min = Math.min(preMin * nums[i], nums[i]);
                preMax = max;
                preMin = min;
            } else{
                max = Math.max(preMin * nums[i], nums[i]);
                min = Math.min(preMax * nums[i], nums[i]);
                preMax = max;
                preMin = min;
            }
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
	
	
	//by ninechapter, time complexity O(n), space O(n)
	public int maxProduct2(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int[] max = new int[n];
		int[] min = new int[n];
		int res = nums[0];
		max[0] = nums[0];
		min[0] = nums[0];
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0) {
				max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
				min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
			}
			if (nums[i] < 0) {
				max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
				min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
			}
			res = Math.max(res, max[i]);
		}
		return res;
	}
	
	
	public static boolean isProduct(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return false;
		} else if(target == 0) {
			for(int num : nums) {
				if(num == 0) {
					return true;
				}
			}
			
			return false;
		}
		
		int sign = 1;
		int product = 1;
		int front = 0;
		int len = nums.length;
		int targetFlag = target > 0 ? 1 : -1;
		target = Math.abs(target);
		
		for(int back = 0; back < len; back++) {
			while(front < len && product < target) {
				sign = nums[front] > 0 ? sign : -sign;
				product *= Math.abs(nums[front++]);
			}
			
			if(product == target) {
				if(product * sign == target * targetFlag) {
					return true;
				}
			}
			
			product /= Math.abs(nums[back]);
			sign = nums[back] > 0 ? sign : -sign;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {		
		int[] nums= {1, -2, 3, 4, -5, 6 };
		int[] targets = {12, 20, -20};
		
		for(int target : targets) {
			System.out.println(isProduct(nums, target));
		}
		
	}
}
