import java.util.HashMap;


public class Q219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || k <= 0) return false;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; ++i){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
