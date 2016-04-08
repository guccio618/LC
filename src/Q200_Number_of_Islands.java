import java.util.HashMap;


public class Q200_Number_of_Islands {
	// by ninechapter uses BFS
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int res = 0;
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1'){
                    removeHelper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    public void removeHelper(char[][] grid, int x, int y){
        grid[x][y] = '0';
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < dx.length; ++i){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {  // 边界情况已经被修改过了，不需要特别处理
                if(grid[newX][newY] == '1'){
                    removeHelper(grid, newX, newY);
                }
            }
        }
    }
    
    
    /****************************************************/
    // by Jackie using Union Find
    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        unionFind uf = new unionFind(row, col);
        int count = 0;
        int[] dx = {0, -1};
        int[] dy = {-1, 0};
        int newX = 0, newY = 0;
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '1'){
                    count++;
                    for(int k = 0; k < 2; ++k){
                        newX = i + dx[k];
                        newY = j + dy[k];
                        if(newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1'){
                            int curId = convertedtoId(i, j, col);
                            int newId = convertedtoId(newX, newY, col);
                            int curFa = uf.find(curId);
                            int newFa = uf.find(newId);
                            if(curFa != newFa){
                                uf.union(curFa, newFa);
                                count--;
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    public int convertedtoId(int x, int y, int col){
        return x * col + y;
    }
    
    class unionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        
        public unionFind(int row, int col){
            for(int i = 0; i < row; ++i){
                for(int j = 0; j < col; ++j){
                    int id = convertedtoId(i, j, col);
                    father.put(id, id);
                }
            }
        }
        
        public int find(int x){
            int parent = father.get(x);
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            return parent;
        }
        
        public int compressed_find(int x){
            int parent = father.get(x);
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            
            int tempNode = -1;
            int fa = x;
            
            while(fa != father.get(fa)){
                tempNode = father.get(fa);
                father.put(fa, parent);
                fa = tempNode;
            }
            
            return parent;
        }
        
        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX != parentY){
                father.put(parentX, parentY);
            }
        }
    }

}
