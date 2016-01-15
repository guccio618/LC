import java.util.Arrays;


public class Q300_Longest_Increasing_Subsequence {
	/**********************************************************/
	// by other using DP+binary search, O(nlogn)
	public int lengthOfLIS(int[] nums) {
        int N = 0, idx, x;
        for(int i = 0; i < nums.length; i++) {
            x = nums[i];
            if (N < 1 || x > nums[N-1]) {
                nums[N++] = x;
            }
            else if ((idx = Arrays.binarySearch(nums, 0, N, x)) < 0) {
                nums[-(idx + 1)] = x;
            }
        }
        return N;
    }
	
	/**********************************************************/
	// by Jackie using DP, O(n^2)
	public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] res = new int[nums.length];  // 存放到当前位为止最大的的increasing subsequence个数
        res[0] = 0;  // 必须从0开始，否则例如在res[0] = 1时，在之后的叠加中，每次都会被多加上1
        int max = -1;
        
        for(int i = 1, len = nums.length; i < len; ++i){ // 反向DP
        	for(int j = 0; j < i; ++j){
        		if(nums[j] < nums[i])
        			res[i] = Math.max(res[i], res[j]+1);
        			max = Math.max(max, res[i]);
        	}
        }        
        return (max == -1) ? 1 : max+1;
    }
	
	public static void main(String[] args){
		Q300_Longest_Increasing_Subsequence t = new Q300_Longest_Increasing_Subsequence();
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(t.lengthOfLIS(nums));
	}
}
