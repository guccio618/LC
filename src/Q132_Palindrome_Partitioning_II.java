
public class Q132_Palindrome_Partitioning_II {
	//by ninechapter
	public boolean[][] getIsPalindrome(String s){
	    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
	    
	    for(int i = 0; i < s.length(); i++){
	    	isPalindrome[i][i] = true;
	    }
	
	    for (int i = 0; i < s.length() - 1; i++){ 
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
	    }
	    
	    for(int length = 2; length < s.length(); length++){
		    for(int start = 0; start + length < s.length(); start++){
			    isPalindrome[start][start + length] = (isPalindrome[start+1][start+length-1] && (s.charAt(start) == s.charAt(start+length)));
		    }
	    }
	    return isPalindrome;
    }

    public int minCut(String s){
	    if(s == null || s.length() == 0){
	    	return 0;
	    }
	    
	    int[] f = new int[s.length()+1];
	    boolean[][] isPalindrome = getIsPalindrome(s);
	    
	    for(int i = 0; i <= s.length(); i++){
		    f[i] = i-1;
	    }
	    
	    for(int i = 1; i <= s.length(); i++){
		    for(int j = 0; j < i; j++){
			    if(isPalindrome[j][i-1])
				    f[i] = Math.min(f[i], f[j]+1);
		    }
	    }
	    
	    return f[s.length()];
    }
    
    
    
    // by Jackie using DP, O(n^3), exceed time limit
    public int minCut2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[][] cut = new int[n][n];
        
        for(int i = 0; i < n - 1; ++i){
            cut[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 0 : 1;
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                String newStr = s.substring(start, start + length + 1);
                if(isPalindrome(newStr) == true){
                    cut[start][start + length] = 0;
                } else {
                    cut[start][start + length] = length;
                    for(int k = start; k < start + length; ++k){
                        cut[start][start + length] = Math.min(cut[start][start + length], cut[start][k] + cut[k + 1][start + length] + 1);
                    }
                }
            }
        }
        
        return cut[0][n - 1];
    }
    
    public boolean isPalindrome(String word){
        int n = word.length();
        int left = 0, right = n - 1;
        
        while(left < right){
            if(word.charAt(left) == word.charAt(right)){
                left++;
                right--;
            } else{
                break;
            }
        }
        
        return (left >= right);
    }
    
    
    public static void main(String[] args){
    	Q132_Palindrome_Partitioning_II t = new Q132_Palindrome_Partitioning_II();
    	String s = "ewewqewqeqwewqeqe";
    	System.out.println(t.minCut(s));
    	System.out.println(t.minCut2(s));
    }
}
