public class Q222_Count_Complete_Tree_Nodes {
	/********************************
	 * 按左右子树进行划分，斜着拆分 *
	 *********************************/
	// by other, simple.
	public int countNodes(TreeNode root) {
		int h = height(root);
		int nodeCount = 0;

		while (root != null) {
			if (height(root.right) == h - 1) { // Left is full. Add left plus
												// root.
				nodeCount += (1 << h); // 2^(h) - 1 + 1
				root = root.right;
			} else { // Right is full. Add right plus root.
				nodeCount += (1 << h - 1);
				root = root.left;
			}
			h--;
		}
		return nodeCount;
	}

	public int height(TreeNode root) {
		if (root == null)
			return -1;
		return 1 + height(root.left);
	}
	

	/****************************************
	 * 先算level 1到 last-1，再算last level *
	 ****************************************/
	// by other, fast
	public int countNodes2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return 1;
		int height = 0;
		int nodesSum = 0;
		TreeNode curr = root;
		while (curr.left != null) {
			nodesSum += (1 << height);
			height++;
			curr = curr.left;
		}
		return nodesSum + countLastLevel(root, height);
	}

	private int countLastLevel(TreeNode root, int height) {
		if (height == 1) {
			if (root.right != null)
				return 2;
			else if (root.left != null)
				return 1;
			else
				return 0;
		}

		TreeNode midNode = root.left;
		int currHeight = 1;
		while (currHeight < height) {
			currHeight++;
			midNode = midNode.right;
		}
		if (midNode == null)
			return countLastLevel(root.left, height - 1);
		else
			return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
	}
	

	/********************************
	 * 非二叉搜索 *
	 ********************************/
	// by Jackie, but exceed time limited
	public int countNodes3(TreeNode root) {
		if (root == null)
			return 0;
		int count = 1;
		if (root.left != null)
			count += countNodes3(root.left);
		if (root.right != null)
			count += countNodes3(root.right);
		return count;
	}
}