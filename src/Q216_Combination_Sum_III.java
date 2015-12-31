import java.util.LinkedList;


/**************************************************************************
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination 
 * should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 **************************************************************************/

public class Q216_Combination_Sum_III {
/*****************************************************/
	// by Jackie using backtrack
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();

	public LinkedList<LinkedList<Integer>> combinationSum3(int k, int n) {
		if (k == 0 || n <= 0) return res;
		LinkedList<Integer> path = new LinkedList<Integer>();
		for (int i = 1; i < 10; ++i) {
			backtrack(i, n, path, k);
		}
		return res;
	}

	public void backtrack(int cur, int sum, LinkedList<Integer> path, int k) {
		if (sum < 0) return;
		sum -= cur;
		path.add(cur);
		if (sum == 0 && path.size() == k) {
			res.add(new LinkedList<Integer>(path));
		} 
		else {
			for (int i = cur+1; i < 10; ++i) {
				if (cur > sum) break;
				backtrack(i, sum, path, k);
			}
		}
		path.remove(path.size() - 1);
	}
	
	
/*****************************************************/
	
	public static void main(String[] args){
		Q216_Combination_Sum_III t = new Q216_Combination_Sum_III();
    	LinkedList<LinkedList<Integer>> res = t.combinationSum3(3, 9);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
