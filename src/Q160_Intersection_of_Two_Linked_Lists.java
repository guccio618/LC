
public class Q160_Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {   //by other
        if(headA == null || headB == null) return null;
        ListNode pos1 = headA, pos2 = headB;
        int len1 = 1, len2 = 1, distent = 0;
        while(pos1 != null){
            pos1 = pos1.next;
            len1++;
        }
        while(pos2 != null){
            pos2 = pos2.next;
            len2++;
        }
        distent = len1 - len2;
        pos1 = headA; 
        pos2 = headB;
        if(distent > 0)
        	while(distent-- > 0)
        		pos1 = pos1.next;
        else
        	while(distent++ < 0)
        		pos2 = pos2.next;
        while(pos1 != null){
            if(pos1 == pos2)
                return pos1;
            pos1 = pos1.next;
            pos2 = pos2.next;
        }
        return pos1;
    }
	
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.Insert(a, 3);
		a.Insert(a, 5);
		a.Insert(a, 7);
		a.Insert(a, 9);
		a.Insert(a, 11);
		a.Insert(a, 13);
		a.Insert(a, 15);
		a.Insert(a, 17);
		a.Insert(a, 19);
		a.Insert(a, 21);
		a.Display(a);
		b.Display(b);
		Q160_Intersection_of_Two_Linked_Lists it = new Q160_Intersection_of_Two_Linked_Lists();
		it.getIntersectionNode(a, b);
	}
}
