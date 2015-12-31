public class Q080_Remove_Duplicates_from_Sorted_Array_II {
	/************************************************************/
	// by other
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int length = nums.length;
		int pointer1 = 0;
		int pointer2 = 1;
		int count = 1;
		while (pointer2 < length) {
			if (nums[pointer2] == nums[pointer1]) {
				if ((pointer2 - pointer1) < 2) {
					nums[count] = nums[pointer1];
					count++;
				}
				pointer2++;
			} else {
				pointer1 = pointer2;
				pointer2++;
				nums[count] = nums[pointer1];
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		Q080_Remove_Duplicates_from_Sorted_Array_II t = new Q080_Remove_Duplicates_from_Sorted_Array_II();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(t.removeDuplicates(nums));
		for(int i = 0; i < nums.length; ++i)
			System.out.print(nums[i] + ", ");
	}
}
