import java.util.Arrays;
import java.util.LinkedList;


public class Q039_Combination_Sum {
	/****************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
	
	public LinkedList<LinkedList<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null || target <= 0) return res;
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<Integer>();
        for(int i = 0, len = candidates.length; i < len; ++i){
            if(i+1 < len && candidates[i+1] == candidates[i]) continue;
            backtrack(candidates, i, target, path);
        }
        return res;
    }
	
	public void backtrack(int[] candidates, int pos, int sum,
			LinkedList<Integer> path) {
		if (sum < 0)
			return;
		sum -= candidates[pos];
		path.add(candidates[pos]);
		if (sum == 0) {
			res.add(new LinkedList<Integer>(path));
		} else {
			for (int i = pos, len = candidates.length; i < len; ++i) {
				if (candidates[i] > sum)
					break;
				backtrack(candidates, i, sum, path);
				while (i + 1 < len && candidates[i + 1] == candidates[i])
					i++;
			}
		}
		path.remove(path.size() - 1);
	}
	
	
	public static void main(String[] args){
		Q039_Combination_Sum t = new Q039_Combination_Sum();
		int[] nums = {2,3,6,7};
		LinkedList<LinkedList<Integer>> res = t.combinationSum(nums, 7);
		for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
	}
}
