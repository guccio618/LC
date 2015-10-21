
public class Q014_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String temp_str = strs[0], res = "";
        int count = 0;
        
        for(int i = 1; i < strs.length; i++){
            count = (temp_str.length() < strs[i].length()) ? temp_str.length() : strs[i].length();
            if(count == 0) return "";
            int j = 0;
            for(; j < count; j++){
                if(temp_str.charAt(j) != strs[i].charAt(j))
                    break;
            }
            res = temp_str.substring(0, j);
            temp_str = res;
        }
        return res;
    }
    
    public static void main(String[] args){
    	Q014_Longest_Common_Prefix l = new Q014_Longest_Common_Prefix();
    	String[] array = {"a"};
    	System.out.println(l.longestCommonPrefix(array));
    }
}
