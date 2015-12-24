import java.util.ArrayList;
import java.util.Stack;

public class Q129_Sum_Root_to_Leaf_Numbers {
	private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        preOrder(root, 0);
        return sum;
    }
    
    public void preOrder(TreeNode node, int n){
        if(node == null) return;
        n = n*10 + node.val;
        preOrder(node.left, n);
        preOrder(node.right, n);
        
        if(node.left == null && node.right == null){
        	sum += n;
        	System.out.println("n = " + n);
        }
    }	
    
    public static void main(String[] args){
    	Q129_Sum_Root_to_Leaf_Numbers t = new Q129_Sum_Root_to_Leaf_Numbers();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	System.out.println(t.sumNumbers(root));
    }
}
