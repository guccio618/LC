
public class Q099_Recover_Binary_Search_Tree {
	private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);     // 注意这里初始化为最小值 ！！！
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (firstElement == null && root.val < lastElement.val) { // 第一个错误的还未找到，且当前的val小于前一个val
            firstElement = lastElement;
            System.out.println("1");
        }
        if (firstElement != null && root.val < lastElement.val) { // 第一个错误的已找到，且当前的val小于前一个val
            secondElement = root;
            System.out.println("2");
        }
        System.out.println("3");
        lastElement = root;
        traverse(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        // traverse and get two elements
        traverse(root);
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    
    
    public static void main(String[] args){
    	Q099_Recover_Binary_Search_Tree t = new Q099_Recover_Binary_Search_Tree();
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(6);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(2);
    	root.left.right = new TreeNode(4);
    	t.recoverTree(root);
    }
}
