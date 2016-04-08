import java.util.ArrayList;
import java.util.List;


public class Q118_Pascals_Triangle {
	// by Jackie using DP
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(numRows <= 0){
            return ans;
        }
        
        int[][] dp = new int[2][numRows];
        
        for(int i = 0; i < numRows; ++i){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){
                    dp[i % 2][j] = 1;
                } else {
                    dp[i % 2][j] = dp[1 - i % 2][j] + dp[1 - i % 2][j - 1];
                }
                
                list.add(dp[i % 2][j]);
            }
            ans.add(list);
        }
        
        return ans;
    }
}
