
public class Q028_Implement_strStr {
	public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.length() - i < needle.length()) return -1;
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i, i + needle.length()).equals(needle)) 
                    return i;
            }
        }
        return -1;
    }
	
	public static void main(String[] args){
		Q028_Implement_strStr is = new Q028_Implement_strStr();
		String str1 = "mississippi", str2 = "issi";
		System.out.println(is.strStr(str1, str2));	
	}
}
