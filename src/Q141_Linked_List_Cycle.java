
public class Q141_Linked_List_Cycle {
	// by ninechapter
	public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;    // 注意错开，fast = head.next
        slow = head;
        while (fast != slow) {
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
    }
}
