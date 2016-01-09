
public class Q326_Power_of_Three {
	// by other
	public boolean isPowerOfThree(int n) {
		if(n <= 0) return false;
        return  (1162261467 / n == 1162261467 / (double)n); 
    }
	// by Jackies
	public boolean isPowerOfThree2(int n) {
        if(n == 1) return true;
        if(n % 3 != 0 || n <= 0) return false;
        int res = 0;
        while(n >= 3 && res == 0){
        	res = n % 3;
            n /= 3;           
        }
        return (n == 1 && res == 0);
    }
	
	
	public static void main(String[] args){
		Q326_Power_of_Three t = new Q326_Power_of_Three();
		System.out.println(t.isPowerOfThree(27));
	}
}
