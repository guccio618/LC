public class Q330_Patching_Array {
	// by other using Greedy, nice!
	public int minPatches(int[] nums, int n) {
        int index = 0;  
        int result = 0;  
        long currentRange = 0;      // 当前能覆盖到的最大范围，必须从0开始 
        while(currentRange < n) {  
            if(index < nums.length && nums[index] <= currentRange + 1) {   
                currentRange = currentRange + nums[index];  
                index++;  
            } else {  
                result++;  
                currentRange += (currentRange + 1);  // 增添currentRange+1可以让currentRange增长的最快同时保证中间不出现裂口
            }  
        }  
        return result;  
    }
	
	
	public static void main(String[] args){
		Q330_Patching_Array t = new Q330_Patching_Array();
		int[] nums = {2, 3};
		System.out.println(t.minPatches(nums, 6));
	}
}
