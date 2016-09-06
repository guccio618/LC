import java.util.Arrays;

public class Q329_Longest_Increasing_Path_in_a_Matrix {
	// by Jackie
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int[][] memo = new int[row][col];
        int maxLen = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                maxLen = Math.max(maxLen, memoSearch(matrix, memo, i, j));
            }
        }
        
        return maxLen;
    }
    
    public int memoSearch(int[][] matrix, int[][] memo, int x, int y){
        if(memo[x][y] > 0){
            return memo[x][y];
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int row = matrix.length;
        int col = matrix[0].length;
        memo[x][y] = 1;
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[x][y] > matrix[newX][newY]){
                memo[x][y] = Math.max(memo[x][y], memoSearch(matrix, memo, newX, newY) + 1);
            }
        }
        
        return memo[x][y];
    }
	
	/**************************************************************/
	// by other
	int[][] dis = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] state = new int[matrix.length][matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, dfs(i, j, matrix, state));
			}
		}
		return res;
	}

	public int dfs(int i, int j, int[][] matrix, int[][] state) {
		if (state[i][j] > 0) {
			return state[i][j];
		}
		
		int max = 0;
		for (int m = 0; m < dis.length; m++) {
			if (i + dis[m][0] >= 0 && i + dis[m][0] < matrix.length
					&& j + dis[m][1] >= 0 && j + dis[m][1] < matrix[0].length
					&& matrix[i + dis[m][0]][j + dis[m][1]] > matrix[i][j]) {
				max = Math.max(max,
						dfs(i + dis[m][0], j + dis[m][1], matrix, state));
			}
		}
		state[i][j] = 1 + max;
		return state[i][j];

	}
}
