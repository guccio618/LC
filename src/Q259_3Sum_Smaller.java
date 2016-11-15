import java.util.Arrays;


public class Q259_3Sum_Smaller {
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < len - 2; i++){
            int left = i + 1, right = len - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum >= target){
                    right--;
                } else {
                    count += (right - left);
                    left++;
                }
            }
        }
        
        return count;
    }
	
	
	
	public static void main(String[] args){
		Q259_3Sum_Smaller t = new Q259_3Sum_Smaller();
		int[] nums = {-2, 0, 1, 3};
		System.out.println(t.threeSumSmaller(nums, 4));
	}
}
