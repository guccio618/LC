import java.util.Arrays;
import java.util.LinkedList;


public class Q047_Permutations_II {
	/********************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
    
    public LinkedList<LinkedList<Integer>> permuteUnique(int[] nums) {
        if(nums == null) return res;
        Arrays.sort(nums);
        LinkedList<Integer> path = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, 0, visited, path);
        return res;
    }
    
    public void backtrack(int[] nums, int curPos, boolean[]visited, LinkedList<Integer> path){
    	if(curPos == nums.length){
            res.add(new LinkedList<Integer>(path));
    	}
    	else{
    		for(int i = 0, len = nums.length; i < len; ++i){
    			if(visited[i] == true) continue;
    			visited[i] = true;
    			path.add(nums[i]);
    			backtrack(nums, curPos+1, visited, path);
    			path.remove(path.size()-1);
    			visited[i] = false;
    			while(i+1 < len && nums[i+1] == nums[i]) ++i;
    		}
    	}
    }
    
    
    public static void main(String[] args){
    	Q047_Permutations_II t = new Q047_Permutations_II();
    	int[] nums = {0,1,0,0,9};
    	LinkedList<LinkedList<Integer>> res = t.permuteUnique(nums);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
