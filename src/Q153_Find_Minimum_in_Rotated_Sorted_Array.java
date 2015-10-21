
public class Q153_Find_Minimum_in_Rotated_Sorted_Array {
	//by other
	public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid;
            else
                right = mid;
        }

        return Math.min(nums[left], nums[right]);
    }
	
	public static void main(String[] args){
		Q153_Find_Minimum_in_Rotated_Sorted_Array test = new Q153_Find_Minimum_in_Rotated_Sorted_Array();
		int[] array = {1,2,3,4,5,6};
		System.out.println(test.findMin(array));
	}
}
