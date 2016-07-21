import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q305_Number_of_Islands_II {
	// by ninechapter using Union Find
	// time complexity is O(n^2 + k), space O(n^2)
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<Integer>();
        if(positions == null || positions.length == 0 || positions[0].length == 0){
            return ans;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] island = new int[m][n];
        int len = positions.length;
        int count = 0;
        Union_Find uf = new Union_Find(m, n);
        
        for(int i = 0; i < len; i++){
            int x = positions[i][0];
            int y = positions[i][1];
            
            if(island[x][y] == 0){
                count++;
                island[x][y] = 1;
                int id = convertToId(x, y, n);
            
                for(int j = 0; j < 4; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && island[newX][newY] == 1){
                        int newId = convertToId(newX, newY, n);
                        int fa = uf.compress_find(id);
                        int newFa = uf.compress_find(newId);
                    
                        if(fa != newFa){
                            count--;
                            uf.union(fa, newFa);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    
    class Union_Find{
        Map<Integer, Integer> father = new HashMap<Integer, Integer>();
        
        public Union_Find(int row, int col){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    int id = convertToId(i, j, col);
                    father.put(id, id);
                }
            }
        }
        
        public int compress_find(int x){
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
            int fa_x = father.get(x);
            int fa_y = father.get(y);
            
            if(fa_x != fa_y){
                father.put(fa_x, fa_y);
            }
        }
    }
    
    public int convertToId(int x, int y, int col){
        return x * col + y;
    }
}
