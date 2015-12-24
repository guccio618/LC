import java.util.LinkedList;


public class Q113_Path_Sum_II {
	LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
    int sum;
    
    public LinkedList<LinkedList<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        LinkedList<Integer> path = new LinkedList<Integer>();
        if(root == null) return res;
        dfs(root, 0, path);
        return res;
    }
    
    public void dfs(TreeNode current, int curSum, LinkedList<Integer> path){
        path.add(current.val);    // 加入当前节点，当本次递归执行完毕后，再移除
        curSum += current.val;
        if(current.left == null && current.right == null){
            if(curSum == sum) {
            	LinkedList<Integer> list = new LinkedList<Integer>(path);
                res.add(list);
            }
        }
        if(current.left!=null)
            dfs(current.left, curSum, path);
        if(current.right!=null)
            dfs(current.right, curSum, path);
        path.remove(path.size()-1);    // 移除当前节点
    }
    
    
    
    
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(5);   	
    	
    	root.left = new TreeNode(4);
    	root.left.left = new TreeNode(11);
    	root.left.left.left = new TreeNode(7);
    	root.left.left.right = new TreeNode(2);
    	
    	root.right = new TreeNode(8);
    	root.right.left = new TreeNode(13);
    	root.right.right = new TreeNode(4);
    	root.right.right.left = new TreeNode(5);
    	root.right.right.right = new TreeNode(1);
    	
    	Q113_Path_Sum_II t = new Q113_Path_Sum_II();
    	LinkedList<LinkedList<Integer>> res = t.pathSum(root, 22);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
