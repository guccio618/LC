
public class Q234_Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode front_loc = head, back_loc = head;
        int count = 1;
        
        while(front_loc.next != null){
            count++;
            front_loc = front_loc.next;
            if(count > 2 && count % 2 == 0)
                back_loc = back_loc.next;
        }
        if(count == 2) front_loc = head.next;
        else if(count == 3) front_loc = head.next.next;
        else if(count > 3){  
            if(count % 2 != 0) back_loc = back_loc.next;
            ListNode current = back_loc.next, cur_next = current.next, r = null;
            while(cur_next != null){
                r = cur_next.next;
                cur_next.next = current;
                current = cur_next;
                cur_next = r;
            }
            back_loc.next.next = null;
            back_loc.next = current;
            front_loc = back_loc.next;
            back_loc = head;
        }

        for(int i = 0; i < count/2; i++){
            if(back_loc.val != front_loc.val) return false;
            back_loc = back_loc.next;
            front_loc = front_loc.next;
        }
        return true;
    }
	
	
	public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("slow = " + slow.val);
        }
        
        System.out.println("l1:" + slow.val);
        System.out.println("l2:" + slow.next.val);
        
        ListNode l1 = dummy.next;
        ListNode l2 = reverse(slow.next);
   
//
//        System.out.println("l2:" + l2.val);
        
        while(l1 != null && l2 != null){
            if(l2.val != l1.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode current = head;
        ListNode curNext = current.next;
        ListNode curNextNext = curNext.next;
        
        while(curNextNext != null){
            curNext.next = current;
            current = curNext;
            curNext = curNextNext;
            curNextNext = curNextNext.next;
        }
        
        curNext.next = current;
        head.next = null;
        return curNext;
    }
	
	
	public static void main(String[] args){
		Q234_Palindrome_Linked_List p = new Q234_Palindrome_Linked_List();
		ListNode head = new ListNode(1);
		head.Insert(head, 1);
		head.Insert(head, 0);
		head.Insert(head, 0);
		head.Insert(head, 1);
		if(p.isPalindrome2(head)) System.out.println("yes");
		else System.out.println("no");
	}
}
