import java.util.LinkedList;
import java.util.Queue;


public class Q104_Maximum_Depth_of_Binary_Tree {
	public int maxDepth_recursive(TreeNode root) {  //by jackie using recursive
        if(root == null) return 0;
		int level = 0;
		level = calculate_level(root, level);
		return level;
	}
	
	public int calculate_level(TreeNode node, int level){
	    level++;
	    int level_1 = level, level_2 = level;
		if(node.left != null) level_1 = calculate_level(node.left, level);
		if(node.right != null) level_2 = calculate_level(node.right, level);
		return level_1 > level_2 ? level_1 : level_2;
    }
	
//********************************************************************************
	
	public int maxDepth(TreeNode root) {  //by jackie using level_traversal
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 1, level = 0;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(--count == 0){
                level++;
                count = queue.size();
            }
        }
        return level;
    }
}
