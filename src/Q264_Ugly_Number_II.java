public class Q264_Ugly_Number_II {
	/***************************************************/
	// by other
	public int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;
		int T2 = 0, T3 = 0, T5 = 0;
		int[] table = new int[n];
		table[0] = 1;
		int count = 1;
		while (count < n) {
			int next_val = Math.min(table[T2] * 2, Math.min(table[T3] * 3, table[T5] * 5));
			table[count++] = next_val;
			if (table[T2] * 2 == next_val)
				T2++;
			if (table[T3] * 3 == next_val)
				T3++;
			if (table[T5] * 5 == next_val)
				T5++;
		}
		return table[n - 1];
	}
	
	
	public static void main(String[] args){
		Q264_Ugly_Number_II t = new Q264_Ugly_Number_II();
		System.out.println(t.nthUglyNumber(1510));
	}
}
