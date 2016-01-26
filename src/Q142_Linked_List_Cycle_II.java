import java.util.HashSet;
import java.util.Set;


public class Q142_Linked_List_Cycle_II {
	/*********************************************************/
	// by ninechapter using two points
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } 
        
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
	
	
	/*********************************************************/
	// by Jackie but time limit exceeded
	public ListNode detectCycle2(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet<ListNode>();
        set.add(head);
        ListNode start = head;
        ListNode end = head.next;
        
        while(end != null){
            start = start.next;
            end = end.next;
            if(set.contains(end)){
                return start;
            }
        }
        return null;
    }
}
