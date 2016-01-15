import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q089_Gray_Code {
	/***************************************************/
	// by other
	// so the pattern is when n=n -> add 0 in front of all the result of (n-1)'s
	// binary value (This is just same as all the result of (n-1)
	// and add 1 in front of all the result of(n-1)'s binary value (This need to
	// calculate.)

	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList();
		result.add(0);

		for (int i = 1; i <= n; i++) {
			int front = 1;
		// Create the correct value for binary format (10...0) which the
		// value has i digi
		// so shift 1 to right (i-1) times
			for (int j = 1; j < i; j++) {
				front = front << 1;
			}

		// add the new generated value to the result list
		// the new generated value is the last result add front value
			int size = result.size();
		// we want to loop through the (n-1) result from end to start. This
		// is just because want to make the test case match the Leetcode
		// answer. You can use other way loop through the (n-1) result.
			for (int k = size - 1; k >= 0; k--) {
				
				result.add(result.get(k) + front);
				System.out.println(result.get(k) + front);
				
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Q089_Gray_Code t = new Q089_Gray_Code();
		List<Integer> res = t.grayCode(2);
		for (int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
		System.out.println();

	}
}
