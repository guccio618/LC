import java.util.LinkedList;
import java.util.Queue;


public class Q111_Minimum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) { //by other using iterative
		   Queue<TreeNode> queue = new LinkedList<TreeNode>();
		    if(root==null) return 0;
		    queue.add(root);
		    int level = 0;
		    while(!queue.isEmpty()){
		        int count = queue.size();
		        while(count>0){
		            TreeNode tmp = queue.poll();
		            // return when we find the first leaf node
		            if(tmp.left==null && tmp.right==null) return ++level;
		            if(tmp.left!=null) queue.add(tmp.left);
		            if(tmp.right!=null) queue.add(tmp.right);
		            count--;
		        }
		        level++;
		    }
		    return level;
		}

//*************************************************************************************	
	
	public int minDepth_recursive(TreeNode root) {  //by NineChapter using recursive
        if (root == null) return 0;
        return getMin(root);
    }

    public int getMin(TreeNode root){
        if (root == null)
            return Integer.MAX_VALUE;

        if (root.left == null && root.right == null)
            return 1;

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}
