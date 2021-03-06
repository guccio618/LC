import java.util.ArrayList;
import java.util.List;


public class Q119_Pascals_Triangle_II {
	// by Jackie using DP
	public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        if(rowIndex < 0){
            return ans;
        }
        
        int[][] dp = new int[2][rowIndex + 1];
        
        for(int i = 0; i <= rowIndex; ++i){
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){
                    dp[i % 2][j] = 1;
                } else {
                    dp[i % 2][j] = dp[1 - i % 2][j] + dp[1 - i % 2][j - 1];
                }
                
                if(i == rowIndex){
                    ans.add(dp[i % 2][j]);
                }
            }
        }
        
        return ans;
    }
	
	
	public static void main(String[] args){
		Q119_Pascals_Triangle_II t = new Q119_Pascals_Triangle_II();
		List<Integer> res = new ArrayList<Integer>();
		res = t.getRow(1);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
