
public class Q101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        if(root.left.val != root.right.val) return false;      
        return test(root.left, root.right); 
    }
	
	public boolean test(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.val != right.val) return false;		
		return test(left.left, right.right) && test(left.right, right.left);
	}

}
