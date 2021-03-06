import java.util.Arrays;
import java.util.HashMap;


public class Q003_Longest_Substring_Without_Repeating_Characters {
	/*****************************************/
	// by ninechapter using two pointers
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        } 
        
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int ans = 0, n = s.length(), right = 0;
        
        for(int left = 0; left <n; ++left){
            while(right < n && map[s.charAt(right)] == -1){
                map[s.charAt(right)] = 0;
                ans = Math.max(ans, right - left + 1);
                right++;
            }
            map[s.charAt(left)] = -1;
        }
        
        return ans;
    }
	
	
	
	/*****************************************/
	// by ninechapter using hashmap
	public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0){
            return s.length();
        } 
        
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        char[] array = s.toCharArray();
        int maxLen = 1;
        int prePos = 0;
        int n = s.length();
        
        for(int i = 0; i < n; ++i){
            if(!myMap.containsKey(array[i])){
                myMap.put(array[i], i);
            } else {
                int tempPos = myMap.get(array[i]);
                if(tempPos < prePos){
                    myMap.put(array[i], i);
                } else {
                    maxLen = Math.max(maxLen, i - prePos);
                    prePos = tempPos + 1;
                    myMap.put(array[i], i);
                }
            }
        }
        
        maxLen = Math.max(maxLen, n - prePos);   // 清理最后的尾巴部分，如aabc, abcde
        
        return maxLen;
    }
	
	
	
	/*****************************************/
	// by other, very fast
	public int lengthOfLongestSubstring3(String s) {
        if(s.length() <= 1) return s.length();
        int max = 1, startPos = 0;
        
        for(int i = 0, len = s.length(); i < len; ++i){
            int index = s.indexOf(s.charAt(i), startPos);
            if(index < i){
                startPos = index + 1;
            }
            max = Math.max(max, i - startPos + 1);
        }
        return max;
    }
	
	//by other
	public int lengthOfLongestSubstring4(String s) {
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
	public int lengthOfLongestSubstring5(String s) {
		if(s == null){
            return 0;
        } else if(s.length() <= 1){
            return s.length();
        }
        
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        int len = s.length();
        int startPos = 0;
        
        for(int i = 0; i < len; ++i){
            char c = s.charAt(i);
            if(myMap.containsKey(c)){
                int prePos = myMap.get(c);
                if(prePos < startPos){
                    myMap.put(s.charAt(i), i);
                    maxLen = Math.max(maxLen, i - startPos + 1);
                    continue;
                }
                startPos = prePos + 1;
            } 
            maxLen = Math.max(maxLen, i - startPos + 1);
            myMap.put(s.charAt(i), i);
        }
        
        return maxLen;
    }
	
	public static void main(String[] args){
		String s = "abb";// "dvdfdsffgrtujrerxgsdf";
		Q003_Longest_Substring_Without_Repeating_Characters test = new Q003_Longest_Substring_Without_Repeating_Characters();
		System.out.println(test.lengthOfLongestSubstring(s));
		System.out.println(test.lengthOfLongestSubstring3(s));
	}
}
