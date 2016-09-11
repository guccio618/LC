import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q368_Largest_Divisible_Subset {
	// by other, time complexity is O(n^2), space is O(n)
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        int[] curLongestSize = new int[len];
        int[] prevIndexArray = new int[len];
        int maxLen = 0;
        int startIndex = -1;
        
        for(int i = 0; i < len; i++){
            curLongestSize[i] = 1;
            prevIndexArray[i] = -1;
            
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && curLongestSize[j] + 1 > curLongestSize[i]){
                    curLongestSize[i] = curLongestSize[j] + 1;
                    prevIndexArray[i] = j;
                }
            }
                
            if(maxLen < curLongestSize[i]){
                maxLen = curLongestSize[i];
                startIndex = i;
            }
        }
        
        while(startIndex != -1){
            ans.add(nums[startIndex]);
            startIndex = prevIndexArray[startIndex];
        }
        
        return ans;
	}
	
	
	// by Jackie, time complexity is O(n^2), space is O(n)
	public List<Integer> largestDivisibleSubset2(int[] nums) {
		if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }  
        
        Arrays.sort(nums);
        List<Integer> ans = null;
        int len = nums.length;
        List<Integer>[] dp = new List[len];
        int maxLen = 0;
        
        for(int i = 0; i < len; i++){
            if(dp[i] == null){
                dp[i] = new ArrayList<Integer>();
                dp[i].add(nums[i]);
                
                if(maxLen < 1){
                    maxLen = 1;
                    ans = dp[i];
                }
            }
            
            for(int j = i + 1; j < len; j++){
                if(nums[j] % nums[i] == 0){
                    if(dp[j] == null || dp[i].size() + 1 > dp[j].size()){
                        dp[j] = new ArrayList<Integer>(dp[i]);
                        dp[j].add(nums[j]);
                        
                        if(maxLen < dp[j].size()){
                            maxLen = dp[j].size();
                            ans = dp[j];
                        }
                    } 
                }
            }
        }
        
        return ans;
    }
	
	
	
	public static void main(String[] args){
		Q368_Largest_Divisible_Subset t = new Q368_Largest_Divisible_Subset();
		int[] nums = {1};
		List<Integer> list = t.largestDivisibleSubset(nums);
		
		for(int num : list){
			System.out.print(num + ", ");
		}
	} 
}
