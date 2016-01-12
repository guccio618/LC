import java.util.Stack;

public class Q084_Largest_Rectangle_in_Histogram {
	/****************************************************
	 * 波峰图算法 
	 * 
	 ****************************************************/
	// by other
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
 
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (stack.empty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.empty() ? i : i - stack.peek() - 1;
				area = Math.max(area, height[start] * width);
				i--;   // 当前的height[i]由于没有入栈，因此，需要重新判断入栈
			}
		}
		while (!stack.empty()) {    // 防止到最后一直是递增的情况
			int start = stack.pop();
			int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
			area = Math.max(area, height[start] * width);
		}
		return area;
	}
	
	
	/****************************************************/
	// by Jackie using DP, but exceed time limit
	public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        long maxArea = Integer.MIN_VALUE;
        int[][] minHeight = new int[len][len];
        
        for(int i = 0; i < len; ++i){
            for(int j = i+1; j < len; ++j){
                minHeight[i][i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < len; ++i)
            minHeight[i][i] = height[i];
        
        for(int i = 0; i < len; ++i){
            for(int j = i+1; j < len; ++j){
                minHeight[i][j] = Math.min(minHeight[i][j-1], height[j]);
                maxArea = Math.max(maxArea, minHeight[i][j] * (j-i));
            }
        }
        return (int) maxArea;
    }
	
	
	public static void main(String[] args){
		Q084_Largest_Rectangle_in_Histogram t = new Q084_Largest_Rectangle_in_Histogram();
		int[] height = {2,1,5,6,2,3};
		System.out.println(t.maxArea(height));
	}
}
