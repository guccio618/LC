public class Q055_Jump_Game {
	/*****************************************************/
	// by ninechapter using greedy
	public boolean canJump1(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int farthest = nums[0];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i <= farthest && i + nums[i] > farthest) {
				farthest = i + nums[i];
			}
			if (farthest >= n - 1)
				return true;
		}
		return farthest >= n - 1;
	}

	
	/*****************************************************/
	// by ninechapter using DP
	public boolean canJump2(int[] A) {
		boolean[] can = new boolean[A.length];
		can[0] = true;

		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (can[j] && j + A[j] >= i) {
					can[i] = true;
					break;
				}
			}
		}
		return can[A.length - 1];
	}

}
