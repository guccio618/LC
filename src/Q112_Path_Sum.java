import java.util.Stack;


public class Q112_Path_Sum {
	public boolean hasPathSum_recursive(TreeNode root, int sum) { //by other using recursive
	    if(root == null) return false;
	    if(root.val == sum && root.left == null && root.right == null)
	        return true;
	    return hasPathSum_recursive(root.left,sum-root.val) || hasPathSum_recursive(root.right, sum-root.val);
	}
}
