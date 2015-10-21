
public class Q007_Reverse_Integer {
	public int reverse(int x) {
        if(x > -10 && x < 10) return x;
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;
        int negative_flag = 1;
        if(x < 0) {
            negative_flag = -1;
            x = -x;
        }
        long sum = x % 10;
        x /= 10; 
        System.out.println("sum = " + sum + ", x = " + x);
        while(x > 0){
            sum = sum * 10 + x % 10;
            if(sum >= Integer.MAX_VALUE)
            	return 0;
            x /= 10;
            System.out.println("sum = " + sum + ", x = " + x);
        }
        return (int)(sum *= negative_flag);
    }
	
	public static void main(String[] args){
		Q007_Reverse_Integer test = new Q007_Reverse_Integer();
		System.out.println(test.reverse(1534236469));
	}
}
