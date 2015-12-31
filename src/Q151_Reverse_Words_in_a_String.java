
public class Q151_Reverse_Words_in_a_String {
	/******************************************************/
	// by other, faster
	public static String reverseWords(String s) {
	    StringBuilder res = new StringBuilder();
	    for (int start = s.length() - 1; start >= 0; start--) {
	        if (s.charAt(start) == ' ') continue;
	        int end = start;
	        while (start >= 0 && s.charAt(start) != ' ') start--;
	        res.append(s.substring(start + 1, end + 1)).append(" ");
	    }
	    return res.toString().trim();
	}
	
	/******************************************************/
	// by Jackie
	public String reverseWords2(String s) {
        if(s == null || s.length() == 0) return s;  
        StringBuffer sb = new StringBuffer();
        String[] strArray = s.split("\\s{1,}");
        if(strArray.length != 0){
        	for(int len = strArray.length-1, i = len; i >= 0; --i){
        		sb.append(strArray[i]).append(" ");
        	}
        }
        return sb.toString().trim();
    }
	
	
	public static void main(String[] args){
		Q151_Reverse_Words_in_a_String t = new Q151_Reverse_Words_in_a_String();
		System.out.print("*");
		System.out.print(t.reverseWords(" a b "));
		System.out.print("*");
	}
}
