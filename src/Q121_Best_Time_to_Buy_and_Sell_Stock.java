
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
	//by ninichapter
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        
        int len = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        
        for(int i = 1; i < len; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
	
	
	// by Jackie using DP
	public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        
        int len = prices.length;
        int[] profit = new int[len];
        profit[0] = 0;
        int minPrice = prices[0];
        
        for(int i = 1; i < len; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit[i] = Math.max(profit[i - 1], prices[i] - minPrice);
        }
        
        return profit[len - 1];
    }
}
