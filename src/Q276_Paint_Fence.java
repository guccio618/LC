
public class Q276_Paint_Fence {
	// using DP, space O(n)
		public int numWays(int n, int k) {
	        if(n == 0){
	            return 0;
	        } else if(n == 1){
	            return k;
	        }
	        
	        int[] sameColor = new int[n];
	        int[] diffColor = new int[n];
	        sameColor[0] = diffColor[0] = k;
	        sameColor[1] = k;
	        diffColor[1] = k * (k - 1);
	        
	        for(int i = 2; i < n; ++i){
	            sameColor[i] = diffColor[i - 1];
	            diffColor[i] = (diffColor[i - 1] + sameColor[i - 1]) * (k - 1);
	        }
	        
	        return sameColor[n - 1] + diffColor[n - 1];
	    }
		
		
		
		/***********************************************/
		// 空间优化过， space O(1)
		public int numWays2(int n, int k) {
	        if(n == 0){
	            return 0;
	        } else if(n == 1){
	            return k;
	        }
	        
	        int sameColor = k;
	        int diffColor = k * (k - 1);
	        
	        for(int i = 2; i < n; ++i){
	            int temp = diffColor;
	            diffColor = (sameColor + diffColor) * (k - 1);
	            sameColor = temp;
	        }
	        
	        return sameColor + diffColor;
	    }
}
