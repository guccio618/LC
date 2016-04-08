
public class Q041_First_Missing_Positive {
	/*************************************************/
	//by ninechapter using counting sort
	public int firstMissingPositive(int[] nums) {
		if (nums == null) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
				int tmp = nums[nums[i] - 1]; // 3,4,-1,1
				if (tmp == nums[i]) {
					break;
				}
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
    }
	
	
		
	/*************************************************/
	// by Jackie using hashset
	public int firstMissingPositive2(int[] nums) {
        if (nums == null) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
				int tmp = nums[nums[i] - 1]; // 3,4,-1,1
				if (tmp == nums[i]) {
					break;
				}
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
    }
	
	public static void main(String[] args){
		Q041_First_Missing_Positive test = new Q041_First_Missing_Positive();
		int[] array = {3,4,-1,1};
		System.out.println(test.firstMissingPositive(array));
	} 
}
