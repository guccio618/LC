import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*******************************************
(1). Breadth-first search               
/*******************************************/

public class Q107_Binary_Tree_Level_Order_Traversal_II {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) { //by jackie
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> temp_list = new ArrayList<Integer>();
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp_list.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(--count == 0){
                count = queue.size();
                res.add(0, new ArrayList(temp_list));
                temp_list.clear();
            }
        }
        return res;
    }
}
