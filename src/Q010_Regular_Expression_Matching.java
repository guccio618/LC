/*************************************
 * 类似的题目 44
 * 
 *************************************/

public class Q010_Regular_Expression_Matching {
	/*************************************************************/
	// by other using DP, easily understand
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
            if (s == null && p == null) {
                return true; 
            } else {
                return false;
            }
        }
		
		int sLen = s.length(), pLen = p.length();
		boolean[][] canMatch = new boolean[sLen + 1][pLen + 1];
		canMatch[0][0] = true;                  // If s and p are "", isMathch() returns true;
		
		for(int i = 2; i <= pLen; i++){
			canMatch[0][i] = canMatch[0][i - 2] && p.charAt(i - 1) == '*';
//			if(dp[0][i] == false){        // 注意，这里不能break，防止test case: "c*c*"
//				break;
//			}
		}

		for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char c = p.charAt(j - 1);
                
                if (c != '*') {
                    canMatch[i][j] = canMatch[i - 1][j - 1] && (c == '.' || c == s.charAt(i - 1));
                } else {
                    canMatch[i][j] = (j >= 2 && canMatch[i][j - 2]) || (canMatch[i][j - 1]) || (canMatch[i - 1][j] && j >= 2 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
            }
        }
        
        return canMatch[sLen][pLen];
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
