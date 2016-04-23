
public class Q256_Paint_House {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        int n = costs.length;
        int preRed = costs[0][0];
        int preBlue = costs[0][1];
        int preGreen = costs[0][2];
        int curRed = preRed;
        int curBlue = preBlue;
        int curGreen = preGreen;
        
        for(int i = 1; i < n; i++){
            curRed = Math.min(preBlue, preGreen) + costs[i][0];
            curBlue = Math.min(preRed, preGreen) + costs[i][1];
            curGreen = Math.min(preRed, preBlue) + costs[i][2];
            preRed = curRed;
            preBlue = curBlue;
            preGreen = curGreen;
        }
        
        return Math.min(curRed, Math.min(curBlue, curGreen));
    }
}
