
/*******************************************************************
 *  它有三个基本性质:                                                  *
 *  	(1) 根节点不包含字符;                                          *
 *		(2) 除根节点外每一个节点都只包含一个字符;                          *
 *		(3) 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串，  *
 *			每个节点的所有子节点包含的字符都不相同。                        *
 *                                                                 *
 *******************************************************************/  

public class Q000_Data_Structure_Trie {
	private int SIZE = 26;
	private TrieNode root;       // 字典树的根

	Q000_Data_Structure_Trie() { // 初始化字典树
		root = new TrieNode();
	}
	
	/***********   字典树节点   ************/
	private class TrieNode {       
		private int num;           // 有多少单词通过这个节点,即节点字符出现的次数
		private TrieNode[] son;    // 所有的儿子节点
		private boolean isEnd;     // 是不是最后一个节点
		private char val;          // 节点存放的值

		TrieNode() {
			num = 1;
			son = new TrieNode[SIZE];
			isEnd = false;
		}
	}

	/***********   字典树应用   ************/
	// 在字典树中插入一个单词
	public void insert(String str) {   
		if (str == null || str.length() == 0) {
			return;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] == null) {
				node.son[pos] = new TrieNode();
				node.son[pos].val = letters[i];
			} else {
				node.son[pos].num++;
			}
			node = node.son[pos];
		}
		node.isEnd = true;
	}
	
	// 计算单词前缀的数量
	public int countPrefix(String prefix) { 
		if (prefix == null || prefix.length() == 0) {
			return -1;
		}
		TrieNode node = root;
		char[] letters = prefix.toCharArray();
		for (int i = 0, len = prefix.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] == null) {
				return 0;
			} else {
				node = node.son[pos];
			}
		}
		return node.num;
	}

	// 在字典树中查找一个完全匹配的单词.
	public boolean has(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] != null) {
				node = node.son[pos];
			} else {
				return false;
			}
		}
		return node.isEnd;
	}
	
	// 匹配含“..”的 regular expression
	public boolean search(String word) {
        if(word.length() == 0) return false;
        char[] letters = word.toCharArray();
        TrieNode temp = root;
        return bt(temp, letters, 0);
    }
	
	public boolean bt(TrieNode node, char[] letters, int pos){
		if(pos == letters.length) return node.isEnd;
		
		if(letters[pos] != '.'){
			int n = letters[pos] - 'a';
			if(node.son[n] != null)
				return bt(node.son[n], letters, pos+1);
			else
				return false;
		}
		else{
			boolean flag = false;
			for(int i = 0; i < 26; ++i){
				if(node.son[i] != null){
					flag = bt(node.son[i], letters, pos+1);
					if(flag == true)
						return true;
				}
			}
			return flag;
		}
	}

	// 前序遍历字典树. 递归实现
	public void preTraverse(TrieNode node) {
		if (node != null) {
			System.out.print(node.val + "-");
			for (TrieNode child : node.son) {
				preTraverse(child);
			}
		}
	}

	public TrieNode getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		Q000_Data_Structure_Trie tree = new Q000_Data_Structure_Trie();
		String[] strs = { "banana", "band", "bee", "absolute", "acm", };
		String[] prefix = { "ba", "b", "band", "abc", };
		for (String str : strs) {
			tree.insert(str);
		}
		System.out.println("acm: " + tree.has("acm"));
		System.out.println("a..: " + tree.search("a..."));
		tree.preTraverse(tree.getRoot());
		System.out.println();
		// tree.printAllWords();
		for (String pre : prefix) {
			int num = tree.countPrefix(pre);
			System.out.println(pre + " " + num);
		}

	}
}
