/****************************************************************
 * Given a singly linked list where elements are sorted in 
 * ascending order, convert it to a height balanced BST.
 ****************************************************************/

public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {
	// by other
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode endMarker = null;
        while(fast != null && fast.next != null){  // 两个指针用不同速度跑，找list的中点
            endMarker = slow;                      // 处理两个不同速度的指针，将list分成两段
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(endMarker != null)   //marking end point of first list
            endMarker.next = null;  
        else
            head = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
