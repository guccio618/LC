
public class Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	// by other using DP
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }        
        int[] sellDp = new int[prices.length];    // 表示当天最终未持股的情况下，当天结束后的累计最大利润       
        int[] buyDp = new int[prices.length];     // 表示当天最终持股的情况下，当天结束后的累计最大利润
        
        // 考虑初始情况
        buyDp[0] = -prices[0];
        sellDp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]); // 当天不持股＝昨天不持股或昨天持股但今天卖出的最大值
            if (i >= 2) {
                buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);  // 当天持股＝昨天持股或前天卖出昨天冻结，今天持股的最大值
            } else {
                buyDp[i] = Math.max(buyDp[i - 1], -prices[i]);
            }
        }
        return sellDp[prices.length - 1];
    }

	
	
	public static void main(String[] args){
		Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown t = new Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(t.maxProfit(prices));
	}
}