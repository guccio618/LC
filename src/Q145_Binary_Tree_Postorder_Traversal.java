import java.util.ArrayList;
import java.util.Stack;


public class Q145_Binary_Tree_Postorder_Traversal {
	//use two stacks
	public ArrayList<Integer> postorderTraversal_2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);

		while (!s1.isEmpty()) {
			TreeNode node = s1.pop();
			s2.push(node);
			if (node.left != null) s1.push(node.left);
			if (node.right != null) s1.push(node.right);
		}
		
		while (!s2.isEmpty())
			res.add(s2.pop().val);

		return res;
	}
	
	//recursive
	public ArrayList<Integer> postorderTraversal_recursive(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();   //必须要使用一个temp来接受传递出来的值
        
        if(root != null){          
            temp = postorderTraversal_recursive(root.left);
            for(int i = 0; i < temp.size(); i++)
                res.add(temp.get(i));
            temp.clear();
            temp = postorderTraversal_recursive(root.right);
            for(int i = 0; i < temp.size(); i++)
                res.add(temp.get(i));
            temp.clear();
            res.add(root.val);
        }
        return res;
	}
}
