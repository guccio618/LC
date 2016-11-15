import java.util.*;

public class Q417_Pacific_Atlantic_Water_Flow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> ans = new ArrayList<>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ans;
		}

		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visitedAtlantic = new boolean[row][col];
		boolean[][] visitedPacific = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			canFlow(matrix, visitedPacific, 0, i, 0);
			canFlow(matrix, visitedAtlantic, 0, i, col - 1);
		}

		for (int j = 0; j < col; j++) {
			canFlow(matrix, visitedPacific, 0, 0, j);
			canFlow(matrix, visitedAtlantic, 0, row - 1, j);
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (visitedAtlantic[i][j] && visitedPacific[i][j]) {
					ans.add(new int[] {i, j});
				}
			}
		}

		return ans;
	}

	public void canFlow(int[][] matrix, boolean[][] visited, int height, int x,
			int y) {
		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
				|| visited[x][y] || matrix[x][y] < height) {
			return;
		}

		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		visited[x][y] = true;

		for (int i = 0; i < dx.length; i++) {
			canFlow(matrix, visited, matrix[x][y], x + dx[i], y + dy[i]);
		}
	}

	public void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 },
				{ 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };

		// int[][] matrix = {
		// {1,2,3},
		// {8,9,4},
		// {7,6,5}
		// };

		Q417_Pacific_Atlantic_Water_Flow t = new Q417_Pacific_Atlantic_Water_Flow();
		List<int[]> ans = t.pacificAtlantic(matrix);

		for (int[] array : ans) {
			System.out.println(array[0] + ", " + array[1]);
		}
	}
}
