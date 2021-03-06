
public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	// by Jackie
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root; 
        } else if(p == null){
            return q;
        } else if(q == null){
            return p;
        }
        
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
	
	// by jackie 
	// 从root向下遍历，如果node.val值在p和q的值之间，则此node即为最低的公共父节点
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;    
        if(p == null) return q;
        if(q == null) return p;
        
        TreeNode pos = root;
        int large = Math.max(p.val, q.val);
        int small = Math.min(p.val, q.val);
        while((pos != null && pos.val < small) || (pos != null && pos.val > large)){
            if(pos.val < small)
                pos = pos.right;
            else
                pos = pos.left;
        }
        return pos;
    }
	
	public static void main(String[] args){
		Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree t = new Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();  
		TreeNode root = new TreeNode(4);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(5);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(3);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	
    	TreeNode res = t.lowestCommonAncestor(root, root.left.left, root.left.left);
    	System.out.println(res.val);
	}
}
