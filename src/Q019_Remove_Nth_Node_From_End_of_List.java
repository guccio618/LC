
public class Q019_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode current = new ListNode(0), front = head, temp;
        ListNode new_head = current;
        current.next = head;
        for(int i = 0; i < n; i++)
            front = front.next;
        while(front != null){
            current = current.next;
            front = front.next;
        }
        temp = current.next.next;
        current.next = temp;
        return new_head.next;
    }
}
