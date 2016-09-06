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
	// by other using DFS, BFS
	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> ans = new ArrayList<List<String>>();

		if (beginWord == null || endWord == null || wordList == null
				|| wordList.size() == 0) {
			return ans;
		}

		Map<String, List<String>> prevMap = new HashMap<String, List<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		List<String> path = new ArrayList<String>();

		BFS(prevMap, distance, beginWord, wordList);
		DFS(prevMap, distance, path, ans, beginWord, endWord);
		return ans;
	}

	public void BFS(Map<String, List<String>> prevMap,
			Map<String, Integer> distance, String beginWord,
			Set<String> wordList) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);

		for (String word : wordList) {
			prevMap.put(word, new ArrayList<String>());
		}

		distance.put(beginWord, 0);

		while (!queue.isEmpty()) {
			String word = queue.poll();

			for (String newWord : Expends(word, wordList)) {
				prevMap.get(newWord).add(word);

				if (!distance.containsKey(newWord)) {
					distance.put(newWord, distance.get(word) + 1);
					queue.offer(newWord);
				}
			}
		}
	}

	public List<String> Expends(String word, Set<String> wordList) {
		List<String> list = new ArrayList<String>();
		char[] letters = word.toCharArray();
		char temp = ' ';

		for (int i = 0; i < letters.length; i++) {
			temp = letters[i];

			for (char c = 'a'; c <= 'z'; c++) {
				if (c == temp) {
					continue;
				}

				letters[i] = c;
				String newWord = new String(letters);

				if (wordList.contains(newWord)) {
					list.add(newWord);
				}
			}

			letters[i] = temp;
		}

		return list;
	}

	public void DFS(Map<String, List<String>> prevMap,
			Map<String, Integer> distance, List<String> path,
			List<List<String>> ans, String beginWord, String curWord) {
		path.add(curWord);

		if (curWord.equals(beginWord)) {
			Collections.reverse(path);
			ans.add(new ArrayList<String>(path));
			Collections.reverse(path);
		} else {
			for (String prevWord : prevMap.get(curWord)) {
				if (distance.containsKey(prevWord)
						&& distance.get(prevWord) + 1 == distance.get(curWord)) {
					DFS(prevMap, distance, path, ans, beginWord, prevWord);
				}
			}
		}

		path.remove(path.size() - 1);
	}

	/**************************************************************/
	// by other
	public ArrayList<ArrayList<String>> findLadders2(String beginWord,
			String endWord, Set<String> wordList) {
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
					found = true; // mark true so it will go on searching until
									// the end of current level, so all paths
									// are of the same length.
					ArrayList<String> ladder = new ArrayList<>();
					while (node != null) {
						ladder.add(0, node.val);
						node = node.parent;
					}
					list.add(ladder);
				} else { // change character one at a time
					if (found) {
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
								if (wordList.contains(newWord)
										&& (!map.containsKey(newWord) || map
												.get(newWord) == level)) {
									map.put(newWord, level);
									TreeNode child = new TreeNode(newWord, node);
									q.offer(child);
								}
							}
						}
						wordArray[j] = c; // change it back before modifying
											// next char
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
