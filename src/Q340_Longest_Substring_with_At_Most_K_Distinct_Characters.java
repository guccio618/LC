
public class Q340_Longest_Substring_with_At_Most_K_Distinct_Characters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int[] hash = new int[256];
        int back = 0;
        int num = 0;
        
        for(int front = 0; front < s.length(); front++) {
            if(hash[s.charAt(front)]++ == 0) {
                num++;
            }
            
            if(num > k) {
                while(--hash[s.charAt(back++)] > 0) ;
                num--;
            }
            
            maxLen = Math.max(maxLen, front - back + 1);
        }
        
        return maxLen;
    }
	
	
	// by ninechapter using two pointers
	public int lengthOfLongestSubstringKDistinct2(String s, int k) {
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
