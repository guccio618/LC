import java.util.Arrays;


public class Q280_Wiggle_Sort {
	/*************************************************/
	// by Jackie, space O(1)
	public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        
        int n = nums.length;
        
        for(int i = 0; i < n - 1; i++){
            if(i % 2 == 0){
                if(nums[i] > nums[i + 1]){
                    swap(nums, i, i + 1);
                }
            } else {
                if(nums[i] < nums[i + 1]){
                    swap(nums, i, i + 1);
                }
            }
        }
    }
    
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    
    
    /**************************************************/
    // by Jackie, space O(n)
    public void wiggleSort2(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        
        int n = nums.length;
        int[] newNums = new int[n];
        int head = 0;
        int nextHead = n % 2 == 0 ? n / 2 : n / 2 + 1;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                newNums[i] = nums[head++];
            } else {
                newNums[i] = nums[nextHead++];
            }
        }
        
        for(int i = 0; i < n; i++){
            nums[i] = newNums[i];
        }
    }
}
