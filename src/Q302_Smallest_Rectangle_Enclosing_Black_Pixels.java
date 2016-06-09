
public class Q302_Smallest_Rectangle_Enclosing_Black_Pixels {
	// by other using binary search, O(n * lgm + m * lgn)
	private char[][] image;
	public int minArea(char[][] iImage, int x, int y) {
	    image = iImage;
	    int m = image.length, n = image[0].length;
	    int left = searchColumns(0, y, 0, m, true);
	    int right = searchColumns(y + 1, n, 0, m, false);
	    int top = searchRows(0, x, left, right, true);
	    int bottom = searchRows(x + 1, m, left, right, false);
	    return (right - left) * (bottom - top);
	}
	private int searchColumns(int i, int j, int top, int bottom, boolean opt) {
	    while (i != j) {
	        int k = top, mid = (i + j) / 2;
	        while (k < bottom && image[k][mid] == '0') ++k;
	        if (k < bottom == opt)
	            j = mid;
	        else
	            i = mid + 1;        // 注意这里需要＋1 !!!
	    }
	    return i;
	}
	private int searchRows(int i, int j, int left, int right, boolean opt) {
	    while (i != j) {
	        int k = left, mid = (i + j) / 2;
	        while (k < right && image[mid][k] == '0') ++k;
	        if (k < right == opt)
	            j = mid;
	        else
	            i = mid + 1;        // 注意这里需要＋1 !!!
	    }
	    return i;
	}
	
	
	
	/*****************************************************************/
	// by Jackie using DFS, but exceed time limit
	private int left = 0, right = 0, up = 0, down = 0;
    
    public int minArea2(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }
        
        int row = image.length, col = image[0].length;
        left = right = y;
        up = down = x;
        boolean[][] visited = new boolean[row][col];
        
        traver(image, visited, x, y);
        return (right - left + 1) * (up - down + 1);
    }
    
    public void traver(char[][] image, boolean[][] visited, int x, int y){
        if(visited[x][y] == true){
            return;
        }
        
        visited[x][y] = true;
        left = Math.min(left, y);
        right = Math.max(right, y);
        up = Math.max(up, x);
        down = Math.min(down, x);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == '1'){
                traver(image, visited, newX, newY);
            }
        }
    }
}
