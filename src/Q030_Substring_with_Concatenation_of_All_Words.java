import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Q030_Substring_with_Concatenation_of_All_Words {
	/***************************************************************/
	// by other, faster
	public List<Integer> findSubstring(String s, String[] words) {
        /**
         * Let n=s.length, k=words[0].length traverse s with indices i, i+k,
         * i+2k, ... for 0<=i<k, so that the time complexity is O(n).
         */
		List<Integer> ans = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words.length == 0 ||words[0].length() == 0){
            return ans;
        }

        HashMap<String, Integer> wordDict = new HashMap<String, Integer>();
        HashMap<String, Integer> curDict = new HashMap<String, Integer>();
        int wordLen = words[0].length();
        int wordNum = words.length;
        int wordListLen = wordLen * wordNum;
        int start = 0;
        int sLen = s.length();

        for (String word : words) {
            if (wordDict.containsKey(word)){
                wordDict.put(word, wordDict.get(word) + 1);
            } else {
                wordDict.put(word, 1);
            }
        }
        
        for(int i = 0; i < wordLen; i++){
            curDict.clear();
            start = i;
            
            if(start + wordListLen > sLen){
                return ans;
            }
            
            for(int currentPos = i; currentPos + wordLen <= sLen; currentPos += wordLen){
                String testWord = s.substring(currentPos, currentPos + wordLen);
                String temp = "";
                
                if(wordDict.containsKey(testWord)){
                    if(!curDict.containsKey(testWord)){
                        curDict.put(testWord, 1);
                        start = checkFound(ans, start, wordListLen, currentPos, wordLen, curDict, s);
                    } else {    // wordDict中的重复词未出现完全
                        int count = curDict.get(testWord);
                        if(count < wordDict.get(testWord)){
                            curDict.put(testWord, count + 1);
                            start = checkFound(ans, start, wordListLen, currentPos, wordLen, curDict, s);
                        } else {   // curDict.get(test) == wDict.get(test), slide start to the next word of the first same word as test
                            while(!(temp = s.substring(start, start + wordLen)).equals(testWord)){
                                decreaseCount(curDict, temp);
                                start += wordLen;
                            }
                            
                            start += wordLen;
                            if(start + wordLen > sLen){
                                break;
                            }
                        }
                    }
                } else{    // totally failed up, slide start and reset all
                    start = currentPos + wordLen;
                    if(start + wordListLen > sLen){
                        break;
                    }
                    curDict.clear();
                } 
            }
        }
        
        return ans;
    }

    public int checkFound(List<Integer> res, int start, int wholeWordsLen, int curPos, int wordLen, HashMap<String, Integer> curDict, String s) {
        if (start + wholeWordsLen == curPos + wordLen) {   // 检测到最后一个单词时
            res.add(start);
            // slide start to the next word
            decreaseCount(curDict, s.substring(start, start + wordLen));
            return start + wordLen;
        }
        return start;
    }

    public void decreaseCount(HashMap<String, Integer> curDict, String key) {
        // remove key if curDict.get(key)==1, otherwise decrease it by 1
        int x = curDict.get(key);
        if (x == 1)
            curDict.remove(key);
        else
            curDict.put(key, x - 1);
    }
	
	
	/***************************************************************/
	// by other, but a little bit slow
	public List<Integer> findSubstring2(String s, String[] words) {
	    List<Integer> res = new LinkedList<Integer>();
	    if(s == null || s.length() == 0 || words == null ||words.length == 0)
	        return res;

	    int wlen = words[0].length();
	    int len = words.length * wlen;

	    HashMap<String, Integer> hm = new HashMap<String, Integer>();
	    for(int j = 0; j < words.length; j++){
	        if(hm.containsKey(words[j])){
	            hm.put(words[j], hm.get(words[j]) + 1);
	        }else{
	            hm.put(words[j], 1);
	        }
	    } 

	    for(int i = 0; i <= s.length() - len; i++){
	        if(isConcat(s.substring(i, i + len), hm , wlen)){
	            res.add(i);
	        }
	    }
	    return res;
	}

	private boolean isConcat(String s, HashMap<String, Integer> hm, int wlen){
	    HashMap<String, Integer> curHm = new HashMap<String, Integer>();
	    for(int i = 0; i <= s.length() - wlen; i = i + wlen){
	        String tmpStr = s.substring(i, i + wlen);
	        if(!hm.containsKey(tmpStr)) return false;
	        if(!curHm.containsKey(tmpStr)){
	            curHm.put(tmpStr, 1);
	        }
	        else{
	            if(curHm.get(tmpStr) + 1 > hm.get(tmpStr)) return false;
	            curHm.put(tmpStr, curHm.get(tmpStr) + 1);
	        }
	    }
	    return true;
	}
	
	
	

	
	
	public static void main(String[] args){
		Q030_Substring_with_Concatenation_of_All_Words t = new Q030_Substring_with_Concatenation_of_All_Words();
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		List<Integer> res = t.findSubstring(s, words);
		
		for(int i : res){
			System.out.print(i + ", ");
		}
	}
}
