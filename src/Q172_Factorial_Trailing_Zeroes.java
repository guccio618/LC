
public class Q172_Factorial_Trailing_Zeroes {
	/******************************************************/
	// by other, faster
    public int trailingZeroes2(int n) {
    	if(n < 5) return 0;
    	return n / 5 + trailingZeroes(n / 5);
    }
    
	/******************************************************/
	// by Jackie
	public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int res = 0;
        while(n >= 5){
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
