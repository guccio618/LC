
public class Q052_N_Queens_II {
	/********************************************************/
	// by Jackie using backtrack (recursive)
	private int res;	
	public int totalNQueens(int n) {
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
        else
            res++;
    }
    
    public boolean valid(int[] ways, int curRow, int len){
        for(int i = 1; i < curRow; ++i){
            if(ways[i] == ways[curRow] || Math.abs(ways[i]-ways[curRow]) == Math.abs(i-curRow))
                return false;
        }
        return true;
    }
    
    
    public static void main(String[] args){
    	Q052_N_Queens_II t = new Q052_N_Queens_II();
    	System.out.println(t.totalNQueens(8));
    }
}
