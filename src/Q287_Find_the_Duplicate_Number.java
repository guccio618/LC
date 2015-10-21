
public class Q287_Find_the_Duplicate_Number {
	//by jackie
	public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return 0;
    }
}
