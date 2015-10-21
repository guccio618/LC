
public class Q123_Best_Time_to_Buy_and_Sell_Stock_III {
	/************************************************************************************
	 Say you have an array for which the ith element is the price of a given stock on day i.
	 Design an algorithm to find the maximum profit. You may complete at most two transactions.	 
	 ************************************************************************************/
	
	//by ninechapter
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right;              //min: 截至到当前的最低价格， prices[i]:当日卖出价格
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //DP from right to left;               //max: 截至到当前的最高价格， prices[i]: 买入价格
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = Math.max(left[i] + right[i], profit);  
        }

        return profit;
    }
    
    public static void main(String[] args){
    	Q123_Best_Time_to_Buy_and_Sell_Stock_III test = new Q123_Best_Time_to_Buy_and_Sell_Stock_III();
    	int[] array = {1,5,8,4,2,7,5,0,35,73,25,8,99,1};
    	System.out.println(test.maxProfit(array));    	
    }
}
