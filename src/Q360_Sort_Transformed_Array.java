
public class Q360_Sort_Transformed_Array {
	// by Jackie, time complexity O(n)
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int n = nums.length;
        int[] ans = new int[n];
        double vertex = -(b * 1.0) / (2 * a);
        int position = 0;
        
        while(position < n && nums[position] <= vertex){
            position++;
        }

		int point1 = position - 1;
		int point2 = position;

		if (a >= 0) {
			for (int i = 0; i < n; i++) {
				int num1 = (point1 >= 0) ? getResult(nums[point1], a, b, c)
						: Integer.MAX_VALUE;
				int num2 = (point2 < n) ? getResult(nums[point2], a, b, c)
						: Integer.MAX_VALUE;

				if (num1 < num2) {
					ans[i] = num1;
					point1--;
				} else {
					ans[i] = num2;
					point2++;
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				int num1 = (point1 >= 0) ? getResult(nums[point1], a, b, c)
						: Integer.MIN_VALUE;
				int num2 = (point2 < n) ? getResult(nums[point2], a, b, c)
						: Integer.MIN_VALUE;

				if (num1 > num2) {
					ans[i] = num1;
					point1--;
				} else {
					ans[i] = num2;
					point2++;
				}
			}
		} 
       
		if (a < 0) {
			reverseArray(ans);
		}
        
        return ans;
    }
    
    public int getResult(int num, int a, int b, int c){
        return a * num * num + b * num + c;
    }
    
    public void reverseArray(int[] ans){
    	int left = 0, right = ans.length - 1;
		int temp = 0;

		while (left < right) {
			temp = ans[left];
			ans[left] = ans[right];
			ans[right] = temp;
			left++;
			right--;
		}
    }
    
     
    
    public static void main(String[] args){
    	Q360_Sort_Transformed_Array t = new Q360_Sort_Transformed_Array();
    	int[] nums = {-4, -2, 2, 4};
    	int a = -1;
    	int b = 3;
    	int c = 5;
    	
    	int[] ans = t.sortTransformedArray(nums, a, b, c);
    	
    	for(int i = 0; i < ans.length; i++){
    		System.out.print(ans[i] + ", ");
    	}
    }
}
