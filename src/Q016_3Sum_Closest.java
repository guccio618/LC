import java.util.Arrays;


public class Q016_3Sum_Closest {
	/*********************************************************/
	// by Jackie
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
    
        for(int i = 0; i < nums.length-2; ++i){
            int front = i+1, back = nums.length-1, sum = 0;
            while(front < back){
                sum = nums[i] + nums[front] + nums[back];
                if(sum > target) back--;
                else if(sum < target) front++;
                else return target;
                
                if(min > Math.abs(target - sum)){
                    min = Math.abs(target - sum);
                    res = sum;
                }               
            }
        }
        return res;
    }
	
	
	public static void main(String[] args){
		Q016_3Sum_Closest t = new Q016_3Sum_Closest();
		int[] nums = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4
				};
		int target = -275;
		System.out.println(t.threeSumClosest(nums, target));
	}
}
