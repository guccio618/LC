
public class Q206_Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head, cur_next = current.next, r = null;
        
        while(cur_next != null){
            r = cur_next.next;
            cur_next.next = current;
            current = cur_next;
            cur_next = r;
        }
        head.next = null;
        return current;
    }
}
