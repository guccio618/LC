

public class Q002_Add_Two_Numbers {	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
        if(l2 == null) return l1;
        int sum = l1.val + l2.val;
        int cnt_flag = sum / 10;
        sum %= 10;
        ListNode head = new ListNode(sum), temp_locate = head;
        l1 = l1.next;
        l2 = l2.next;

        while(l1 != null || l2 != null){
        	sum = 0;
        	if(l1 != null) {
        		sum += l1.val;
        		l1 = l1.next;
        	}
        	if(l2 != null) {
        		sum += l2.val;
        		l2 = l2.next;
        	}	
            sum += cnt_flag;
            cnt_flag = sum / 10;
            sum %= 10;
            temp_locate.next = new ListNode(sum);
            temp_locate = temp_locate.next;
        }
        if(cnt_flag > 0){
        	temp_locate.next = new ListNode(cnt_flag);
        }
        return head;
    }
	
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		Q002_Add_Two_Numbers a = new Q002_Add_Two_Numbers();
		l1.Insert(l1, 9);
		l1.Display(l1);
		l2.Display(l2);
		ListNode l3 = a.addTwoNumbers(l1, l2);
		l3.Display(l3);		
	}
}


class ListNode {	
	int val;
	ListNode next;
	ListNode(int x) {val = x;}

	void Insert(ListNode head, int val) {
		ListNode in = new ListNode(val);
		ListNode locate = head;
		while (locate.next != null)
			locate = locate.next;
		in.next = locate.next;
		locate.next = in;
	}

	void Display(ListNode head) {
		ListNode locate = head;
		while (locate != null) {
			System.out.print(locate.val + " ");
			locate = locate.next;
		}
		System.out.println();
	}
}
