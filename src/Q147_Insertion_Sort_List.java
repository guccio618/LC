
public class Q147_Insertion_Sort_List {
	// by ninechapter
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
            return head;
        }
        
        ListNode current = head;
        ListNode dummy = new ListNode(0), p;
        
        while(current != null){
            p = dummy;
            
            while(p.next != null && p.next.val < current.val){
                p = p.next;
            }
            
            ListNode pNext = p.next;
            p.next = current;
            ListNode next = current.next;
	        current.next = pNext;
	        current = next;
        }
        
        return dummy.next;
    }
}
