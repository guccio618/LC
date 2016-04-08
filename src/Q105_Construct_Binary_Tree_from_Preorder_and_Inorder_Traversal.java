import java.util.HashMap;
import java.util.Map;


public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	// by other
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}

	public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(preStart > preEnd || inStart > inEnd) {   // 注意退出条件！！！
	    	return null;
	    }
	    // root表示当前子树的根结点
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;

	    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

	    return root;
	}
	
	public static void main(String[] args){
		Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal t = new Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
    	int[] preorder = {1,2,3};
		int[] inorder = {1,2,3};
    	
    	TreeNode root = t.buildTree(preorder, inorder);    	
    }

}
