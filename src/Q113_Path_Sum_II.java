import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*************************************
 * test case: [-2, null, -3, null] -5
 * 
 *************************************/

public class Q113_Path_Sum_II {
	// by Jackie using dfs
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, ans, list, sum);
        return ans;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> list, int sum){
        if(root == null){
            return;
        } else if(root.left == null && root.right == null){
            if(sum == root.val){
                list.add(root.val);
                ans.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        
        list.add(root.val);
        dfs(root.left, ans, list, sum - root.val);
        dfs(root.right, ans, list, sum - root.val);
        list.remove(list.size() - 1);
    }
	
	
	
    // by other using dfs
	public List<List<Integer>> pathSum2(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        List<Integer> path = new ArrayList<Integer>(); 
        dfs2(ans, path, root, target);
        return ans;
    }
    
    public void dfs2(List<List<Integer>> ans, List<Integer> path, TreeNode node, int target){
        if(node == null){
            return;
        }
        
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(node.val == target){
                ans.add(new ArrayList<Integer>(path));
            }
        } else {
            dfs2(ans, path, node.left, target - node.val);
            dfs2(ans, path, node.right, target - node.val);
        }
        path.remove(path.size() - 1);
    }
    
    
    
    
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(5);   	
    	
    	root.left = new TreeNode(4);
    	root.left.left = new TreeNode(11);
    	root.left.left.left = new TreeNode(7);
    	root.left.left.right = new TreeNode(2);
    	
    	root.right = new TreeNode(8);
    	root.right.left = new TreeNode(13);
    	root.right.right = new TreeNode(4);
    	root.right.right.left = new TreeNode(5);
    	root.right.right.right = new TreeNode(1);
    	
    	Q113_Path_Sum_II t = new Q113_Path_Sum_II();
    	List<List<Integer>> res = t.pathSum(root, 22);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
