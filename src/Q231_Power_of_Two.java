
public class Q231_Power_of_Two {
	//by jackie
	public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        if(n != 1 && n % 2 != 0) return false;
        while(n > 0){
            if(n % 2 != 0 && n != 1)
                return false;
            n /= 2;
        }
        return true;
    }
	
	public static void main(String[] args){
		Q231_Power_of_Two test = new Q231_Power_of_Two();
		System.out.println(test.isPowerOfTwo(1));
	}
}
