import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*******************************************************
 * Given two words (beginWord and endWord), and a 
 * dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, 
 * such that:
 *		Only one letter can be changed at a time
 *		Each intermediate word must exist in the word list
 ********************************************************/
public class Q127_Word_Ladder {
	//by other using BFS of graph
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    Queue<String> queue = new LinkedList<>();
	    queue.add(beginWord);
	    wordList.add(endWord);
	    int step = 0;
	    while (!queue.isEmpty()) {
	        step++;
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            String source = queue.poll();
	            if (source.equals(endWord)) return step;
	            char[] array = source.toCharArray();
	            for (int j = 0; j < source.length(); j++) { // select one bit and change it for another
	                for (char k = 'a'; k <= 'z'; k++) {     // character from "a" to "z"
	                    char temp = array[j];               // temp is used for recording the previous value of array[j] 
	                    array[j] = k;
	                    String newStr = new String(array);
	                    if (wordList.contains(newStr)) {
	                        wordList.remove(newStr);   // means this word has been visited and should be remove from wordList
	                        queue.add(newStr);
	                    }
	                    array[j] = temp;
	                }
	            }
	        }
	    }
	    return wordList.contains(endWord) ? 0 : step;
	}
	
	public static void main(String[] args){
		Q127_Word_Ladder t = new Q127_Word_Ladder();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		System.out.println(t.ladderLength("hit", "cog", wordList));
	}
}
