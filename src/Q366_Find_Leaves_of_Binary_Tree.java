import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q366_Find_Leaves_of_Binary_Tree {
	// by Jackie using DFS
	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    private int maxHeight = 0;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        dfs(root);
        
        for(int i = 1; i <= maxHeight; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
    
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        } 
        
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int currentHeight = Math.max(leftHeight, rightHeight) + 1;
        maxHeight = Math.max(maxHeight, currentHeight);
        
        if(map.containsKey(currentHeight)){
            map.get(currentHeight).add(node.val);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            map.put(currentHeight, list);
        }
        
        return currentHeight;
    }
    
    
}
