
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
	//by ninichapter
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int profit = Integer.MIN_VALUE; 
        int lowerPrice = Integer.MAX_VALUE;
        for(int i : prices){
            lowerPrice = Math.min(i, lowerPrice);
            profit = Math.max(i-lowerPrice, profit);
        }
        return profit;
    }
}
