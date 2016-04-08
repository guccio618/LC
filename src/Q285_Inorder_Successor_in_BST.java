import java.util.Stack;


public class Q285_Inorder_Successor_in_BST {
	// by Jackie
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return p;
        }
        
        boolean isFound = false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            if(isFound == true){
                return root;
            }
            if(p == root){
                isFound = true;
            }
            
            root = root.right;
        }
        
        return null;
    }
}
