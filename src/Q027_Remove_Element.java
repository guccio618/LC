
public class Q027_Remove_Element {
	public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        } 

        int slower = 0, faster = 0;
        int n = nums.length;
        
        while(faster < n){
            if(nums[faster] == val){
                faster++;
            } else {
                nums[slower++] = nums[faster++];
            }
        }
        
        return slower;
    }
}
