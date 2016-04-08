
public class Q026_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } 
        
        int n = nums.length;
        int front = 0, back = 0;
        
        for(; front < n; ++front){
            nums[back++] = nums[front];
            while(front + 1 < n && nums[front] == nums[front + 1]){
                front++;
            }
        }
        
        return back;
    }
}
