
public class Q211_Add_and_Search_Word_Data_structure_design {
	// by Jackie
	private wordNode root;
    private class wordNode{
        public wordNode[] children;
        public boolean isWord;
        
        public wordNode(){
            children = new wordNode[26];
            isWord = false;
        }
    }
    
    public Q211_Add_and_Search_Word_Data_structure_design(){
        root = new wordNode();
    }
    

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word.length() == 0) return;
        char[] letters = word.toCharArray();
        int pos = 0;
        wordNode temp = root;
        
        for(int i = 0, len = letters.length; i < len; ++i){
            pos = letters[i] - 'a';
            if(temp.children[pos] == null){
                temp.children[pos] = new wordNode();
            }
            temp = temp.children[pos];
        }
        temp.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word.length() == 0) return false;
        char[] letters = word.toCharArray();
        wordNode temp = root;
        return bt(temp, letters, 0);
    }
    
    public boolean bt(wordNode node, char[] letters, int pos){
		if(pos == letters.length) return node.isWord;
		
		if(letters[pos] != '.'){
			int n = letters[pos] - 'a';
			if(node.children[n] != null)
				return bt(node.children[n], letters, pos+1);
			else
				return false;
		}
		else{
			boolean flag = false;
			for(int i = 0; i < 26; ++i){
				if(node.children[i] != null){
					flag = bt(node.children[i], letters, pos+1);
					if(flag == true)
						return true;
				}
			}
			return flag;
		}
	}
}
