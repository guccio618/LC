public class Q086_Partition_List {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;
		ListNode node = head;

		while (node != null) {
			if (node.val < x) {
				p1.next = node;
				p1 = p1.next;
			} else {
				p2.next = node;
				p2 = p2.next;
			}
			node = node.next;
		}

		p1.next = null;     // 注意这两个结尾处的处理！！！
		p2.next = null;     // 注意这两个结尾处的处理！！！
		
		if (dummy1.next == null) {
			return dummy2.next;
		} else if (dummy2.next == null) {
			return dummy1.next;
		} else {
			p1.next = dummy2.next;
			
			return dummy1.next;
		}
	}
	
	
	
	public static void main(String[] args){
		Q086_Partition_List t = new Q086_Partition_List();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		ListNode res = t.partition(head, 2);
		
		while(res != null){
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
}
