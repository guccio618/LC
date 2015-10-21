import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Q102_Binary_Tree_Level_Order_Traversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		//List<List<Integer>> res = new ArrayList<List<Integer>>();   //原式子这样写
		
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> temp_list = new ArrayList<Integer>();
        int count = 1;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp_list.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(--count == 0){
                count = queue.size();
                res.add(new ArrayList(temp_list));
                temp_list.clear();
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		Q102_Binary_Tree_Level_Order_Traversal bt = new Q102_Binary_Tree_Level_Order_Traversal();
		TreeNode root = new TreeNode(1);
		ArrayList<ArrayList<Integer>> res = bt.levelOrder(root);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}

