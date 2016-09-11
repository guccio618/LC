
public class Q028_Implement_strStr {
	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null){
			return -1;
		} else if(needle.length() > haystack.length()){
			return -1;
		} else if(needle.length() == 0){
		    return 0;
		}
		
		int len1 = haystack.length(), len2 = needle.length();
		char c = needle.charAt(0);
		
		for(int i = 0; i <= len1 - len2; i++){		
			if(c == haystack.charAt(i)){
				if(haystack.substring(i, i + len2).equals(needle)){
					return i;
				}
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
