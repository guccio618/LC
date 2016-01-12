import java.util.Arrays;


public class Q137_Single_Number_II {
	/*****************************************************/
	// by other
	public int singleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int i;
        for(i = 0; i < len - 1 && nums[i] == nums[i + 1]; i += 3);
        return nums[i];
    }
	
	/*****************************************************/
	// by other using bit manipulation, nice
	public int singleNumber2(int[] nums) {
        int one = 0; int two = 0; int three = 0;
        for(int i = 0; i < nums.length; i++){
            // if now one is nums[i], by ANDing and ORing, two now equals to nums[i]
            two |= one & nums[i];
            // if now one is zero, it stores the nums[i] in it
            // if now one is nums[i], it clears the content since a^a = 0
            // if now one is other number, it just accumulates
            one ^= nums[i]; 
            // if now one and two has the same value, it means the 
            // number shows 3 times, thus
            three = one & two;
            // if three is the number, clear this number from the one and two
            // a &= ~b => a - b
            // 0100 | 0011 = 3+4 = 7  (0111)
            // 7 &= ~3 => 0111 & 1100 = 0100 = 4 (7 - 3)
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
