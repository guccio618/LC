
public class Q304_Range_Sum_Query_2D_Immutable {
	/***********************************************************/
	// by Jackie using DP
	private long[][] sum;
    public Q304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        sum = new long[matrix.length][matrix[0].length]; 
        sum[0][0] = matrix[0][0];
        for(int i = 1; i < matrix[0].length; ++i)
            sum[0][i] = sum[0][i-1] + matrix[0][i];
        for(int i = 1; i < matrix.length; ++i)
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        
        for(int i = 1; i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }       
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0) return 0;
    	int P1 = (int) sum[row2][col2];
    	int P2 = (row1 == 0) ? 0 : (int) sum[row1-1][col2];
    	int P3 = (col1 == 0) ? 0 : (int) sum[row2][col1-1];
    	int P4 = 0;
    	if(row1 > 0 && col1 > 0) P4 = (int) sum[row1-1][col1-1];
        return (int) (P1 - P2 - P3 + P4);
    }
    
    
    public static void main(String[] args){
    	int[][] matrix = {
    	                  {3, 0, 1, 4, 2},
    	                  {5, 6, 3, 2, 1},
    	                  {1, 2, 0, 1, 5},
    	                  {4, 1, 0, 1, 7},
    	                  {1, 0, 3, 0, 5}
    	};
    	Q304_Range_Sum_Query_2D_Immutable t = new Q304_Range_Sum_Query_2D_Immutable(matrix);
    	System.out.println(t.sumRegion(2, 1, 4, 3));
    	System.out.println(t.sumRegion(1, 1, 2, 2));
    	System.out.println(t.sumRegion(1, 2, 2, 4));  	
    }
}
