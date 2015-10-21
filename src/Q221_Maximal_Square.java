
public class Q221_Maximal_Square {
	/*******************************************************************
	Given a 2D binary matrix filled with 0's and 1's, 
	find the largest square containing all 1's and return its area.
	 *******************************************************************/
	
	//by ninechapter
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            res[i][0] = (int) (matrix[i][0] - '0');
            ans = Math.max(res[i][0] , ans);
        }
        for(int j = 1; j < m; j++){
            res[0][j] = (int) (matrix[0][j] - '0');
            ans = Math.max(res[0][j] , ans);
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if( (int) (matrix[i][j] - '0') > 0 ){
                    res[i][j] = Math.min(res[i][j-1], Math.min(res[i-1][j], res[i-1][j-1])) + 1;
                }
                else{
                    res[i][j] = 0;
                }
                ans = Math.max(ans, res[i][j]);
            }
        }
        return ans*ans;
    }
	
	public static void main(String[] args){
		Q221_Maximal_Square test = new Q221_Maximal_Square();
		char[][] array = {{'1','1'}, {'1','1'}};
		System.out.println(test.maximalSquare(array));		
	}
}
