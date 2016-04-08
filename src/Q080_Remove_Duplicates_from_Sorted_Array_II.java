public class Q080_Remove_Duplicates_from_Sorted_Array_II {
	/************************************************************/
	// by Jackie using two pointers
	public int removeDuplicates(int[] nums) {
		if(nums == null){
            return 0;
        } else if(nums.length <= 2){
            return nums.length;
        }
        
        int front = 1, back = 0;
        int n = nums.length;
        int count = 1;
        
        while(front < n){
            if(nums[front] == nums[back]){
                count++;
                if(count <= 2){
                    nums[++back] = nums[front];
                } 
                front++;
            } else {
                nums[++back] = nums[front];
                front++;
                count = 1;
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
