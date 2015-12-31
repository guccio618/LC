import java.util.Arrays;
import java.util.LinkedList;


public class Q078_Subsets {
	/***************************************************/
	// by other, faster
	public LinkedList<LinkedList<Integer>> subsets(int[] nums) {
        // sort, then DFS
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        subsetsHelper(0, nums, new LinkedList<Integer>(), result);
        return result;
    }

    private void subsetsHelper(int curr, int[] nums, LinkedList<Integer> path, LinkedList<LinkedList<Integer>> result) {
        if (curr == nums.length) {
            result.add(new LinkedList<Integer>(path));
            return;
        }
        // skip the curr number
        subsetsHelper(curr + 1, nums, path, result);
        // take the curr number
        path.add(nums[curr]);
        subsetsHelper(curr + 1, nums, path, result);
        path.remove(path.size()-1);
    }
	
	
    /***************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();    
    public LinkedList<LinkedList<Integer>> subsets2(int[] nums) {
        if(nums == null) return res;
        LinkedList<Integer> path = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        res.add(new LinkedList<Integer>(path));
        for(int i = 1, len = nums.length; i <= len; ++i){
        	for(int j = 0; j < len; ++j)
        		backtrack(nums, j, i, path, visited);
        }
        return res;
    }
    
    public void backtrack(int[] nums, int curPos, int num, LinkedList<Integer> path, boolean[] visited){
        if(visited[curPos] == true) return;        
        visited[curPos] = true;
        path.add(nums[curPos]);
        if(path.size() == num){
        	res.add(new LinkedList<Integer>(path));
        }
        for(int i = curPos+1; i < nums.length; ++i){
            backtrack(nums, i, num, path, visited);
        }
        path.remove(path.size()-1);
        visited[curPos] = false;
    }
    
    
    public static void main(String[] args){
    	Q078_Subsets t = new Q078_Subsets();
    	int[] candidates = {4,1,0};
    	LinkedList<LinkedList<Integer>> res = t.subsets(candidates);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
