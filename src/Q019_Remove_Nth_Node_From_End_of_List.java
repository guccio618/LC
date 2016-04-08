
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
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null || n <= 0){
            return head;
        } 
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        int nodeNum = 0, count = 0;
        
        while(node != null){
            nodeNum++;
            node = node.next;
            System.out.println("in here");
        }
        
        if(n > nodeNum){
            return null;
        }
        
        node = dummy;
        for(int i = 0; i < nodeNum - 1 - n; ++i){
            node = node.next;
            System.out.println("1: in here");
        }
        
        node.next = node.next.next;
        return dummy.next;
    }
	
	
	public static void main(String[] args){
		Q019_Remove_Nth_Node_From_End_of_List t = new Q019_Remove_Nth_Node_From_End_of_List();
		ListNode head = new ListNode(1);
		ListNode res = t.removeNthFromEnd2(head, 1);
		if(res == null){
			System.out.println("null");
		} else {
			System.out.println("not null");
		}
		
	}
}
