
public class Q340_Longest_Substring_with_At_Most_K_Distinct_Characters {
	// by ninechapter using two pointers
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || k <= 0){
            return 0;
        } 
        
        int[] hash = new int[256];
        int slower = 0;
        int n = s.length();
        int ans = 0;
        
        for(int faster = 0; faster < n; faster++){
            hash[s.charAt(faster)]++;
            while(slower < faster && !isValid(hash, k)){   // 注意这里是slower < faster, 同时是 !isValid  ！！！
                hash[s.charAt(slower)]--;
                slower++;
            }
            if(isValid(hash, k)){
                ans = Math.max(ans, faster - slower + 1);
            }
        }
        
        return ans;
    }
    
    public boolean isValid(int[] hash, int k){
        int count = 0;
        for(int i = 0; i < hash.length; ++i){
            if(hash[i] > 0){
                count++;
            }
        }
        return count <= k;
    }
}
