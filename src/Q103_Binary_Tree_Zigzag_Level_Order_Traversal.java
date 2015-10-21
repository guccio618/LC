import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*********************************************/
/***              3 Starts                 ***/
/*********************************************/

public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
	// done by other
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp_list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return res;
        boolean lToR_flag = true;
        int num_in_level = 1;         //计算当前层里还有多少个节点未被遍历，nice！

        queue.add(root);
        while(queue.size() != 0){
            TreeNode node = queue.poll();
            if(lToR_flag)
                temp_list.add(node.val);
            else
                temp_list.add(0,node.val);

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            if(--num_in_level == 0){
                num_in_level = queue.size();
                res.add(new ArrayList(temp_list));   //注意，要new一个空间，否则函数返回后，空间回收，值不会保留
                temp_list.clear();
                lToR_flag = !lToR_flag;
            }
        }
        return res;
    }
}
