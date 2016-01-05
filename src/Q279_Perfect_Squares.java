
public class Q279_Perfect_Squares {
	/*****************************************************/
	// by Jackie using DP
	public int numSquares(int n) {
        if(n <= 0) return 0;
        int len = (int) Math.sqrt(n);
        long[] res = new long[n+1];
        res[0] = 0;
        for(int i = 1; i < n+1; ++i)
            res[i] = Integer.MAX_VALUE;
        
        for(int i = 1; i < n+1; ++i){
            for(int j = 1; j <= len && j*j <= i; ++j){
                res[i] = Math.min(res[i], res[i-j*j]+1);
            }
        }
        return (int) res[n];
    }
	
	
	public static void main(String[] args){
		Q279_Perfect_Squares t = new Q279_Perfect_Squares();
		System.out.println(t.numSquares(12));
	}
}
