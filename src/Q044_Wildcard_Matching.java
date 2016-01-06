import java.util.Arrays;

public class Q044_Wildcard_Matching {
	/*************************************************************/
	// by other using DP, easily understand
	public boolean isMatch(String s, String p) {
        boolean[] prev = new boolean[s.length()+1];
        boolean[] curr = new boolean[s.length()+1];
        // base case: empty pattern matches empty string
        prev[0] = true;
        for(int i=1; i <= p.length(); i++){
            // base case: pattern with single character does not match an empty string
            if(p.charAt(i-1) == '*')
                curr[0] = prev[0];   //当s为“”时，*可以表示 
            else
                curr[0] = false;
            for(int j=1; j <= s.length(); j++){
                // match zero, one or more times
                if(p.charAt(i-1) == '*'){
                    curr[j] = prev[j-1] || prev[j] || curr[j-1]; // *分别代表1, 多, 0 个element
                }
                //current character matches 
                else if(p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                //current character does not match
                else{
                    curr[j] = false;
                }
            }
            prev= Arrays.copyOf(curr,curr.length);
        }
        return prev[s.length()];
    }
	
	
	/*************************************************************/
	// by other using DP
	public boolean isMatch2(String s, String p) {
		int sL = s.length(), pL = p.length();

		boolean[][] dp = new boolean[pL + 1][sL + 1];
		dp[0][0] = true;

		for (int i = 1; i <= pL; i++) {
			boolean flag = false;    // The flag is moved here;
			dp[i][0] = true;
			for (int j = 0; j <= sL; j++) {
				flag = flag || dp[i - 1][j];
				char c = p.charAt(i - 1);

				if (c != '*') {
					dp[i][j] = (j > 0 
								&& dp[i - 1][j - 1]
								&& (c == '?' || c == s.charAt(j - 1))
							   );
				} else {
					// For k>=0 and k<=j, if any dp[i-1][k] is true,
					// then '*' will match the rest sequence in s after index k;
					dp[i][j] = (i == 1 || flag);  //curr[j] = prev[j-1] || prev[j] || curr[j-1];
				}
			}
		}

		return dp[pL][sL];
	}
}
