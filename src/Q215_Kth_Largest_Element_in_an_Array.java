
public class Q215_Kth_Largest_Element_in_an_Array {
	// by ninechapter using quickselect, time complexity is O(n)
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while(left < right){       	      // 注意这里用的是 left < right
            int index = partition(nums, left, right);
            int count = index + 1;
            
            if(k > count){
                left = index + 1;         // 注意这里用的是left = index + 1，有偏移，防止死循环 ！！！
            } else if(k < count){
                right = index - 1;        // 注意这里用的是right = index - 1 ！！！
            } else {
                return nums[index];
            }
        }

        return nums[left];
    }
    
    public int partition(int[] nums, int left, int right){
    	if(left == right){
    		return nums[left];
    	}
        int i = left;
        int pivot = nums[right];
        int temp = 0;
        
        for(int j = left; j < right; ++j){
            if(nums[j] >= pivot){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        
        temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        return i;
    }
    
    
    public static void main(String[] args){
    	Q215_Kth_Largest_Element_in_an_Array t = new Q215_Kth_Largest_Element_in_an_Array();
//    	int[] nums = {2,1};
    	int[] nums = {3,2,1,5,6,12,4};
    	System.out.println(t.findKthLargest(nums, 2));
    }
}
