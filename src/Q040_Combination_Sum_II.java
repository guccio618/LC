/******************************************************************************
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 ******************************************************************************/
import java.util.Arrays;
import java.util.LinkedList;


public class Q040_Combination_Sum_II {
	/*******************************************************/
	// by other, faster
	public LinkedList<LinkedList<Integer>> combinationSum2(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		LinkedList<LinkedList<Integer>> ans = new LinkedList<LinkedList<Integer>>();
		ch(candidates, target, 0, new LinkedList<Integer>(), ans);
		return ans;
	}

	public void ch(int[] candidates, int remain, int rindex,
			LinkedList<Integer> tmp, LinkedList<LinkedList<Integer>> ans) {
		if (remain == 0) {
			LinkedList<Integer> a = new LinkedList<Integer>(tmp);
			ans.add(a);
			return;
		}
		int entered = 0; // get rid of duplicate combinations
		for (int i = rindex; i < candidates.length; i++) {
			if (entered != candidates[i]) {// get rid of duplicate combinations
				if (remain - candidates[i] < 0)
					break; // This line of code can reduce 7ms from execution
							// time!
				tmp.add(candidates[i]);
				entered = candidates[i];
				ch(candidates, remain - candidates[i], i + 1, tmp, ans);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
	
	/*******************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
    public LinkedList<LinkedList<Integer>> combinationSum2_2(int[] candidates, int target) {
        if(candidates == null || target <= 0) return res;
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<Integer>();
        for(int i = 0, len = candidates.length; i < len; ++i){
        	if(i > 0 && candidates[i-1] == candidates[i]) continue;
        	backtrack(candidates, i, target, path);
        }
        return res;
    }
    
    public void backtrack(int[] candidates, int pos, int sum, LinkedList<Integer> path){
        if(sum < 0) return;
        
        path.add(candidates[pos]);
        sum -= candidates[pos];
        if(sum == 0)
            res.add(new LinkedList<Integer>(path));
        else{
            for(int i = pos+1, len = candidates.length; i < len; ++i){
            	if(candidates[pos] > sum) break;
                backtrack(candidates, i, sum, path);
                while(i+1 < len && candidates[i+1] == candidates[i]) i++;  // 去除candidates里重复的num
            }
        }
        path.remove(path.size()-1);
    }
    
    public void print(int[] array){
    	for(int i = 0; i < array.length; ++i)
    		System.out.print(array[i] + ", ");
    	System.out.println();
    }
    
    public static void main(String[] args){
    	Q040_Combination_Sum_II t = new Q040_Combination_Sum_II();
//    	int[] candidates = {10,1,2,7,6,1,5};
//    	LinkedList<LinkedList<Integer>> res = t.combinationSum2(candidates, 8);
    	int[] candidates2 = {2,2,2};
    	LinkedList<LinkedList<Integer>> res = t.combinationSum2(candidates2, 4);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
