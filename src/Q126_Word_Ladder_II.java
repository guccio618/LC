import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q126_Word_Ladder_II {
	/**************************************************************/
	// by other
	public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		int level = 0;
		boolean found = false; // flag used to stop searching for the next level
		Queue<TreeNode> q = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>(); // map records visited node
													// and its level
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
								if (wordList.contains(newWord)
										&& (!map.containsKey(newWord) || map
												.get(newWord) == level)) {
									map.put(newWord, level);
									TreeNode child = new TreeNode(newWord, node);
									q.offer(child);
								}
							}
						}
						wordArray[j] = c;   // change it back before modifying next
											// char
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

	public LinkedList<LinkedList<String>> findLadders2(String beginWord,
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
		ArrayList<ArrayList<String>> res = t
				.findLadders("hit", "cog", wordList);
		for (int i = 0; i < res.size(); ++i) {
			for (int j = 0; j < res.get(i).size(); ++j) {
				System.out.print(res.get(i).get(j) + ", ");
			}
			System.out.println();
		}

	}
}
