
public class Q414_Third_Maximum_Number {
	public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        long[] max = new long[3];
        max[0] = max[1] = max[2] = Long.MIN_VALUE;
        
        for (int num : nums) {
            if ((long) num >= max[0]) {
                if ((long) num > max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = (long) num;
                }
            } else if ((long) num >= max[1]) {
                if ((long) num > max[1]) {
                    max[2] = max[1];
                    max[1] = (long) num;
                }
            } else if ((long) num >= max[2]) {
                max[2] = (long) num;
            }
        }
        
        if (max[2] == Long.MIN_VALUE) {
            return (int) max[0];
        } else {
            return (int) max[2];
        }
    }
}
