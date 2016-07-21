
public class Q160_Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode traver1 = headA;
        ListNode traver2 = headB;
        int len1 = 0, len2 = 0;
        
        while(traver1 != null){
            len1++;
            traver1 = traver1.next;
        }
        
        while(traver2 != null){
            len2++;
            traver2 = traver2.next;
        }
        
        int diff = Math.abs(len1 - len2);
        traver1 = headA;
        traver2 = headB;
        
        for(int i = 0; i < diff; i++){
            if(len1 > len2){
                traver1 = traver1.next;
            } else {
                traver2 = traver2.next;
            }
        }
        
        while(traver1 != null && traver2 != null && traver1 != traver2){
            traver1 = traver1.next;
            traver2 = traver2.next;
        }
        
        if(traver1 != null && traver2 != null){
            return traver1;
        } else {
            return null;
        }
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
