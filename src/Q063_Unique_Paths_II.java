public class Q063_Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] f = new int[m][n];
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 0)
				f[0][j] = 1;
			else
				break;
		}
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0)
				f[i][0] = 1;
			else
				break;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					f[i][j] = 0;
				else
					f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}
		return f[m - 1][n - 1];
	}
}
