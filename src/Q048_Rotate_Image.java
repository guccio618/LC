public class Q048_Rotate_Image {
	/**************************************/
	// by other, in place
	public void rotate(int[][] matrix) {
		int start = 0;
		int end = matrix.length - 1;
		int temp = 0;
		while (end - start > 0) {
			for (int i = 0; i < end - start; i++) {
				temp = matrix[start][start + i];
				matrix[start][start + i] = matrix[end - i][start];
				matrix[end - i][start] = matrix[end][end - i];
				matrix[end][end - i] = matrix[start + i][end];
				matrix[start + i][end] = temp;
			}
			start++;
			end--;
		}
	}
	
	/**************************************/
	// by other, not in place, easily understand
	public void rotate2(int[][] matrix) {
		int n = matrix.length;
		int[][] rotatedMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotatedMatrix[i][j] = matrix[(n - 1) - j][i];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = rotatedMatrix[i][j];
			}
		}
	}
}
