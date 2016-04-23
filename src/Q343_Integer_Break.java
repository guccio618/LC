
public class Q343_Integer_Break {
	/**************************************/
	// by Jackie use dp
	public int integerBreak(int n) {
        if(n == 2 || n == 3) {  // 2和3必须单独处理
            return n - 1;
        }
        
        int[] memo = new int[n + 1];
		memo[2] = 2;
		memo[3] = 3;
		
		for(int i = 4; i <= n; i++){
			for(int j = 1; j <= i / 2; j++){
				memo[i] = Math.max(memo[i], memo[j] * memo[i - j]);
			}			
		}
		
		return memo[n];
    }
	
	
	
	/**************************************/
	//by other use dp
	public int integerBreak2(int n) {
        if (n == 2 || n == 3){
        	return n - 1;
        }

        int[] prod = new int[n+1];
        prod[2] = 2;
        prod[3] = 3;
        for (int i = 4; i <= n; ++i) {
            prod[i] = Math.max(prod[i/2] * prod[i - i/2], Math.max(prod[i-2] * prod[2], prod[i-3] * prod[3]));
        }
        return prod[n];
    }    
    
	
	
	/******************** main ******************/
    public static void main(String[] args){
    	Q343_Integer_Break t = new Q343_Integer_Break();
    	System.out.println(t.integerBreak(8));
//    	System.out.println(t.integerBreak2(28));
    }
}
