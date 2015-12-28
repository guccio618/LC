public class Q322_Coin_Change {
	// by other
	public int coinChange(int[] coins, int amount) {		
		if(coins == null || amount < 0) return -1;
		if(amount == 0) return 0;
		long[] ways = new long[amount+1];
		for(int i = 1, len = ways.length; i < len; ++i)
			ways[i] = Integer.MAX_VALUE;
		ways[0] = 0;
		
		for(int i = 1, len = ways.length; i < len; ++i){
			for(int j = 0, n = coins.length; j < n; ++j){
				if(i >= coins[j])
					ways[i] = Math.min(ways[i], ways[i-coins[j]] + 1);
			}
		}
		print(ways);
		
		return (ways[ways.length-1] == Integer.MAX_VALUE) ? -1 : (int) ways[ways.length-1];
	}
	
	public void print(long[] array){
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		Q322_Coin_Change t = new Q322_Coin_Change();
		int[] coins = {5, 7};
		System.out.println(t.coinChange(coins, 33));
	}
}
