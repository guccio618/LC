import java.util.ArrayList;


public class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree {	
	/***************   by other using recursive   *****************/
	// 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
	public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) 
            return root;
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if (left != null && right != null)  // 同时找到p和q，返回root；在下次的迭代中，root的兄弟必为null,
            return root;                    // 如root在left, 则right必为null
        if (left != null && right == null)  // 只找到left
            return left;
        if (right != null && left == null)  // 只找到right
            return right;
        
        return null;   // left == null && right == null
	}
	
	/***************   by other using finding path (non_recursive)   *****************/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
	    if(root==null) return null;
	    if(p==null || q==null)  return null;
	    ArrayList<TreeNode> p_path = new ArrayList<TreeNode>();
	    ArrayList<TreeNode> q_path = new ArrayList<TreeNode>();
	    findPath(root, p, p_path);
	    findPath(root, q, q_path);
	    int min_len = Math.min(p_path.size(), q_path.size());
	    int LCA = 0;
	    for(int i=0; i<min_len; i++){
	        if(p_path.get(i)==q_path.get(i))
	            LCA = i;
	    }return p_path.get(LCA);

	}
	public static boolean findPath(TreeNode root, TreeNode n1, ArrayList<TreeNode> path){
	    if(root == null)
	    	return false;
	    
	    path.add(root);	    
	    if(root == n1)
	        return true;
	    
	    if(findPath (root.left, n1, path) || findPath(root.right, n1, path))
	        return true;
	    
	    path.remove(path.size() - 1);
	    return false;
	}
}
