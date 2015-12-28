
public class Q258_Add_Digits {
	// by other
	public int addDigits(int num) {
		return (num-1) % 9 + 1;
	}
	
	// by Jackie
	public int addDigits2(int num) {
        while(num >= 10)
            num = num / 10 + num % 10;
        return num;
    }
	
	public static void main(String[] args){
		Q258_Add_Digits t = new Q258_Add_Digits();
		System.out.println(t.addDigits(10));
	}
}
