
public class Q221_Maximal_Square {
	/*******************************************************************
	Given a 2D binary matrix filled with 0's and 1's, 
	find the largest square containing all 1's and return its area.
	 *******************************************************************/
	
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[2][col];
        int maxLen = 0;
        
        for(int j = 0; j < col; ++j){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                maxLen = 1;
            }
        }
        
        for(int i = 1; i < row; ++i){
            if(matrix[i][0] == '1'){
                dp[i % 2][0] = 1;
                maxLen = Math.max(maxLen, 1);
            } else {
            	dp[i % 2][0] = 0;
            }
            
            for(int j = 1; j < col; ++j){
                if(matrix[i][j] == '1'){
                    dp[i %  2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i % 2][j]);
                } else {
                	dp[i % 2][j] = 0;
                }              
            }
        }
        
        return maxLen * maxLen;
    }
	
	
	//by ninechapter
	public int maximalSquare2(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxLen = 0;
        
        for(int i = 0; i < row; ++i){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxLen = 1;
            }
        }
        
        for(int j = 0; j < col; ++j){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                maxLen = 1;
            }
        }
        
        for(int i = 1; i < row; ++i){
            for(int j = 1; j < col; ++j){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[(i - 1)][j - 1], Math.min(dp[(i - 1)][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
//                    System.out.println("2: max = " + maxLen);
                } 
            }
        }
        
        return maxLen * maxLen;
    }
	
	
	
	
	
	/********************************************************************/
	// follow up by Jackie, 查找最大的对角矩阵面积
	
	public int maximalSquareFollowUp(char[][] matrix){
		if(matrix == null || matrix[0] == null){
			return 0;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[2][col];
		int[][] up = new int[row][col];
		int[][] down = new int[row][col];
		int maxLen = 0;
		
		for(int i = 0; i < row; ++i){
			if(matrix[i][0] == '1'){
				dp[i][0] = 1;
				maxLen = 1;
			} else{
				up[i][0] = 1;
				down[i][0] = 1;
				
			}
		}
		
		for(int i = 0; i < col; ++i){
			if(matrix[0][i] == '1'){
				dp[0][i] = 1;
				maxLen = 1;
			} else{
				up[0][i] = 1;
				down[0][i] = 1;
			}
		}
		
		for(int i = 1; i < row; ++i){
			for(int j = 1; j < col; ++j){
				if(matrix[i][j] == '0'){
					up[i][j] = up[i - 1][j] + 1;
					down[i][j] = up[i][j - 1] + 1;
				}
			}
		}
		
		for(int i = 1; i < row; ++i){
			for(int j = 1; j < col; ++j){
				if(matrix[i][j] == '1'){
					dp[i % 2][j] = Math.min(dp[(i - 1) % 2][i - 1], Math.min(up[i - 1][j], down[i][j - 1])) + 1;
					maxLen = Math.max(maxLen, dp[i % 2][j]);
				}
			}
		}
		
		return maxLen * maxLen;
	}
	
	public static void main(String[] args){
		Q221_Maximal_Square test = new Q221_Maximal_Square();
		char[][] array = {
				{'1','1','1','1','1','1','1','1'},
				{'1','1','1','1','1','1','1','0'},
				{'1','1','1','1','1','1','1','0'},
				{'0','1','1','1','1','0','0','0'},
				{'0','1','1','1','1','0','0','0'}
		};
		char[][] array1 = {
				{'1','0','1','1','0','1'},
				{'1','1','1','1','1','1'},
				{'0','1','1','0','1','1'},
				{'1','1','1','0','1','0'},
				{'0','1','1','1','1','1'},
				{'1','1','0','1','1','1'}
		};
		char[][] array2 = {
				{'1', '0', '0', '0'},
				{'0', '1', '0', '0'},
				{'0', '0', '1', '0'},
				{'0', '0', '0', '1'}
		};
		char[][] array3 = {
				{'1'}
		};		
		char[][] array4 = {
				{'1', '0'},
				{'0', '1'},
		};
		char[][] array5 = {
				{'1', '0', '0'},
				{'0', '1', '0'},
				{'0', '0', '1'}
		};
		System.out.println(test.maximalSquare(array1));	
		System.out.println(test.maximalSquare2(array1));	
		System.out.println(test.maximalSquareFollowUp(array3));
	}
}
