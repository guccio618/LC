
public class Q082_Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode new_head = new ListNode(0), loc = new_head;
        new_head.next = head;
        
        while(head.next != null){
            if(head.val == head.next.val){
                while(head.next != null && head.val == head.next.val)
                    head.next = head.next.next;
                if(head.next != null){
                    head = head.next;
                    loc.next = head;
                }
                else
                    loc.next = null;
            }
            else{
                loc = loc.next;
                head = head.next;
            }
        }
        return new_head.next;
    }
}
