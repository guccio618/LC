import java.util.ArrayList;
import java.util.Arrays;


public class Q300_Longest_Increasing_Subsequence {
	/**********************************************************/
	// by other using DP+binary search, O(nlogn)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int firstInsertPos = 0;
        
        for(int element : nums){
            if(firstInsertPos == 0 || element > nums[firstInsertPos - 1]){
                nums[firstInsertPos++] = element;
            } else {
                int index = Arrays.binarySearch(nums, 0, firstInsertPos, element);
                
                if(index < 0){
                    nums[-(index + 1)] = element;
                }
            }
        }
        
        return firstInsertPos;
    }
    
    
    /***********************************************/
	// by other, easily to unstand
	public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < n; ++i){
            updateList(list, nums[i]);
        }
        
        return list.size();
    }
    
    public void updateList(ArrayList<Integer> list, int target){
        if(list.size() == 0 || target > list.get(list.size() - 1)){   
            list.add(target);
        } else {                                     // target < list.get(0) 考虑在这里 ！！！
            int pos = findPos(list, target);
            list.set(pos, target);
        }
    }
    
    public int findPos(ArrayList<Integer> list, int target){
    	if(list.size() == 0){
    		return 0;
    	}
        int left = 0, right = list.size() - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            int midNum = list.get(mid); 
            if(midNum < target){
                left = mid;
            } else {
                right = mid;
            }
        }

        if(list.get(left) >= target){
            return left;
        } else if(list.get(right) >= target){
            return right;
        } else {
            return right + 1;
        }
    }
	
    
	
	/**********************************************************/
	// by Jackie using DP, O(n^2)
	public int lengthOfLIS3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] res = new int[nums.length];  // 存放到当前位为止最大的的increasing subsequence个数
        res[0] = 0;  // 必须从0开始，否则例如在res[0] = 1时，在之后的叠加中，每次都会被多加上1
        int max = -1;
        
        for(int i = 1, len = nums.length; i < len; ++i){ // 反向DP
        	for(int j = 0; j < i; ++j){
        		if(nums[j] < nums[i])
        			res[i] = Math.max(res[i], res[j]+1);
        			max = Math.max(max, res[i]);
        	}
        }        
        return (max == -1) ? 1 : max+1;
    }
	
	public static void main(String[] args){
		Q300_Longest_Increasing_Subsequence t = new Q300_Longest_Increasing_Subsequence();
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(t.lengthOfLIS(nums));
	}
}
