
public class Q033_Search_in_Rotated_Sorted_Array {
	/*******************************************************/
	// by Jackie using binary search
	// 分类讨论
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length-1, mid = -1;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > nums[left] || nums[mid] > nums[right]){
                if(target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if(nums[mid] < nums[right] || nums[mid] < nums[left]){
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else{
                right--;
            }
        }
        return -1;
    }
}
