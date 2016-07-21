
public class Q361_Bomb_Enemy {
	// by Jackie using DP
	public int maxKilledEnemies(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo_up = new int[row][col];
        int[][] memo_down = new int[row][col];
        int[][] memo_left = new int[row][col];
        int[][] memo_right = new int[row][col];
        int ans = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 'W'){
                    memo_up[i][j] = memo_left[i][j] = 0;
                } else if(grid[i][j] == 'E') {
                	if(i > 0){
                		memo_up[i][j] = memo_up[i - 1][j] + 1;
                	} else {
                		memo_up[i][j] = 1;
                	}
                	if(j > 0){
                		memo_left[i][j] = memo_left[i][j - 1] + 1;
                	} else {
                		memo_left[i][j] = 1;
                	}                    
                } else {
                	if(i > 0){
                		memo_up[i][j] = memo_up[i - 1][j];
                	} else {
                		memo_up[i][j] = 0;
                	}
                	if(j > 0){
                		memo_left[i][j] = memo_left[i][j - 1];
                	} else {
                		memo_left[i][j] = 0;
                	}   
                }
            }
        }
        
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(grid[i][j] == 'W'){
                    memo_down[i][j] = memo_right[i][j] = 0;
                } else if(grid[i][j] == 'E') {
                	if(i == row - 1){
                		memo_down[i][j] = 1;
                	} else {
                		memo_down[i][j] = memo_down[i + 1][j] + 1;
                	}
                	if(j == col - 1){
                		memo_right[i][j] = 1;
                	} else {
                		memo_right[i][j] = memo_right[i][j + 1] + 1;
                	}                  
                } else {
                	if(i == row - 1){
                		memo_down[i][j] = 0;
                	} else {
                		memo_down[i][j] = memo_down[i + 1][j];
                	}
                	if(j == col - 1){
                		memo_right[i][j] = 0;
                	} else {
                		memo_right[i][j] = memo_right[i][j + 1];
                	}
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '0'){
                    ans = Math.max(ans, memo_up[i][j] + memo_down[i][j] + memo_left[i][j] + memo_right[i][j]);
                }       
            }
        }
        
        return ans;
    }
	
	
	
	public static void main(String[] args){
		Q361_Bomb_Enemy t = new Q361_Bomb_Enemy();
		char[][] grid = {
//				{'0','E','0','0'},
//				{'E','0','W','E'},
//				{'0','E','0','0'},
				{'0', 'E'}
		};
		
		System.out.println(t.maxKilledEnemies(grid));
		
	}
}
