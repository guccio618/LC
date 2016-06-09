import java.util.Arrays;


public class Q087_Scramble_String {
	// by ninechapter
	/******************************************************************************************************************
	 * great:  g reat,  gr eat,  gre at,  grea t
	 * rgeat:  r geat,  rg eat,  rge at,  rgea t
	 * 其中 gr eat情况下， gr-> g r， eat一样
	 * 	   rg eat情况下， rg-> r g
	 * 因此是scramble string
	 * 
	 * 动规：
	 * 		State: dp[x][y][k] 表示是从s1串x开始,s2串y开始,他们后面k个字符组成的 Scramble String
	 * 		Function: 对于所有i属于{1,k}, 
	 * 				  s11 = s1.substring(0, i); s12 = s1.substring(i, s1.length()); 
	 * 				  s21 = s2.substring(0, i); s22 = s2.substring(i, s2.length());
 	 *				  s23 = s2.substring(0, s2.length() - i); s24 = s2.substring(s2.length() - i, s2. length());
	 *				  for i = x -> x+k
	 *						dp[x][y][k] = (dp[x][y][i] && dp[x+i][y+i][k-i]) || dp[x][y+k-i][i] && dp[x+i][y][k-i])
	 *		Intialize: dp[i][j][1] = s1[i]==s[j].
	 *		Answer:dp[0][0][len]
	 * 
	 ******************************************************************************************************************/
	// DP方法
	public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null){
            if(s1 == null && s2 == null){
                return true;
            } else {
                return false;
            }
        } else if(s1.length() != s2.length()){
            return false;
        }
        
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        
        for(int length = 2; length <= n; ++length){
            for(int x = 0; x + length - 1 < n; ++x){   // 因为从词长度为2开始，表示就2个字符，因此需要减1
                for(int y = 0; y + length - 1 < n; ++y){
                    for(int i = 1; i < length; ++i){  // i取值范围为[1, length), 不取0和length是因为dp[x][y][0]表示单词长度为0，没有意义
                        dp[x][y][length] |= (dp[x][y][i] && dp[x + i][y + i][length - i]) || (dp[x][y + length - i][i] && dp[x + i][y][length - i]);
                    }
                }
            }
        }
        
        return dp[0][0][n];      // 注意这里x和y应该都是从0开始 ！！！
    }
	
	
	
	/*******************************************************/
	// 搜索方法
	public boolean isScramble2(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }     
        if(s1.length() == 0 || s1.equals(s2)){
            return true;
        }
        
        if(!isValid(s1, s2)){
            return false;
        }
        
        for(int i = 1; i < s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i);
            
            if(isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
            if(isScramble(s11, s24) && isScramble(s12, s23)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isValid(String s1, String s2){
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        return (new String(array1)).equals(new String(array2));
    }
}
