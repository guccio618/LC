import java.util.LinkedList;


public class Q051_N_Queens {
	/**********************************************************************/
	// by Jackie using backtrack(recursive)
	private LinkedList<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
	
    public LinkedList<LinkedList<String>> solveNQueens(int n) {
        if(n <= 0) return res;
        int[] ways = new int[n+1];
        for(int i = 1; i <= n; ++i)
            ways[i] = 0;
        backtrack(ways, 1, n);
        return res;
    }
    
    public void backtrack(int[] ways, int curRow, int len){
        if(curRow <= len){
            for(int i = 1; i <= len; ++i){
                ways[curRow] = i;
                if(valid(ways, curRow, len))
                    backtrack(ways, curRow+1, len);
            }
        }
        else{
            LinkedList<String> path = new LinkedList<String>();
            for(int i = 1; i <= len; ++i){
                StringBuffer str = new StringBuffer();
                for(int j = 1; j <= len; ++j){
                    if(j != ways[i])
                        str.append(".");
                    else
                        str.append("Q");
                }
                path.add(str.toString());
            }
            res.add(path);
        }
    }
    
    public boolean valid(int[] ways, int curRow, int len){
        for(int i = 1; i < curRow; ++i){
            if(ways[i] == ways[curRow] || Math.abs(ways[i]-ways[curRow]) == Math.abs(i-curRow))
                return false;
        }
        return true;
    }
    
    
    public static void main(String[] args){
    	Q051_N_Queens t = new Q051_N_Queens();
    	LinkedList<LinkedList<String>> res = t.solveNQueens(8);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	} 
    	System.out.println("size = " + res.size());
    }
}
