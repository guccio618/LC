
public class Q062_Unique_Paths {
	public int uniquePaths(int m, int n) {
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
