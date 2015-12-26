/*************************************************************************
 *  Given n non-negative integers a1, a2, ..., an, where each represents 
 *  a point at coordinate (i, ai). n vertical lines are drawn such that 
 *  the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 *  which together with x-axis forms a container, such that the container 
 *  contains the most water.
 *  Note: You may not slant the container.
 *************************************************************************/

public class Q011_Container_With_Most_Water {
	public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = -1;
        
        while(left < right){
            int H = Math.min(height[left], height[right]);
            int L = right - left;
            max = Math.max(max, H*L);
            while(left < right && height[left] <= H)  // L在变小，更大的area只会发生于比当前更大的H上
            	left++;
            while(left < right && height[right] <= H) 
            	right--;
        }
        
        return max;
    }
}
