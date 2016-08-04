
public class Q286_Walls_and_Gates {
	// by other using BFS
	public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return ;
        }
        
        int row = rooms.length;
        int col = rooms[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
            	if(rooms[i][j] == 0){
            		DFS(rooms, i, j, 0);
            	}              
            }
        }
    }
    
    public void DFS(int[][] rooms, int x, int y, int distance){
        if(rooms[x][y] < distance){
        	return ;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        rooms[x][y] = distance;
              
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[0].length){
            	DFS(rooms, newX, newY, distance + 1);
            }
        }
    }
    
    public static void main(String[] args){
    	Q286_Walls_and_Gates t = new Q286_Walls_and_Gates();
    	
    	int[][] rooms = {
    			{2147483647,-1,0,2147483647},
    			{2147483647,2147483647,2147483647,-1},
    			{2147483647,-1,2147483647,-1},
    			{0,-1,2147483647,2147483647}	
    	};
    	
    	t.wallsAndGates(rooms);
    	
    	for(int i = 0; i < rooms.length; i++){
    		for(int j = 0; j < rooms[0].length; j++){
    			System.out.print(rooms[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
