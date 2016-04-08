import java.util.LinkedList;
import java.util.Queue;


public class Q130_Surrounded_Regions {
	// by ninechapter
	private Queue<Integer> queue = new LinkedList<Integer>();
	private char[][]board;
	private int row, col;
	
	public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0){
        	return;
        }
        
        queue = new LinkedList<Integer>();
        this.board = board;
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, col - 1);
        }

        for (int j = 1; j < col - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(row - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / col,
                y = cur % col;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'D'){
                	board[i][j] = 'O';
                }
                else if (board[i][j] == 'O'){
                	board[i][j] = 'X';
                }
            }
        }
        
        queue = null;
        board = null;
        row = 0;
        col = 0;
    }

    public void enqueue(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] == 'O'){  
            queue.offer(x * col + y);
        }
    }
	
	
	
	/****************************************************/
	// by Jackie but will cause stack overflow    
    public void solve2(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length, n = board[0].length;
        this.board = board;
        
        for(int i = 0; i < m; ++i){
            if(board[i][0] == 'O'){
                findNonSurrounded(i, 0);
            }
            if(board[i][n - 1] == 'O'){
                findNonSurrounded(i, n - 1);
            }
        }
        
        for(int j = 0; j < n; ++j){
            if(board[0][j] == 'O'){
                findNonSurrounded(0, j);
            }
            if(board[m - 1][j] == 'O'){
                findNonSurrounded(m - 1, j);
            }
        }
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'D'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void findNonSurrounded(int x, int y){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        board[x][y] = 'D';
        
        for(int i = 0; i < dx.length; ++i){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(board[newX][newY] == 'O'){
                    findNonSurrounded(newX, newY);
                }
            }
        }
    }
    
    
    public static void main(String[] args){
    	Q130_Surrounded_Regions t = new Q130_Surrounded_Regions();
    	char[][] board = {
    			{'X', 'X', 'X', 'X'},
    			{'X', 'O', 'O', 'X'},
    			{'X', 'X', 'O', 'X'},
    			{'X', 'O', 'X', 'X'}
    	};
    	
    	t.solve2(board);
    	for(int i = 0; i < board.length; ++i){
    		for(int j = 0; j < board[i].length; ++j){
    			System.out.print(board[i][j] + ", ");
    		}
    		System.out.println();
    	}
    }
}
