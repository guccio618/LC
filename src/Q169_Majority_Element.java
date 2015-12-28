import java.util.Arrays;


public class Q169_Majority_Element {
	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    public static void main(String[] args){
    	Q169_Majority_Element t = new Q169_Majority_Element();
    	int[] array = {3,6,1,2,7,3,3,3,3};
    	System.out.println(t.majorityElement(array));
    }
}
