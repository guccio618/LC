
public class Q031_Next_Permutation {
	/***************************************************************
	 * 如输入：1 4 6 5 3 2
	 * step1：从右往左找到第一个破坏升序(非严格)的元素，此例中为4.记下标为 i
     * step2: 依然从右往左,找到第一个大于4的元素，此例中5，交换4和5.
     * step3：从i+1到最右端，逆置。6 4 3 2 to 2 3 4 6
	 * 
	 ***************************************************************/
	// by other
	public void nextPermutation(int[] nums) {
	    int i = nums.length - 2;
	    while(i >= 0 && nums[i] >= nums[i + 1])      // Find 1st id i that breaks descending order
	    	i--;

	    int j = nums.length - 1;
	    if(i >= 0) {                                 // If not entirely descending
	        while(nums[j] <= nums[i])                // Find rightmost first larger number j
	        	j--;           
	        swap(nums, i, j);                        // Switch i and j
	    }

	    reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
	}

	public void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}

	public void reverse(int[] nums, int i, int j) {
	    while(i < j) {
	        swap(nums, i, j);
	        i++; j--;
	    }
	}
}
