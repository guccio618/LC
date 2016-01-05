import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Q030_Substring_with_Concatenation_of_All_Words {
	/***************************************************************/
	// by other, faster
	public List<Integer> findSubstring(String s, String[] words) {
        /**
         * Let n=s.length, k=words[0].length traverse s with indices i, i+k,
         * i+2k, ... for 0<=i<k, so that the time complexity is O(n).
         */
        List<Integer> res = new ArrayList<Integer>();
        int strLen = s.length(), wordNum = words.length, wordLen;
        if (strLen == 0 || wordNum == 0 || (wordLen = words[0].length()) == 0)
            return res;

        HashMap<String, Integer> wordDict = new HashMap<String, Integer>();

        for (String word : words) {
            if (wordDict.containsKey(word))
                wordDict.put(word, wordDict.get(word) + 1);
            else
                wordDict.put(word, 1);
        }

        int i, curPos, start, x, wordsLen = wordNum * wordLen;
        HashMap<String, Integer> curDict = new HashMap<String, Integer>();
        String test, temp;
        for (i = 0; i < wordLen; i++) {
            curDict.clear();
            start = i;
            if (start + wordsLen > strLen)
                return res;
            for (curPos = i; curPos + wordLen <= strLen; curPos += wordLen) {
                test = s.substring(curPos, curPos + wordLen);

                if (wordDict.containsKey(test)) {
                    if (!curDict.containsKey(test)) {
                        curDict.put(test, 1);
                        start = checkFound(res, start, wordsLen, curPos, wordLen, curDict, s);
                        continue;
                    }

                    x = curDict.get(test);  // curDict contains test
                    if (x < wordDict.get(test)) {  // wordDict中的重复词未出现完全
                        curDict.put(test, x + 1);
                        start = checkFound(res, start, wordsLen, curPos, wordLen, curDict, s);
                        continue;
                    }

                    // curDict.get(test) == wDict.get(test), slide start to
                    // the next word of the first same word as test
                    while (!(temp = s.substring(start, start + wordLen)).equals(test)) {
                        decreaseCount(curDict, temp);
                        start += wordLen;
                    }
                    start += wordLen;
                    if (start + wordsLen > strLen)
                        break;
                    continue;
                }

                // totally failed up to index j+k, slide start and reset all
                start = curPos + wordLen;
                if (start + wordsLen > strLen)
                    break;
                curDict.clear();
            }
        }
        return res;
    }

    public int checkFound(List<Integer> res, int start, int wordsLen, int curPos, int wordLen, HashMap<String, Integer> curDict, String s) {
        if (start + wordsLen == curPos + wordLen) {   // 检测到最后一个单词时
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
}
