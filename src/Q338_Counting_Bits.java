
public class Q338_Counting_Bits {
	// by Jackie using DP, time complexity is O(n)
	public int[] countBits(int num) {
        if(num < 0){
            return new int[0];
        } else if(num == 0){
            int[] ways = new int[1];
            ways[0] = 0;
            return ways;
        }
        
        int[] ways = new int[num + 1];
        ways[0] = 0;
        ways[1] = 1;
        int start = 0, end = 1;
        
        for(int i = 2; i <= num; ++i){
            if(start < end){
                ways[i] = ways[start] + 1;
                start++;
            } else if(start == end){
                ways[i] = ways[start] + 1;
                start = 0;
                end = i;
            }
        }
        
        return ways;
    }
	
	public static void main(String[] args){
		Q338_Counting_Bits t = new Q338_Counting_Bits();
		int[] ways = t.countBits(8);
		
		for(int i = 0; i < ways.length; ++i){
			System.out.print(ways[i] + ", ");
		}
	}
}
