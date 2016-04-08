import java.util.ArrayList;


public class Q257_Binary_Tree_Paths {
	public ArrayList<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> res = new ArrayList<String>();
        if(root == null) return res;
        preOrder(root, res, "");
        return res;
    }
	
    // 前序遍历，直至所有的子树均为null，此时即得到一条路径
    public void preOrder(TreeNode node, ArrayList<String> res, String str){
        if(node == null) {
        	return;
        }
        
        if(str.equals(""))
        	str +=  node.val;
        else
        	str = str + "->" + node.val;
        String tempStr = str;          // tempStr用于记录访问到当前node时的路径

        if(node.left == null && node.right == null)
            res.add(str);        
        if(node.left != null)
        	preOrder(node.left, res, tempStr);
        if(node.right != null)     	
        	preOrder(node.right, res, str);
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	Q257_Binary_Tree_Paths t = new Q257_Binary_Tree_Paths();
    	ArrayList<String> res = t.binaryTreePaths(root);
    	
    	for(int i = 0; i < res.size(); ++i)
    		System.out.println(res.get(i));
    }   
}
