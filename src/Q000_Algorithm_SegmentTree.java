import java.util.ArrayList;


public class Q000_Algorithm_SegmentTree {
	public class SegmentTreeNode {
		public int start, end;
		public int max;
		public SegmentTreeNode left, right;
		
		public SegmentTreeNode(int start, int end, int max) {
			this.start = start;
			this.end = end;
			this.max = max;
			this.left = this.right = null;
		}
	}
	
	public SegmentTreeNode build(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }
	
	public SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end){
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }
        
        SegmentTreeNode node = new SegmentTreeNode(start, end, nums[start]);  // 先随便给一个max值
        int mid = (start + end) / 2;
        node.left = this.buildTree(start, mid, nums);
        node.right = this.buildTree(mid + 1, end, nums);
        node.max = Math.max(node.left.max, node.right.max);     // 从左右子树中寻找最大的max，作为当前max的值
   
        return node;
    }
	
	public int query(SegmentTreeNode root, int start, int end) {
        if(start == root.start && root.end == end) { // 相等 
            return root.max;
        }
              
        int mid = (root.start + root.end)/2;
        int leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;
        // 左子区
        if(start <= mid) {
            if( mid < end) { // 分裂 
                leftmax = query(root.left, start, mid);
            } else { // 包含 
                leftmax = query(root.left, start, end);
            }
            // leftmax = query(root.left, start, Math.min(mid,end));
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightmax = query(root.right, mid+1, end);
            } else { //  包含 
                rightmax = query(root.right, start, end);
            }
            //rightmax = query(root.right, Math.max(mid+1,start), end);
        }  
        // else 就是不相交
        return Math.max(leftmax, rightmax);
    }
	
	public void modify(SegmentTreeNode root, int index, int value) {
        if(root.start == index && root.end == index) { // 查找到
            root.max = value;
            return;
        }
        
        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <= mid) {
            modify(root.left, index, value);
        }
        if(mid < index && index <= root.end) {
        	modify(root.right, index, value);
        }
               
        //更新
        root.max = Math.max(root.left.max, root.right.max);
    }
}
