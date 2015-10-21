import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Q199_Binary_Tree_Right_Side_View {
	public ArrayList<Integer> rightSideView(TreeNode root) {  //by jackie
		ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 1;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(--count == 0){
                count = queue.size();
                res.add(node.val);
            }
        }
        return res;
    }
}
