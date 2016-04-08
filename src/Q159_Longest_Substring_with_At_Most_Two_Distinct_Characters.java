
public class Q159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	// by Jackie using two pointers
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null){
            return 0;
        } 
        
        int maxLen = 0; 
        int n = s.length();
        int[] hash = new int[256];
        int slower = 0;
        
        for(int faster = 0; faster < n; ++faster){
            hash[s.charAt(faster)]++;
            while(slower < n && !isValid(hash, 2)){
                hash[s.charAt(slower)]--;
                slower++;
            }
            
            if(isValid(hash, 2)){
                maxLen = Math.max(maxLen, faster - slower + 1);
            }
        }
        
        return maxLen;
    }
    
    public boolean isValid(int[] hash, int k){
        int count = 0;
        for(int i = 0; i < hash.length; ++i){
            if(hash[i] > 0){
                count++;
            }
        }
        return (count <= k);
    }
}
