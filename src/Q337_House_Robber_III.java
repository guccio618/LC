
public class Q337_House_Robber_III {
	// by other
	public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
	
	public int[] dfs(TreeNode node){
		if(node == null){
			return new int[2];
		}
		
		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		int[] ans = new int[2];
		ans[0] = left[1] + right[1] + node.val;
		ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return ans;
	}
}
