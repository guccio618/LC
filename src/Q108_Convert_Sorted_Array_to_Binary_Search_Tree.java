import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**********************************************
(1).iterative
(2).Arrays.copyOfRange()的使用;
/**********************************************/


public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public TreeNode sortedArrayToBST_recursive(int[] nums) {  //by other using recursive
        if(nums.length == 0)return null;
        int ptr = nums.length/2;
        TreeNode root = new TreeNode(nums[ptr]);
        root.left = sortedArrayToBST_recursive(Arrays.copyOfRange(nums,0,ptr));
        root.right = sortedArrayToBST_recursive(Arrays.copyOfRange(nums,ptr+1,nums.length));
        return root;
    }

//*************************************************  by NineChapter	
	
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) return null;
        return buildTree(num, 0, num.length - 1);
    }
    
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }

//************************************************  by other using iterative

	public TreeNode sortedArrayToBST_iterative(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;

		// 0 as a placeholder
		TreeNode head = new TreeNode(0);

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {
			{
				push(head);
			}
		};
		Deque<Integer> leftIndexStack = new LinkedList<Integer>() {
			{
				push(0);
			}
		};
		Deque<Integer> rightIndexStack = new LinkedList<Integer>() {
			{
				push(len - 1);
			}
		};

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid = left + (right - left) / 2; // avoid overflow
			currNode.val = nums[mid];
			if (left <= mid - 1) {
				currNode.left = new TreeNode(0);
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid - 1);
			}
			if (mid + 1 <= right) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid + 1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}
}

	
