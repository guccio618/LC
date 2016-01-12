import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q140_Word_Break_II {
	/********************************************************/
	// by other using memorizing space
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> result = new LinkedList<String>();
		if (s == null || s.length() == 0 || wordDict.size() == 0)
			return result;
		return getBreaks(s, wordDict, 0, new List[s.length()]);
	}

	public List<String> getBreaks(String s, Set<String> wordDict, int pos,
			List<String>[] memo) {
		List<String> result = new LinkedList<String>();
		if (pos == s.length()) {
			result.add("");
			return result;
		}
		for (int index = pos, len = s.length(); index < len; ++index) {
			String curStr = s.substring(pos, index + 1);
			if (wordDict.contains(curStr)) {
				if (memo[index] == null) {
					memo[index] = getBreaks(s, wordDict, index + 1, memo);
				}
				for (String str : memo[index]) {
					if (!str.equals(""))
						result.add(curStr + " " + str);
					else
						result.add(curStr);
				}
			}
		}
		return result;
	}

	/********************************************************/
	// by other using DP+DFS
	private List<String> result;

	public List<String> wordBreak2(String s, Set<String> wordDict) {
		result = new ArrayList<String>();
		int n = s.length();
		List<Integer>[] pointer = new List[n];
		for (int i = 0; i < n; i++)
			pointer[i] = new ArrayList<Integer>();
		// DP to record break point
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (wordDict.contains(s.substring(j, i + 1))
						&& (j == 0 || pointer[j - 1].size() > 0))
					pointer[i].add(j);
			}
		}
		helper(pointer, s, n - 1, "");
		return result;
	}

	// DFS to retrieve results
	public void helper(List<Integer>[] pointer, String s, int i, String pattern) {
		if (i < 0) {
			result.add(pattern);
			return;
		}
		for (Integer item : pointer[i]) {
			String nextPattern = pattern.length() == 0 ? s.substring(item,
					i + 1) : s.substring(item, i + 1) + " " + pattern;
			helper(pointer, s, item - 1, nextPattern);
		}
	}

	/********************************************************/
	public static void main(String[] args) {
		Q140_Word_Break_II t = new Q140_Word_Break_II();
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> res = t.wordBreak(s, wordDict);
		for (int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");

	}
}
