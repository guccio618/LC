
public class Q279_Perfect_Squares {
	/*****************************************************/
	// by Jackie using DP
	public int numSquares(int n) {
		if(n <= 0){
            return 0;
        }
        
        int len = (int) Math.sqrt(n);
        int[] ways = new int[n + 1];
        
        for(int i = 1; i <= n; ++i){
            ways[i] = i;
            // 优化：for 上加入： “&& i >= j * j”
            for(int j = 1; j <= len && i >= j * j; ++j){
                int square = j * j;
                ways[i] = Math.min(ways[i], ways[i - square] + 1);            
            }
//            for(int j = 1; j <= len; ++j){
//                int square = j * j;
//                if(i >= square){
//                    ways[i] = Math.min(ways[i], ways[i - square] + 1);
//                }
//            }
        }
        
        return ways[n];
    }
	
	
	/************************** main function ***************************/
	public static void main(String[] args){
		Q279_Perfect_Squares t = new Q279_Perfect_Squares();
		System.out.println(t.numSquares(12));
	}
}
