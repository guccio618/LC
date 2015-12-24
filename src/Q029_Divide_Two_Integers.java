public class Q029_Divide_Two_Integers {
	// by other
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		long divd = Math.abs((long) dividend);
		long divs = Math.abs((long) divisor);

		int ret = 0;
		while (divd >= divs) {
			int counter = 0;
			while (divd >= (divs << counter)) { // keep multiply by 2 until divs
												// > divd
				counter++;
			}
			counter--; // rollback counter so that (divs<<counter) <= divd
			ret += 1 << counter; // quotient
			divd -= divs << counter;
		}

		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
			return ret;
		else
			return -ret;
	}

	public static void main(String[] args) {
		Q029_Divide_Two_Integers t = new Q029_Divide_Two_Integers();
		System.out.println(t.divide(1, -1));
	}
}
