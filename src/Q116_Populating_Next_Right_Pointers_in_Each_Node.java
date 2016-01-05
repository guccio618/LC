import java.util.LinkedList;
import java.util.Queue;


public class Q116_Populating_Next_Right_Pointers_in_Each_Node {
	/*********************************************************/
	// by other using iterator
	public void connect(TreeLinkNode root) {
		TreeLinkNode left = root;
		TreeLinkNode current = root;
		while (left != null) {
			left = current.left;
			if (left == null)
				break;
			while (current != null) {
				current.left.next = current.right;
				current.right.next = current.next == null ? null : current.next.left;
				current = current.next;
			}
			current = left;
		}
	}
	
	
	/*********************************************************/
	// by other
	public void connect2(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;
		TreeLinkNode current = root;
		connectNodes(current);
	}

	public void connectNodes(TreeLinkNode current) {
		if (current == null || (current.left == null && current.right == null))
			return;
		current.left.next = current.right;
		if (current.next != null)
			current.right.next = current.next.left;
		else
			current.right.next = null;
		connectNodes(current.left);
		connectNodes(current.right);
	}
    
    
	/*********************************************************/
	// by Jackie
	public void connect3(TreeLinkNode root) {
        if(root == null) return;
        int levelNum = 1;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeLinkNode tempNode = q.poll();
            TreeLinkNode nextNode = q.peek();
            if(tempNode.left != null)
                q.add(tempNode.left);
            if(tempNode.right != null)
                q.add(tempNode.right);
            if(--levelNum == 0){
                levelNum = q.size();
                tempNode.next = null;
            }
            else
                tempNode.next = nextNode;
        }
    }
	
	
	public static void main(String[] args){
		Q116_Populating_Next_Right_Pointers_in_Each_Node t = new Q116_Populating_Next_Right_Pointers_in_Each_Node();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right = new TreeLinkNode(3);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		t.connect(root);
		System.out.println(root.left.left.next.val);
	}

}

class TreeLinkNode {
	public int val;
	public TreeLinkNode left, right, next;
	public TreeLinkNode(int x) { val = x; }
}
