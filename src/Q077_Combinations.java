import java.util.LinkedList;


public class Q077_Combinations {
	/*************************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
    
    public LinkedList<LinkedList<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || k > n) return res;
        LinkedList<Integer> path = new LinkedList<Integer>();
        for(int i = 1; i <= n; ++i){
            backtrack(i, n, k, path);
        }
        return res;
    }
    
    public void backtrack(int num, int n, int k, LinkedList<Integer> path){
        path.add(num);
        if(path.size() == k){
            res.add(new LinkedList<Integer>(path));
        }
        else{
            for(int i = num+1; i <= n; ++i)
                backtrack(i, n, k, path);
        }
        path.remove(path.size()-1);
    }
    
    
    public static void main(String[] args){
    	Q077_Combinations t = new Q077_Combinations();
    	LinkedList<LinkedList<Integer>> res = t.combine(4, 2);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
