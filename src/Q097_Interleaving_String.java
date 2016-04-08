
public class Q097_Interleaving_String {
	// by other using DP
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s2 == null || s2.length() == 0){
            return s3.equals(s1);
        }
        if(s1 == null || s1.length() == 0){
            return s3.equals(s2);
        }
        if(s3 == null || s3.length() == 0){
            return false;
        }
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len3 != len1 + len2){
            return false;
        }
        
        // 存储的是某一状态，dp[1][2]表示访问到str1的第1个char，str2的第2个char时的状态
        boolean[][] dp = new boolean[len1+1][len2+1]; 
        dp[0][0] = true;
        int k = 0;
        
        for(int i = 1; i <= len1; ++i){
            if(s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = true;
            else
                break;
        }
        for(int i = 1; i <= len2; ++i){
            if(s2.charAt(i-1) == s3.charAt(i-1))
                dp[0][i] = true;
            else
                break;
        }
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                k = i + j;
                if(s3.charAt(k-1) == s1.charAt(i-1)){
                    dp[i][j] = dp[i-1][j] || dp[i][j];
                }
                if(s3.charAt(k-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i][j-1] || dp[i][j];
                }
            }
        }
        return dp[len1][len2];
    }
	
	
	
	public static void main(String[] args){
		Q097_Interleaving_String t = new Q097_Interleaving_String();
		System.out.println(t.isInterleave("abb", "a", "aabb"));
	}
}
