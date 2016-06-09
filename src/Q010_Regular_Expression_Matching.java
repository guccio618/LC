/*************************************
 * 类似的题目 44
 * 
 *************************************/

public class Q010_Regular_Expression_Matching {
	/*************************************************************/
	// by other using DP, easily understand
	public boolean isMatch(String s, String p) {
		int sL = s.length(), pL = p.length();
		boolean[][] dp = new boolean[sL + 1][pL + 1];
		dp[0][0] = true; // If s and p are "", isMathch() returns true;

		for (int i = 0; i <= sL; i++) {  
			// j starts from 1, since dp[i][0] is false when i != 0;
			for (int j = 1; j <= pL; j++) {
				char c = p.charAt(j-1);    // p[j-1]相当于p中的第j个char,即dp中的j

				if (c != '*') {	
					// The previous character of s and p should match;
					// And, dp[i-1][j-1] is true;
					dp[i][j] = ( i > 0 && dp[i-1][j-1] && (c == '.' || c == s.charAt(i-1)) ); 
				} 
				else {
					// Two situations:
					// (1) dp[i][j-2] is true, and there is 0 preceding element of '*';
					// (2) The last character of s should match the preceding element of '*';
					//     And, dp[i-1][j] should be true;
					dp[i][j] = ( (j > 1 && dp[i][j-2])  // 不使用*, 如 "c*" 此时表示0个c,因此向前跳2步,判断此时是否为true
								 || ( i > 0             
										 &&  dp[i-1][j]  // 如a*能表示a,即*可以表示为其前面的char
										 &&  (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) 
								    )
							   ); 
				}	
			}
			for(int j = 0; j <= pL; ++j)
				System.out.print(dp[i][j] + ", ");
			System.out.println();
		}
		return dp[sL][pL];
	}
	
	
	/*************************************************************/
	// by other using DP, slower
	public boolean isMatch2(String s, String p) {
		// base case
		if (p.length() == 0) return s.length() == 0;
		// special case
		if (p.length() == 1) {
			// if the length of s is 0, return false
			if (s.length() < 1)  return false;
			// if the first does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) return false;
			// otherwise, compare the rest of the string of s and p.
			else return isMatch(s.substring(1), p.substring(1));
		}
	 
		// case 1: when the second char of p is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} 
			else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}
	 
		// case 2: when the second char of p is '*', complex case.
		else {
			//case 2.1: a char & '*' can stand for 0 element
			if (isMatch(s, p.substring(2))) {
				return true;
			}
	 
			//case 2.2: a char & '*' can stand for 1 or more preceding element, 
			//so try every sub string
			int i = 0;
			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}
	
		
   /*************************************************************/
   // by other using DP, faster
   /** This solution is assuming s has no regular expressions.
     * 
     * dp: res[i][j]=is s[0,...,i-1] matched with p[0,...,j-1];
     * 
     * If p[j-1]!='*', res[i][j] = res[i-1][j-1] &&
     * (s[i-1]==p[j-1]||p[j-1]=='.'). Otherwise, res[i][j] is true if
     * res[i][j-1] or res[i][j-2] or
     * res[i-1][j]&&(s[i-1]==p[j-2]||p[j-2]=='.'), and notice the third
     * 'or' case includes the first 'or'.
     * 
     * 
     * Boundaries: res[0][0]=true;//s=p="". res[i][0]=false, i>0.
     * res[0][j]=is p[0,...,j-1] empty, j>0, and so res[0][1]=false,
     * res[0][j]=p[j-1]=='*'&&res[0][j-2].
     * 
     * O(n) space is enough to store a row of res.
     */
	public boolean isMatch3(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[] res = new boolean[pLen+1];
        res[0] = true;

        int i, j;
        
        for(int k = 0; k <= pLen; ++k)
        	System.out.print(res[k] + ", ");
        System.out.println();
        
        for (j = 2; j <= pLen; j++)
            res[j] = res[j-2] && p.charAt(j-1) == '*';
        
        for(int k = 0; k <= pLen; ++k)
        	System.out.print(res[k] + ", ");
        System.out.println();

        char pc, sc, tc;
        boolean pre, cur;    // pre=res[i-1][j-1], cur=res[i-1][j]

        for (i = 1; i <= sLen; i++) {
            pre = res[0];
            res[0] = false;
            sc = s.charAt(i-1);

            for (j = 1; j <= pLen; j++) {
                cur = res[j];
                pc = p.charAt(j-1);
                if (pc != '*')
                    res[j] = pre && (sc == pc || pc == '.');
                else {
                    // pc == '*' then it has a preceding char, i.e. j>1
                    tc = p.charAt(j-2);
                    res[j] = res[j-2] || (res[j] && (sc == tc || tc == '.'));
                }
                pre = cur;
            }
        }
        
        return res[pLen];
    }

    
    public static void main(String[] args){
    	Q010_Regular_Expression_Matching t = new Q010_Regular_Expression_Matching();
//    	System.out.println(t.isMatch("aa", "a"));
//    	System.out.println(t.isMatch("aa", "aa"));
//    	System.out.println(t.isMatch("aaa", "aa"));
//    	System.out.println(t.isMatch("aa", "a*"));
//    	System.out.println(t.isMatch("aa", ".*"));
//    	System.out.println(t.isMatch("ab", ".*"));
//    	System.out.println(t.isMatch("aab", "c*a*b"));  
    	System.out.println(t.isMatch("aaab", "a*b"));  
    }
}
