/*****************************************************************************************
 * cost[i][j]: minimum number of money to guarantee win for subproblem [i, j].
 * Target: cost[1][n]
 * Corner case: cost[i][i] = 0 (because the only element must be correct)
 * Equation: choose k (i<=k<=j) as our guess, and pay price k. After our guess, 
 * 			 the problem is divided into two subproblems. Notice we do not need to pay 
 * 			 the money for both subproblems. We only need to pay the worst case (because 
 * 			 the system will tell us which side we should go) to guarantee win. 
 * 
 *****************************************************************************************/

public class Q375_Guess_Number_Higher_or_Lower_II {
	// by other using DP
	public int getMoneyAmount(int n) {
        if(n <= 1){
            return 0;
        }
        
        int[][] cost = new int[n + 1][n + 1];
        
        for(int length = 1; length <= n; length++){
            for(int start = 1; start + length <= n; start++){
                int end = start + length;
                cost[start][end] = Integer.MAX_VALUE;
                
                for(int guess = start; guess <= end; guess++){
                    int leftPart = guess - 1 >= start ? cost[start][guess - 1] : 0;
                    int rightPart = guess + 1 <= end ? cost[guess + 1][end] : 0;
                    cost[start][end] = Math.min(cost[start][end], guess + Math.max(leftPart, rightPart));
                }
            }
        }
        
        return cost[1][n];
    }
}
