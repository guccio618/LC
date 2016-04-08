import java.util.List;
import java.util.ArrayList;


public class Q095_Unique_Binary_Search_Trees_II {
	public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        
        for(int i = start; i <= end; ++i){
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);
            for(TreeNode l : leftTree){
                for(TreeNode r : rightTree){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        
        return ans;
    }
	
	
	
	/*******************************   recursive + DP   ***********************************/
	// by other, Recursive with memoization
	// treesForRange used for store the sub-tree, 其为一个ArrayList的二维数组,
	// 存放从node i到j的所有可能的子树组合的ArrayList
	public ArrayList<TreeNode> generateTrees2(int n) {  
		ArrayList<TreeNode>[][] treesForRange = (ArrayList<TreeNode>[][]) new ArrayList[n+2][n+1];
        helper(1, n, treesForRange);
        return treesForRange[1][n];
    }

    private void helper(int left, int right, ArrayList<TreeNode>[][] treesForRange) {
        if (treesForRange[left][right] != null)        // 防止重复计算
            return;
        
        treesForRange[left][right] = new ArrayList<TreeNode>();
        if (left > right)                  // 边界时，等于null
            treesForRange[left][right].add(null);

        for (int root = left; root <= right; root++) {
            helper(left, root - 1, treesForRange);     // conquer
            helper(root + 1, right, treesForRange);
            for (TreeNode leftNode : treesForRange[left][root-1]) {        // 从左子树组合中取
                for (TreeNode rightNode : treesForRange[root+1][right]) {  // 从右子树组合中取
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    treesForRange[left][right].add(rootNode);        // 存入当前节点所在的ArrayList
                }
            }
        }       
    }   
    
    
    /*******************************   DP   ***********************************/
    // by other
    // DP, compute and store trees for intermediate ranges from 1 to n
    // time: exponential, since for each range the number of trees is combinatorial
    // space: O(n^2)
    public ArrayList<TreeNode> generateTrees3(int n) {
        if (n == 0) {
        	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        
        ArrayList<TreeNode>[][] treesForRange = (ArrayList<TreeNode>[][]) new ArrayList[n+2][n+1];
        for (int step = 0; step < n; step++) {
            for (int i = 1; i <= n - step; i++) {
                int j = i + step;
                treesForRange[i][j] = new ArrayList<TreeNode>();
                if (step == 0) {       // i = j, 子树就一个节点时
                    treesForRange[i][j].add(new TreeNode(i));
                    continue;
                }
                	// k is a possible root for range i-j
                	// two ugly if blocks for boundary cases:
                	// when k == i, the left subtree is null
                	// when k == j, the right subtree is null
                for (int k = i; k <= j; k++) {                
                    if (treesForRange[i][k-1] == null) {                                                
                        treesForRange[i][k-1] = new ArrayList<TreeNode>();                       
                        treesForRange[i][k-1].add(null);                    
                    }
                    if (treesForRange[k+1][j] == null) {
                        treesForRange[k+1][j] = new ArrayList<TreeNode>();
                        treesForRange[k+1][j].add(null);
                    }                    
                    for (TreeNode leftNode : treesForRange[i][k-1]) {
                        for (TreeNode rightNode : treesForRange[k+1][j]) {
                            TreeNode root = new TreeNode(k);
                            root.left = leftNode;
                            root.right = rightNode;
                            treesForRange[i][j].add(root);
                        }
                    }
                }
            }
        }
        return treesForRange[1][n];
    }
    
    public static void main(String[] args){
    	Q095_Unique_Binary_Search_Trees_II t = new Q095_Unique_Binary_Search_Trees_II();
    	ArrayList<TreeNode> list = (ArrayList<TreeNode>) t.generateTrees(3);
    	    }
}
