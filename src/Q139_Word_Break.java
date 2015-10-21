import java.util.HashSet;
import java.util.Set;


public class Q139_Word_Break {
	// by ninechapter
	public int getMaxWordLength(Set<String> dict) {
		int maxWordLength = 0;
		for (String word : dict)
			maxWordLength = Math.max(maxWordLength, word.length());
		return maxWordLength;
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0)
			return true;
		int maxWordLength = getMaxWordLength(wordDict);
		boolean[] canSplit = new boolean[s.length() + 1];
		canSplit[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			canSplit[i] = false;
			for (int lastWordLength = 1; lastWordLength <= maxWordLength
					&& lastWordLength <= i; lastWordLength++) {
				if (!canSplit[i - lastWordLength])
					continue;
				String word = s.substring(i - lastWordLength, i);
				if (wordDict.contains(word)) {
					canSplit[i] = true;
					break;
				}
			}
		}
		return canSplit[s.length()];
	}

	public static void main(String[] args) {
		Q139_Word_Break t = new Q139_Word_Break();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("a");
		String s = "a";
		System.out.println(t.wordBreak(s, wordDict));

	}
}
