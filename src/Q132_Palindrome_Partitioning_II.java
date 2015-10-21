
public class Q132_Palindrome_Partitioning_II {
	//by ninechapter
	public boolean[][] getIsPalindrome(String s){
	    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
	    for(int i = 0; i < s.length(); i++)
		isPalindrome[i][i] = true;
	
	    for (int i = 0; i < s.length() - 1; i++) 
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
	
	    for(int length = 2; length < s.length(); length++){
		    for(int start = 0; start + length < s.length(); start++){
			    isPalindrome[start][start + length] = (isPalindrome[start+1][start+length-1] && (s.charAt(start) == s.charAt(start+length)));
		    }
	    }
	    return isPalindrome;
    }

    public int minCut(String s){
	    if(s == null || s.length() == 0) return 0;
	    int[] f = new int[s.length()+1];
	    for(int i = 0; i <= s.length(); i++)
		    f[i] = i-1;
	    boolean[][] isPalindrome = getIsPalindrome(s);
	    for(int i = 1; i <= s.length(); i++){
		    for(int j = 0; j < i; j++){
			    if(isPalindrome[j][i-1])
				    f[i] = Math.min(f[i], f[j]+1);
		    }
	    }
	    return f[s.length()];
    }
}
