import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q366_Find_Leaves_of_Binary_Tree {
	// by Jackie using DFS
	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null){
            return ans;
        }
        
        int maxDepth = DFS(root);
        
        for(int i = 1; i <= maxDepth; i++){
            ans.add(new ArrayList<Integer>(map.get(i)));
        }
        
        return ans;
    }
    
    public int DFS(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftDepth = DFS(node.left);
        int rightDepth = DFS(node.right);
        int curDepth = Math.max(leftDepth, rightDepth) + 1;
        
        if(map.containsKey(curDepth)){
            map.get(curDepth).add(node.val); 
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            map.put(curDepth, list);
        }
        
        return curDepth;
    }
    
    
}
