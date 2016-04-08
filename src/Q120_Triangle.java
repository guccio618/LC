import java.util.ArrayList;
import java.util.List;


public class Q120_Triangle {
	// by Jackie, 滚动数组空间优化
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null){
            return 0;
        } else if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        
        int row = triangle.size(), col = triangle.get(row - 1).size();
        int[][] dp = new int[2][col];
        for(int i = 0; i < col; ++i){
            dp[(row - 1) % 2][i] = triangle.get(row - 1).get(i);
        }
        
        for(int i = row - 2; i >= 0; --i){
            for(int j = 0; j < triangle.get(i).size(); ++j){
                dp[i % 2][j] = Math.min(dp[(i + 1) % 2][j], dp[(i + 1) % 2][j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0][0];
    }
	
	
	
	
	public static void main(String[] args){
		Q120_Triangle t = new Q120_Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		int[][] nums = {
				{-1},
				{2,3},
				{1,-1,-3}
		};
		
		for(int i = 0; i < nums.length; ++i){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < nums[i].length; ++j){
				list.add(nums[i][j]);
			}
			triangle.add(list);
		}
		
		System.out.println(t.minimumTotal(triangle));
	}
}
