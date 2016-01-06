
public class Q009_Palindrome_Number {
	// by Jackie
	public static boolean isPalindrome(int x) {
	    if (x < 0) return false;
	    long t = 0;
	    int temp = x;
	    while (temp > 0) {
	    	t = t*10 + temp%10;
	    	temp /= 10;
	    }
	    
	    while(x > 0){
	    	int first = x % 10;
	    	int last = (int)(t % 10);
	    	if(first != last) return false;
	    	x /= 10;
	    	t /= 10;    	
	    }
	    return true;
	}
	
	
	public static void main(String[] args){
		Q009_Palindrome_Number t = new Q009_Palindrome_Number();
		System.out.println(t.isPalindrome(12345));
	}
}
