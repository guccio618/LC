import java.util.HashMap;


/***********************************************/
/** 1. Hashmap                                **/
/** 	(1). Hashmap.get                      **/
/** 	(2). Hashmap.put                      **/
/** 	(3). Hashmap.containsKey              **/
/***********************************************/
public class Q001_Two_Sum {
	public int[] twoSum(int[] nums, int target) {  //by other using Hashmap
		HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (mymap.containsKey(target - nums[i]))
				return new int[] { mymap.get(target - nums[i]) + 1, i + 1 };
			mymap.put(nums[i], i);
		}
		return null;
	}
}
