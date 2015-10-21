import java.util.Stack;


public class Q061_Rotate_List {
	public ListNode rotateRight(ListNode head, int k) {  //by jackie
        if(head == null || head.next == null || k == 0) return head;
        ListNode front_loc = head, back_loc = head;
        int len = 1;
        for(int i = 0; i < k; i++){
            if(front_loc.next == null){
                front_loc = head;
                if(k == len) return head;
                k %= len;
                for(int j = 0; j < k; j++)
                    front_loc = front_loc.next;
                break;    
            } 
            len++;
            front_loc = front_loc.next;
        }
        while(front_loc.next != null){
            front_loc = front_loc.next;
            back_loc = back_loc.next;
        }
        front_loc.next = head;
        head = back_loc.next;
        back_loc.next = null; 
        return head;
    }

	public ListNode rotateRight_2(ListNode head, int k) { // by other
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode current = head;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		int rotations = stack.size() == 0 ? 0 : k % stack.size();
		for (int i = 0; i < rotations; i++) {
			ListNode node = stack.pop();
			ListNode last = stack.peek();
			last.next = null;
			node.next = head;
			head = node;
		}
		return head;
	}
	
	public static void main(String[] args){
		Q061_Rotate_List r = new Q061_Rotate_List();
		ListNode head = new ListNode(1);
		head.Insert(head, 2);
		head.Insert(head, 3);
		head.Insert(head, 4);
		head.Insert(head, 5);
		ListNode temp = r.rotateRight(head, 2);
		temp.Display(temp);
	}
}
