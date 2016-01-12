
public class Q327_Count_of_Range_Sum {
	/*******************************************************/
	// by other using divide and conquer， O(nlogn)
	public int countRangeSum(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    int res = countWhileMergeSort(sums, 0, n + 1, lower, upper);
	    for (int i = 0; i < n; ++i)
	        System.out.print(sums[i] + ", ");
	    System.out.println();
	    return res;
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	    		+ countWhileMergeSort(sums, mid, end, lower, upper);
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, r = 0; i < mid; ++i, ++r) {
	        while (k < end && sums[k] - sums[i] < lower) k++;  // 先计算，再排序，保证在混合前，
	        while (j < end && sums[j] - sums[i] <= upper) j++; // left part的一定在原sums[]中right part的左边
	        while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
	        cache[r] = sums[i];
	        count += j - k;
	    }
	    System.arraycopy(cache, 0, sums, start, t - start);
	    return count;
	}
	    
	
	/*******************************************************/
	// by Jackie using DP, O(n^2) but Time Limit Exceeded
	public int countRangeSum2(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0 || lower > upper){
            return 0;    
        } 
        int result = 0;
        long[] sum = new long[nums.length+1];
        for(int i = 0; i < nums.length; ++i){
            sum[i+1] = sum[i] + nums[i];
        }
        for(int i = 0; i < nums.length; ++i){
            for(int j = i+1; j <= nums.length; ++j){
                if(sum[j]-sum[i] >= lower && sum[j]-sum[i] <= upper){
                    result++;
                }
            }
        }
        return result;
	}
	
	
	public static void main(String[] args){
		Q327_Count_of_Range_Sum t = new Q327_Count_of_Range_Sum();
		int[] nums = {-2, 5, -1, 5, -7, 9, 10, 11, -8};
		System.out.println(t.countRangeSum(nums, 1, 4));
		System.out.println(t.countRangeSum2(nums, 1, 4));
	}
}
