import java.util.ArrayList;
import java.util.Stack;


public class Q114_Flatten_Binary_Tree_to_Linked_List {
	public void flatten(TreeNode root) {   // by jackie
        if(root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
    
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                temp.add(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        
        root = temp.get(0);
        for(int i = 1; i < temp.size(); i++){
            root.left = null;
            root.right = temp.get(i);
            root = root.right;
        }
        root = temp.get(0);
    }
}
