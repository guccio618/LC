import java.util.*;

/*******************************************************
 * Given two words (beginWord and endWord), and a 
 * dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, 
 * such that:
 *		Only one letter can be changed at a time
 *		Each intermediate word must exist in the word list
 ********************************************************/
public class Q127_Word_Ladder {
	
	/***********************************************************/
	// by ninechapter using BFS of graph
	public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        visited.add(start);
        dict.add(end);           // 必须把end加入dict
        
        int step = 1;          // 必须从1开始
        
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();  // 设置size,相当于层序遍历
            
            for (int i = 0; i < size; i++) {
                String word = queue.poll();     
                
                for (String nextWord: findWordRange(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return step;
                    }
                    
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
	
	public ArrayList<String> findWordRange(String word, Set<String> dict){
        ArrayList<String> wordList = new ArrayList<String>();
        char[] array = word.toCharArray();
        int len = word.length();
              
        for (int i = 0; i < len; i++) {
        	char temp = array[i];      //此步非常重要，因为每次只能改变一个位置，因此改动下一个位置时，需要还原前一位
        	
            for (char k = 'a'; k <= 'z'; k++) {
                if(k == array[i]){
                    continue;
                }
                
                array[i] = k;
                String newWord = new String(array);
                if(dict.contains(newWord)){
                    wordList.add(newWord);
                }
            }
            
            array[i] = temp;         //此步非常重要，因为每次只能改变一个位置，因此改动下一个位置时，需要还原前一位
        }
        
        return wordList;
    }
	
	
	
	/***********************************************************/
	// follow up, find one path
	
	public List<String> findOneLadder(String beginWord, String endWord, Set<String> wordList) {
		List<String> ans = new ArrayList();
		
		if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
			return ans;
		} else if(beginWord.equals(endWord)) {
		    return ans;
		}
		
		wordList.add(endWord);
		Queue<String> queue = new LinkedList();
		Map<String, String> prevWordMap = new HashMap();
		queue.offer(beginWord);
		prevWordMap.put(beginWord, null);
		boolean found_flag = false;
		
		while(!queue.isEmpty() && !found_flag) {
			int size = queue.size();
			
			for(int i = 0; i < size && !found_flag; i++) {
				String curWord = queue.poll();
				
				for(String nextWord : findWordRange(curWord, wordList)) {
					if(prevWordMap.containsKey(nextWord)) {
						continue;
					}
					
					prevWordMap.put(nextWord, curWord);
					
					if(endWord.equals(nextWord)) {
						found_flag = true;
						break;
					}
					
					queue.offer(nextWord);
				}
			}
		}
		
		if(found_flag) {
			String tempWord = endWord;
			
			while(tempWord != null) {
				ans.add(0, tempWord);
				tempWord = prevWordMap.get(tempWord);
			}
		}
		
		return ans;
	}
	
	
	public static void main(String[] args){
		Q127_Word_Ladder t = new Q127_Word_Ladder();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		String beginWord = "hit";
		String endWord = "cog";	
		System.out.println(t.ladderLength(beginWord, endWord, wordList));		
		List<String> ans = t.findOneLadder(beginWord, endWord, wordList);
		
		for(String word : ans) {
			System.out.print(word + " ");
		}
	}
}
