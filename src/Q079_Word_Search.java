
public class Q079_Word_Search {
	/*************************************************************/
	// by other, faster
	public boolean exist(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	        for (int x=0; x<board[y].length; x++) {
	            if (exist(board, y, x, w, 0)) return true;
	        }
	    }
	    return false;
	}

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	    if (i == word.length) return true;
	    if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
	    if (board[y][x] != word[i]) return false;

	    board[y][x] ^= 256;      // 转化为非ascii码，超过char范围，使之无法被访问，可以代替visited, nice
	    boolean exist = exist(board, y, x+1, word, i+1)
	        || exist(board, y, x-1, word, i+1)
	        || exist(board, y+1, x, word, i+1)
	        || exist(board, y-1, x, word, i+1);
	    board[y][x] ^= 256;
	    return exist;
	}
	
	
	/*************************************************************/
	// by Jackie using backtrack;
	public boolean exist2(char[][] board, String word) {
        if(board == null || word == null) return false;
        
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        char[] letters = word.toCharArray();
        int len = word.length();
        
        for(int i = 0; i < row; ++i)
            for(int j = 0; j < column; ++j)
                if(backtrack(letters, 0, board, i, j, row, column, visited) == true)
                    return true;
        
        return false;
    }
    
    public boolean backtrack(char[] letters, int pos, char[][] board, int rowPos, int columnPos, int row, int column, boolean[][] visited){
        if(pos >= letters.length) return true;
        if(rowPos < 0 || rowPos >= row) return false;
        if(columnPos < 0 || columnPos >= column) return false;
        if(visited[rowPos][columnPos] == true) return false;
        if(letters[pos] != board[rowPos][columnPos]) return false;
        
        visited[rowPos][columnPos] = true;
        if(backtrack(letters, pos+1, board, rowPos+1, columnPos, row, column, visited)) return true;
        if(backtrack(letters, pos+1, board, rowPos-1, columnPos, row, column, visited)) return true;
        if(backtrack(letters, pos+1, board, rowPos, columnPos+1, row, column, visited)) return true;
        if(backtrack(letters, pos+1, board, rowPos, columnPos-1, row, column, visited)) return true;
        visited[rowPos][columnPos] = false;
        return false;
    }
    
    
    public static void main(String[] args){
    	Q079_Word_Search t = new Q079_Word_Search();
//    	char[][] board = {
//    						{'a','a','a','a'},
//    						{'a','a','a','a'},
//    						{'a','a','a','a'},
//    						{'a','a','a','a'},
//    						{'a','a','a','b'}    			
//    					 };
//    	System.out.println(t.exist(board, "aaaaaaaaaaaaaaaaaaaa"));
    	
    	char[][] board2 = {
    						{'A','B','C','E'},
    						{'S','F','C','S'},
    						{'A','D','E','E'}
    					  };
    	System.out.println(t.exist(board2, "ABCCED"));
    }
}
