
public class Q005_Longest_Palindromic_Substring {
	/******************************************************************
	Given a string S, find the longest palindromic substring in S. 
	You may assume that the maximum length of S is 1000, 
	and there exists one unique longest palindromic substring.
	******************************************************************/
	
	//by other using string operation
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        int min_start = 0;
        int max_len = 1;
        
        for (int i = 0; i < n;) {
            if (n - i <= max_len / 2) break;
            int front = i, back = i;
            while (back < n-1 && s.charAt(back+1) == s.charAt(back)) {  // Skip duplicate characters. 
                ++back; 
            }
            i = back + 1;
            while (back < n-1 && front > 0 && s.charAt(back+1) == s.charAt(front-1)) {  // Expand.
                ++back;
                --front;
            } 
            if ( (back-front+1) > max_len){
                min_start = front;
                max_len = (back-front+1);
            }
        }
        return s.substring(min_start, min_start + max_len);
    }
		
	//by other using DP, but sometimes will cause time limit exceeded
	public String longestPalindrome2(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        boolean res[][] = new boolean[n][n];
        int max = 1;
        int startPos = 0;
    
        for(int j = 0; j < n; j++){
            for(int i = j; i < n; i++)
                res[i][j] = true;
        }
            
        for(int j = 1; j < n; j++){
            for(int i = 0; i < j; i++){
                if(s.charAt(i) == s.charAt(j)){
                    res[i][j] = res[i+1][j-1];
                    if(res[i][j] == true && j - i + 1 > max){
                        max = j - i + 1;
                        startPos = i;
                    }
                }
                else
                    res[i][j] = false;
            }
        }
        return s.substring(startPos, startPos+max);
    }
	
	public static void main(String[] args){
		Q005_Longest_Palindromic_Substring test = new Q005_Longest_Palindromic_Substring();
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(test.longestPalindrome(s));
	}
}
