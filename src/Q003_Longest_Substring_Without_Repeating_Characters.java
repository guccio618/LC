import java.util.HashMap;


public class Q003_Longest_Substring_Without_Repeating_Characters {
	// by other, very fast
	public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int max = 1, ptr = 0;
        
        for(int i = 0, len = s.length(); i < len; ++i){
            int index = s.indexOf(s.charAt(i), ptr);
            if(index < i){
                ptr = index+1;
            }
            max = Math.max(max, i-ptr+1);
        }
        return max;
    }
	
	//by other
	public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int first = 0, res = 0;  // first表示不重复substring的第一个字符位置
        int[] chars = new int[256];

        for (int i = 0; i < 256; ++i)
            chars[i] = -1;
        for (int i = 0; i < n; ++i){
            if (chars[(int)s.charAt(i)] >= first) 
                first = chars[(int)s.charAt(i)] + 1;  // 字符与之前的表示发生了重复
            chars[(int)s.charAt(i)] = i;
            res = (i - first + 1) > res ? (i - first + 1) : res;
        }
        return res;
    }
	
	//by jackie but time limit exceeded
	public int lengthOfLongestSubstring3(String s) {
		if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        HashMap myMap = new HashMap<Character, Integer>();
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            if(!myMap.containsKey(s.charAt(i))){
                myMap.put(s.charAt(i), i);
                count++;
            }
            else{
            	i = (int) myMap.get(s.charAt(i)) + 1;
                myMap.clear();                   // 从之前重复的地方＋1重新开始
                myMap.put(s.charAt(i), i);
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
	
	public static void main(String[] args){
		String s = "dvdfdsffgrtujrerxgsdf";
		Q003_Longest_Substring_Without_Repeating_Characters test = new Q003_Longest_Substring_Without_Repeating_Characters();
		System.out.println(test.lengthOfLongestSubstring(s));
		System.out.println(test.lengthOfLongestSubstring2(s));
	}
}
