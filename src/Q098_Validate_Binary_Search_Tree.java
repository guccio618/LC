import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Q098_Validate_Binary_Search_Tree {
	// by other using inorder_recursive
	long tmp =Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root != null){
            boolean left = isValidBST(root.left);
            if(root.val<=tmp)
                return false;
            tmp = root.val;
            boolean right = isValidBST(root.right);
            if(!left || !right)
                return false;
        }
        return true;
    }
	
	
	// by jackie, 135ms, inorder
	public boolean isValidBST_2(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        int preVal = Integer.MIN_VALUE;
        int flag = 0;
        
        while(root != null || !s.isEmpty()){
        	while(root != null){
        		s.push(root);
        		root = root.left;
        	}
        	root = s.pop();
        	System.out.println("val = " + root.val);
        	if(flag == 0){
        		flag = 1;
        		preVal = root.val;
        	}
        	else{
        		if(preVal >= root.val)
        			return false;
        		preVal = root.val;
        	}
        	root = root.right;
        }
        return true;
    }
	
	// by other
		public boolean isValidBST_3(TreeNode root) {
			return isValidBSTHelper(root, null, null);
		}

		private boolean isValidBSTHelper(TreeNode root, Integer leftBound,
				Integer rightBound) {
			// recursively pass left and right bounds from higher level to lower
			// level
			if (root == null) {
				return true;
			}
			if (leftBound != null && root.val <= leftBound || rightBound != null && root.val >= rightBound) {
				return false;
			}
			return isValidBSTHelper(root.left, leftBound, root.val) && isValidBSTHelper(root.right, root.val, rightBound);
		}
	
	public static void main(String[] args){
		Q098_Validate_Binary_Search_Tree t = new Q098_Validate_Binary_Search_Tree();
		TreeNode root = new TreeNode(-2147483648);
		root.left = null;
		root.right = new TreeNode(-2147483648);
		System.out.println(t.isValidBST(root)); //[-2147483648,-2147483648]
	}
}
