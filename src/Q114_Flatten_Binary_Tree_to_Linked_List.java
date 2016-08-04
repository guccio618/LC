import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Q114_Flatten_Binary_Tree_to_Linked_List {
	// by other faster, in place	
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
	
	// by ninechapter
	private TreeNode preNode = null;
	
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        if (preNode != null) {
            preNode.left = null;
            preNode.right = root;
        }

        preNode = root;
        TreeNode right = root.right;
        flatten2(root.left);
        flatten2(right);
    }
	
	
	
	// by Jackie
	public void flatten3(TreeNode root) {   
		if(root == null) {
        	return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
    
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                q.add(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        
        root = q.poll();
        while(!q.isEmpty()){
            root.left = null;
            root.right = q.poll();
            root = root.right;
        }
    }
}
