import java.util.ArrayList;

public class Q212_Word_Search_II {
	// by other
	public class TrieNode {
        public String result;
        public TrieNode[] next = new TrieNode[26];
    }
    public ArrayList<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.next[c -'a'] == null) {
                    TrieNode newnode = new TrieNode();
                    curr.next[c - 'a'] = newnode;
                }
                curr = curr.next[c - 'a'];
            }
            curr.result = word;
        }
        int[][] visited = new int [board.length][board[0].length];
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res, visited);
            }
        }
        return res;
    }

    private void dfs (char[][] board, int i, int j, TrieNode root, ArrayList<String> res, int[][] visited){
        if (visited[i][j] == 1) return;
        char c = board[i][j];
        if (root.next[c - 'a'] == null) return;
        if (root.next[c - 'a'].result != null && !res.contains(root.next[c - 'a'].result)) {
            res.add(root.next[c - 'a'].result);
        }
        visited[i][j] = 1;
        if (i > 0) dfs(board, i - 1, j, root.next[c-'a'], res, visited);
        if (i < board.length - 1) dfs(board, i + 1, j, root.next[c-'a'], res, visited);
        if (j > 0) dfs(board, i, j - 1, root.next[c-'a'], res, visited);
        if (j < board[0].length - 1) dfs(board, i, j + 1, root.next[c-'a'], res, visited);
        visited[i][j] = 0;
    }
}
