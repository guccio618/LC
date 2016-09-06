
public class Q287_Find_the_Duplicate_Number {
	/***********************************************************/
	// by other using method like cycle linkedlist, very fast!
	public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            
            return slow;
        }
        
        return -1;
    }
	
	
	
	/***********************************************************/
	//by jackie using count sort
	public int findDuplicate2(int[] nums) {
		if(nums == null || nums.length == 0){
            return -1;
        }
        
        int len = nums.length;
        countSort(nums);
        
        for(int i = 0; i < len - 1; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        
        return -1;
    }
	
	public void countSort(int[] nums){
		int len = nums.length;
        int[] count = new int[len + 1];
        int[] tempNums = new int[len];
        
        for(int num : nums){
            count[num]++;
        }
        
        for(int i = 2; i <= len; i++){
            count[i] += count[i - 1];  
        }
        
        for(int i = len - 1; i >= 0; i--){
            int value = nums[i];
            int position = count[value] - 1;
            tempNums[position] = value;
            count[value]--;
        }
        
        System.arraycopy(tempNums, 0, nums, 0, len);
	}
	
	
	public static void main(String[] args){
		Q287_Find_the_Duplicate_Number t = new Q287_Find_the_Duplicate_Number();
		int[] nums = {1,3,4,2,5,6,7,8,9,5};
		System.out.println(t.findDuplicate(nums));
		
	}
}
