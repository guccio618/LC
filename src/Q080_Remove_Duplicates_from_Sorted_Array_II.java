public class Q080_Remove_Duplicates_from_Sorted_Array_II {
	/************************************************************/
	// by Jackie using two pointers
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length <= 2){
            return nums.length;
        }
        
        int len = nums.length;
        int front = 1;
        int count = 1;
        int back = 0;
        
        while(front < len){
            if(nums[front] == nums[back]){
                if(count < 2){
                    nums[++back] = nums[front];
                    count++;
                } 
                
                front++;
            } else {
                nums[++back] = nums[front];
                count = 1;
                front++;
            }
        }
        
        return back + 1;
	}
	
	public static void main(String[] args){
		Q080_Remove_Duplicates_from_Sorted_Array_II t = new Q080_Remove_Duplicates_from_Sorted_Array_II();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(t.removeDuplicates(nums));
		for(int i = 0; i < nums.length; ++i)
			System.out.print(nums[i] + ", ");
	}
}
