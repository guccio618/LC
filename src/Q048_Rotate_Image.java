public class Q048_Rotate_Image {
	/* 上下对调，然后个别处理
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0){
			return ;
		}
		
		int n = matrix.length;
		int up = 0, down = n - 1;
		int temp = 0;
		
		while (up < down) {
			for (int col = 0; col < n; ++col) {
				temp = matrix[up][col];
				matrix[up][col] = matrix[down][col];
				matrix[down][col] = temp;
			}
			
			up++;
			down--;
		}
		
		for(int row = 0; row < n; ++row){
			for(int col = row + 1; col < n; ++col){     // 注意 col = row + 1 !!!
				temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
	}
	
	/* 左右对调，然后个别处理
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
	
	public void anticlock_rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0){
			return ;
		}
		
		int n = matrix.length;
		int left = 0, right = n - 1;
		int temp = 0;
		
		while (left < right) {
			for (int row = 0; row < n; ++row) {
				temp = matrix[row][left];
				matrix[row][left] = matrix[row][right];
				matrix[row][right] = temp;
			}
			left++;
			right--;
		}
		
		for(int i = 0; i < n; ++i){
			for(int j = i + 1; j < n; ++j){
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	
	/**************************************/
	// by other, in place
	public void rotate2(int[][] matrix) {
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
	public void rotate3(int[][] matrix) {
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
