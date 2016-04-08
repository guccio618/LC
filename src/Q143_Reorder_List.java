import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Q143_Reorder_List {
	/***********************************************/
	// by Jackie using stack
	public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode start = head;
        slow = slow.next;
        
        while(slow != null){
            s.push(slow);
            slow = slow.next;
        }
        
        while(!s.isEmpty()){
            ListNode temp = s.pop();
            temp.next = start.next;
            start.next = temp;
            start = start.next.next;
        }

        start.next = null;
    }
	

	
	/***********************************************/
	// by Jackie using stack
	public ListNode reorderList2(ListNode head) {  
        if(head == null || head.next == null){
        	return head;
        }
        Stack<ListNode> s1 = new Stack<>();       
        ListNode front = head, back = head , temp;
        int len = 1;
        while(front.next != null){
        	len++;
        	front = front.next;
        	if(len > 2 && len % 2 == 0)
        		back = back.next;
        }
        back = back.next;
        if(len % 2 != 0) 
        	back = back.next;
        while(back != null){
        	s1.push(back);
        	back = back.next;
        }
        front = head;
        while(!s1.isEmpty()){
        	temp = s1.pop();
        	System.out.println(temp.val);
        	temp.next = front.next;
        	front.next = temp;
        	if(s1.isEmpty()){
        		if(len % 2 != 0) 
        			front = front.next;
        		front = front.next;
        		front.next = null;       		
        	}
        	else{
        		front = front.next.next;
//        		front = front.next;
        	}
        }
        return head;
    }
	
	
	
	public static void main(String[] args){
		Q143_Reorder_List r = new Q143_Reorder_List();
//		ListNode head = new ListNode(1);
//		ListNode node = head;
//		node.next = new ListNode(2);
//		node = node.next;
//		node.next = new ListNode(3);
//		node = node.next;
//		node.next = new ListNode(4);
//		node = node.next;
		
		
		ListNode head = new ListNode(1);
		head.Insert(head, 2);
		head.Insert(head, 3);
		head.Insert(head, 4);
		head.Insert(head, 5);
		head.Insert(head, 6);
		head.Insert(head, 7);
		head.Insert(head, 8);
		head.Insert(head, 9);
		r.reorderList(head);
		head.Display(head);		
	}
}
