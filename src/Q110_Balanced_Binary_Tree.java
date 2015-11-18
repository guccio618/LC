
public class Q110_Balanced_Binary_Tree {	
	public boolean isBalanced(TreeNode root) {
        return getDepth(root) > -1;
    }
    
    public int getDepth(TreeNode node){
        if(node == null) return 0;
        int left = getDepth(node.left);            // conquer，先从最底层开始
        int right = getDepth(node.right);   
        if(left == -1 || right == -1) return -1;   // 如果子树中有non-balance的，则此节点也为non-balance,返回－1
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
