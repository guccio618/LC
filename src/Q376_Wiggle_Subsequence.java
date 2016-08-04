
public class Q376_Wiggle_Subsequence {
	// by Jackie using DP, time complexity O(n)
	public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length == 1){
        	return 1;
        }
        
        int len = nums.length;
        int[] tempNums = new int[len - 1];
        int maxLen = 0;
        int preFlag = 0;
        
        for(int i = 0; i < len - 1; i++){
            if(nums[i] - nums[i + 1] > 0){
                tempNums[i] = 1;
            } else if(nums[i] - nums[i + 1] < 0){
                tempNums[i] = -1;
            } else {
                tempNums[i] = 0;
            }
        }
                
        for(int i = 0; i < len - 1; i++){
        	if(tempNums[i] != 0){
        		if(preFlag == 0){
        			preFlag = tempNums[i];
        			maxLen++;
        		} else if(preFlag * tempNums[i] == -1){
        			preFlag = tempNums[i];
        			maxLen++;
        		}       		
        	}
        }
        
        return maxLen + 1;
    }
	
	
	
	// by Jackie using DP, time complexity O(n^2)
	public int wiggleMaxLength2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length == 1){
        	return 1;
        }
        
        int len = nums.length;
        int[] tempNums = new int[len - 1];
        int[] dp = new int[len - 1];
        int maxLen = 0;
        
        for(int i = 0; i < len - 1; i++){
            if(nums[i] - nums[i + 1] > 0){
                tempNums[i] = 1;
            } else if(nums[i] - nums[i + 1] < 0){
                tempNums[i] = -1;
            } else {
                tempNums[i] = 0;
            }
        }
        
        for(int i = 0; i < len - 1; i++){
        	if(tempNums[i] != 0){
        		dp[i] = 1;
        	}
        }
        
        maxLen = dp[0];
        
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < i; j++){
                if(tempNums[i] * tempNums[j] == -1){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        
        return maxLen + 1;
    }
	
	
	
	public static void main(String[] args){
		Q376_Wiggle_Subsequence t = new Q376_Wiggle_Subsequence();
		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		System.out.println(t.wiggleMaxLength(nums));
		System.out.println(t.wiggleMaxLength2(nums));
	}
}
