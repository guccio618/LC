
public class Q124_Binary_Tree_Maximum_Path_Sum {
	//by ninechapter
	public int maxPathSum(TreeNode root) {
        resultTuple res = getResult(root);
        return res.maxPath;
    }
    
    public resultTuple getResult(TreeNode root){
        if(root == null)
            return new resultTuple(0, Integer.MIN_VALUE);
            
        resultTuple left = getResult(root.left);
        resultTuple right = getResult(root.right);
        
        int maxSinglePath = Math.max(left.maxSinglePath, right.maxSinglePath) + root.val;
        maxSinglePath = Math.max(maxSinglePath , 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.maxSinglePath + right.maxSinglePath + root.val);
        return new resultTuple(maxSinglePath, maxPath);        
    }
    
    class resultTuple{
        private int maxPath;
        private int maxSinglePath;
            
        public resultTuple(int s, int p){
            maxSinglePath = s;
            maxPath = p;
        }
    }
}
