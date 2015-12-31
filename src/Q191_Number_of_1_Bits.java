
public class Q191_Number_of_1_Bits {
	/****************************************************/
	// by Jackie
	public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if ((n & 1) == 1) count++;
            n >>= 1;
        }
        return count;
    }
	
	public static void main(String[] args){
		Q191_Number_of_1_Bits t = new Q191_Number_of_1_Bits();
		System.out.println(t.hammingWeight(3));
	}
}
