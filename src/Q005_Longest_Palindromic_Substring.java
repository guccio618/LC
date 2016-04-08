
public class Q005_Longest_Palindromic_Substring {
	/******************************************************************
	Given a string S, find the longest palindromic substring in S. 
	You may assume that the maximum length of S is 1000, 
	and there exists one unique longest palindromic substring.
	******************************************************************/
	
	//by other using string operation
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){ 
        	return s;
        }
        int n = s.length();
        int min_start = 0;
        int max_len = 1;
        char[] array = s.toCharArray();
        
        for (int i = 0; i < n;) {
            if (n - i <= max_len / 2){
            	break;
            }
            int front = i, back = i;
            while (back < n-1 && array[back + 1] == array[back]) {  // Skip duplicate characters. 
                ++back; 
            }
            i = back + 1;
            while (back < n-1 && front > 0 && array[back + 1] == array[front - 1]) {  // Expand.
                ++back;
                --front;
            } 
            if ( (back-front+1) > max_len ){
                min_start = front;
                max_len = (back-front+1);
            }
        }
        
        return s.substring(min_start, min_start + max_len);
    }
		
	
	//by Jackie using DP
	public String longestPalindrome2(String s) {
		if(s == null || s.length() <= 1){
            return s;
        }
        
        char[] array = s.toCharArray();
        int maxLen = 1;
        int pos = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        
        for(int i = 1; i < len; ++i){
            dp[i - 1][i] = (array[i - 1] == array[i]);
            if(dp[i - 1][i] == true){
                maxLen = 2;
                pos = i - 1;
            }
        }
        
        for(int length = 2; length < len; ++length){
            for(int start = 0; start + length < len; ++start){
                dp[start][start + length] = dp[start + 1][start + length - 1] && ( array[start] == array[start + length] );
                if(dp[start][start + length] == true && maxLen <= length + 1){
                    maxLen = length + 1;
                    pos = start;
                }
            }
        }
        
        return s.substring(pos, pos + maxLen);
    }
	
	
	
	
	public static void main(String[] args){
		Q005_Longest_Palindromic_Substring test = new Q005_Longest_Palindromic_Substring();
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(test.longestPalindrome(s));
	}
}
