
public class Q062_Unique_Paths {
	// by Jackie, 滚动数组空间优化 space O(n)
	public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        
        int[][] dp = new int[2][n];
        for(int i = 0; i < 2; ++i){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; ++i){
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }
        
        return dp[(m - 1) % 2][n - 1];
	}
	
	// by Jackie, space O(n^2)
	public int uniquePaths2(int m, int n) {
        if(m == 0 && n == 0) return 0;
        if(m < 0 || n < 0) return 0;
        int[][] f = new int[m][n];
        for(int j = 0; j < n; j++)
            f[0][j] = 1;
        for(int i = 0; i < m; i++)
            f[i][0] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}
