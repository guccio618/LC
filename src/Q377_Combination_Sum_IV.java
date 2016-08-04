
public class Q377_Combination_Sum_IV {
	// by Jackie
	public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target <= 0){
        	return 0;
        } 
        
        int[] ways = new int[target + 1];
        ways[0] = 1;
        
        for(int i = 1; i <= target; i++){
        	for(int j = 0; j < nums.length; j++){
        		if(nums[j] <= i){
        			ways[i] += ways[i - nums[j]];
        		}
        	}
        }
        
        return ways[target];
    }
	
	public static void main(String[] args){
		Q377_Combination_Sum_IV t = new Q377_Combination_Sum_IV();
		int[] nums = {1, 2, 3};
		
		System.out.println(t.combinationSum4(nums, 4));
	}
}
