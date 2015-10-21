import java.util.LinkedList;
import java.util.Queue;


public class Q100_Same_Tree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        int count1 = 1, count2 = 1;
        q1.add(p);
        q2.add(q);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1.val == node2.val){
                if(node1.left == null && node2.left == null);
                else if(node1.left != null && node2.left != null && node1.val == node2.val);
                else return false;
                if(node1.right == null && node2.right == null);
                else if(node1.right != null && node2.right != null && node1.val == node2.val);
                else return false;
            }
            else return false;
            if(node1.left != null) q1.add(node1.left);
            if(node1.right != null) q1.add(node1.right);
            if(node2.left != null) q2.add(node2.left);
            if(node2.right != null) q2.add(node2.right);
            if(--count1 == 0) count1 = q1.size();
            if(--count2 == 0) count2 = q2.size();
        }
        if(q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }
}
