public class Q322_Coin_Change {
	// by other
	public int coinChange(int[] coins, int amount) {		
		if(coins == null || coins.length == 0 || amount == 0){
            return 0;
        }
        
        int[] ways = new int[amount + 1];
        ways[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            ways[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && ways[i - coins[j]] < Integer.MAX_VALUE){
                    ways[i] = Math.min(ways[i], ways[i - coins[j]] + 1);
                }
            }
        }
        
        return ways[amount] == Integer.MAX_VALUE ? -1 : ways[amount];
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
