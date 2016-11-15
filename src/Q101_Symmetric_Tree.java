import java.util.*;

public class Q101_Symmetric_Tree {
	// test case:
    // root == null
    
	// iterator
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            if(left == null && right == null) {
                continue;
            } else if(left == null || right == null) {
                return false;
            } else if(left.val != right.val) {
                return false;
            }
            
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        
        return true;
    }
    
    // recursion
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if(n1 == null || n2 == null) {
            if(n1 == null && n2 == null) {
                return true;
            } else {
                return false;
            }
        } else if(n1.val != n2.val) {
            return false;
        }
        
        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
    
    
    // follow up: get a mirror of a tree
    public TreeNode getMirror(TreeNode root) {
    	if(root == null) {
    		return root;
    	}
    	
    	TreeNode left = getMirror(root.left);
    	TreeNode right = getMirror(root.right);
    	root.left = right;
    	root.right = left;
    	return root;
    }
    
    
    
    
    
    
    
    
    
    
    public void DFS(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	while(!stack.isEmpty() || root != null) {
    		while(root != null) {
    			System.out.print(root.val + " ");
    			stack.push(root);
    			root = root.left;
    		}
    		
    		root = stack.pop();
    		root = root.right;
    	}
    	
    	System.out.println();
    }
    
    public void BFS(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int size = 1;
    	
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		System.out.print(node.val + " ");
    		
    		if(node.left != null) {
    			queue.offer(node.left);
    		}
    		
    		if(node.right != null) {
    			queue.offer(node.right);
    		}
    		
    		if(--size == 0) {
    			size = queue.size();
    			System.out.println();
    		}
    	}
    }
    
    
    public static void main(String[] args) {
    	Q101_Symmetric_Tree t = new Q101_Symmetric_Tree();
    	
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(3);
    	root.left.left = new TreeNode(2);
    	root.left.right = new TreeNode(4);
    	
    	root.right = new TreeNode(7);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(8);
    	
    	t.BFS(root);
    	root = t.getMirror(root);
    	t.BFS(root);
    }
    

}
