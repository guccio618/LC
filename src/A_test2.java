import java.util.*;

public class A_test2 {
	public List<String> findLadder(String beginWord, String endWord, Set<String> wordList) {
		List<String> ans = new ArrayList<String>();
		
		if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null) {
			return ans;
		}
		
		Map<String, String> map = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		wordList.add(endWord);
	    queue.offer(beginWord);
	    map.put(beginWord, "");
	    boolean found = false;
	    
	    while(!queue.isEmpty() && found == false) {
	    	int size = queue.size();

	        for(int i = 0; i < size && found == false; i++) {
	            String node = queue.poll();
	            	            
	            for(String next : expends(node, wordList)) {	           	      	
	            	if(map.containsKey(next)) {
	                    continue;
	                }
	            	
	            	map.put(next, node);
	            	
	                if(next.equals(endWord)) {	   
	                    found = true;
	                    break;
	                } else {
	                    queue.offer(next);
	                }
	            }
	            
	            System.out.println();
	        }
	    }
	    
		if(found == true) {
			String word = endWord;
			
			while(!word.equals("")) {
				ans.add(0, word);
				word = map.get(word);
			}
		}
		
		return ans;
	}
	
	public List<String> expends(String str, Set<String> wordList) {
	    List<String> list = new ArrayList<>();
	    char[] letters = str.toCharArray();

	    for(int i = 0; i < letters.length; i++) {
	        char temp = letters[i];

	        for(char c = 'a'; c <= 'z'; c++) {
	            if(c == temp) {
	                continue;
	            }

	            letters[i] = c;
	            String newWord = new String(letters);

	            if(wordList.contains(newWord)) {
	                list.add(newWord);
	            }
	        }

	        letters[i] = temp;
	    }

	    return list;
	}
	
	
	
	public static void main(String[] args) {
		A_test2 t = new A_test2();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		List<String> ans = t.findLadder("hit", "cog", wordList);
		
		for(String word : ans) {
			System.out.print(word + " ");
		}
	}
}
