import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q126_Word_Ladder_II {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);
 
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
        dfs(ladders, path, end, start, distance, map);

        return ladders;
    }

	void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }
	
    void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
        path.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }

    List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
	
	
	
	
	/**************************************************************/
	// by other
	public ArrayList<ArrayList<String>> findLadders2(String beginWord, String endWord, Set<String> wordList) {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		int level = 0;
		boolean found = false; // flag used to stop searching for the next level
		Queue<TreeNode> q = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>(); // map records visited node and its level
		q.offer(new TreeNode(beginWord, null)); // beginWord is the root of
												// tree, no parent
		map.put(beginWord, 0);
		while (!q.isEmpty()) {
			if (found)
				return list;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				String word = node.val;
				if (word.equals(endWord)) {
					found = true;   // mark true so it will go on searching until
									// the end of current level, so all paths
									// are of the same length.
					ArrayList<String> ladder = new ArrayList<>();
					while (node != null) {
						ladder.add(0, node.val);
						node = node.parent;
					}
					list.add(ladder);
				} 
				else { // change character one at a time
					if(found){
						continue;
					}
					char[] wordArray = word.toCharArray();
					for (int j = 0; j < wordArray.length; j++) {
						char c = wordArray[j];
						for (char k = 'a'; k <= 'z'; k++) {
							if (c != k) {
								wordArray[j] = k;
								String newWord = new String(wordArray);
								// if a visited node is at lower level, it won't
								// be added again. Duplicate is allowed ONLY at
								// same level
								if (wordList.contains(newWord) && (!map.containsKey(newWord) || map.get(newWord) == level)) {
									map.put(newWord, level);
									TreeNode child = new TreeNode(newWord, node);
									q.offer(child);
								}
							}
						}
						wordArray[j] = c;   // change it back before modifying next char
					}
				}
			}
			level++;
		}
		return list;// empty list
	}

	private class TreeNode {
		public String val;
		public TreeNode parent;

		public TreeNode(String v, TreeNode p) {
			val = v;
			parent = p;
		}
	}

	/**************************************************************/
	// by Jackie, but exceed time limited
	private LinkedList<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
	private LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
	private int minStep = Integer.MAX_VALUE;

	public LinkedList<LinkedList<String>> findLadders3(String beginWord,
			String endWord, Set<String> wordList) {
		LinkedList<String> path = new LinkedList<String>();
		wordList.add(endWord);
		dfs(beginWord, path, wordList, 1, endWord);
		for (int i = 0; i < res.size(); ++i)
			if (res.get(i).size() == minStep)
				result.add(res.get(i));
		return res;
	}

	public void dfs(String str, LinkedList<String> path, Set<String> wordList,
			int step, String endWord) {
		if (step >= minStep)
			return;
		path.add(str);
		char[] array = str.toCharArray();
		for (int i = 0, len = array.length; i < len; ++i) {
			for (char j = 'a'; j <= 'z'; ++j) {
				char temp = array[i];
				if (array[i] == j)
					continue;
				array[i] = j;
				String newStr = new String(array);
				if (newStr.equals(endWord)) {
					path.add(endWord);
					res.add(new LinkedList<String>(path));
					path.remove(endWord);
					array[i] = temp;
					minStep = Math.min(minStep, step + 1);
					continue;
				}
				if (wordList.contains(newStr)) {
					wordList.remove(newStr);
					dfs(newStr, path, wordList, step + 1, endWord);
					wordList.add(newStr);
				}
				array[i] = temp;
			}
		}
		path.remove(str);
	}

	public static void main(String[] args) {
		Q126_Word_Ladder_II t = new Q126_Word_Ladder_II();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		List<List<String>> res = t.findLadders("hit", "cog", wordList);
		for (int i = 0; i < res.size(); ++i) {
			for (int j = 0; j < res.get(i).size(); ++j) {
				System.out.print(res.get(i).get(j) + ", ");
			}
			System.out.println();
		}

	}
}
