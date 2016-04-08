
public class Q110_Balanced_Binary_Tree {
	// by Jackie
	public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return (pathHelper(root) != -1);
    }
    
    public int pathHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        
        int left = pathHelper(node.left);
        int right = pathHelper(node.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){   // 只要有一个子树不符合，即为不符合
            return -1;
        } else {
            return Math.max(pathHelper(node.left), pathHelper(node.right)) + 1;
        }
    }
}
