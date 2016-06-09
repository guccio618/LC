import java.util.HashSet;
import java.util.Set;


public class Q142_Linked_List_Cycle_II {
	/*********************************************************/
	// by ninechapter using two points
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null){
            return null;
        }
        
        ListNode faster = head.next, slower = head;
        
        while(faster != null && faster.next != null && faster != slower){
            faster = faster.next.next;
            slower = slower.next;
        }
        
        if(faster != slower){
            return null;
        } else {
            faster = head;
            while(faster != slower.next){
                faster = faster.next;
                slower = slower.next;
            }
            return faster;
        }
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
