
public class Q042_Trapping_Rain_Water {
	/**************************************************************************************
	 * (1). 每一个height[i]上的蓄水数等于其 min(left[maxHeight], right[maxHeight]) - height[i];
	 * (2). 用memory分别记录当前结点对应的左边和右边的最大高度
	 * 对比题目见11题
	 * 
	 **************************************************************************************/
	// two pointers
	public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int count = 0;
        
        while (left < right) {
            int smaller = Math.min(height[left], height[right]);
            
            while (left < right && height[left] <= smaller) {
                count += smaller - height[left];
                left++;
            }
            
            while (left < right && height[right] <= smaller) {
                count += smaller - height[right];
                right--;
            }
        }
        
        return count;
    }
	
	
	// by ninechapter using two pointers
	public int trap2(int[] heights) {
		if(heights == null || heights.length == 0){
            return 0;
        }
        
        int ans = 0;
        int n = heights.length;
        int leftMaxHeight = heights[0];
        int rightMaxHeight = heights[n - 1];
        int left = 0, right = n - 1;
        
        while(left + 1 < right){      // 注意这里用的是left + 1 < right!!! 判断的是中间的存水量
            if(leftMaxHeight < rightMaxHeight){
                left++;               // 先++ !!!
                if(leftMaxHeight > heights[left]){
                    ans += leftMaxHeight - heights[left];
                } else {
                    leftMaxHeight = heights[left];
                }
            } else {
                right--;              // 先-- !!!
                if(rightMaxHeight > heights[right]){
                    ans += rightMaxHeight - heights[right];
                } else {
                    rightMaxHeight = heights[right];
                }
            }
        }
        
        return ans;
	}
	
	
	// by Jackie using DP, time complexity O(n), space 0(n)
	public int trap3(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[0] = left[len - 1] = right[len - 1] = 0;
        int res = 0;
        
        for(int i = 1; i < len - 1; ++i){
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for(int i = len - 2; i > 0; --i){
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        
        for(int i = 1; i < len - 1; ++i){
            int waterNum = Math.min(left[i], right[i]) - height[i];
            if(waterNum > 0){
                res += waterNum;
            }
        }
        return res;
    }
}
