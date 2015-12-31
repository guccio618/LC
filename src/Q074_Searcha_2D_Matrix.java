
public class Q074_Searcha_2D_Matrix {
	// by Jackie
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length-1] < target)
            return false;
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0, right = row*column-1;
        
        while(left <= right){
            int pivot = (left+right)/2;
            if(matrix[pivot/column][pivot%column] > target)
                right = pivot-1;
            else if(matrix[pivot/column][pivot%column] < target)
                left = pivot+1;
            else
                return true;
        }
        return false;
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
