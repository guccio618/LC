
public class Q074_Searcha_2D_Matrix {
	// by Jackie
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int left = 0, right = getId(row - 1, col - 1, col);
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            
            int x = mid / col;
            int y = mid % col;
            
            if(matrix[x][y] > target){
                right = mid;
            } else if(matrix[x][y] < target){
                left = mid;
            } else {
                return true;
            }
        }
        
        int x1 = left / col;
        int y1 = left % col;
        int x2 = right / col;
        int y2 = right % col;
        
        if(matrix[x1][y1] == target || matrix[x2][y2] == target){
            return true; 
        } else {
            return false;
        }
    }
	
	public int getId(int x, int y, int col){
        return x * col + y;
    }
	
	
	
	public static void main(String[] args){
		Q074_Searcha_2D_Matrix t = new Q074_Searcha_2D_Matrix();
		int[][] matrix = {
				{-10,-10},
				{-9,-9},
				{-8,-6},
				{-4,-2},
				{0,1},
				{3,3},
				{5,5},
				{6,8}
		};
//		int[][] matrix = {{1, 3}};
		System.out.println(t.searchMatrix(matrix, -7));
	}
}
