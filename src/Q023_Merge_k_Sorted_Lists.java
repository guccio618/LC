import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q023_Merge_k_Sorted_Lists {
	/****************************************************/
	// by Jackie using divide & conquer
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        int len = lists.length;
        return mergeList(lists, 0, len - 1);
    }
    
    public ListNode mergeList(ListNode[] lists, int start, int end){
        if(start > end){
            return null;
        } else if(start == end){
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode leftHead = mergeList(lists, start, mid);
        ListNode rightHead = mergeList(lists, mid + 1, end);
        ListNode dummy = new ListNode(0);
        ListNode traver = dummy;
        
        while(leftHead != null || rightHead != null){
            if(leftHead != null && rightHead != null){
                if(leftHead.val < rightHead.val){
                    traver.next = leftHead;
                    leftHead = leftHead.next;
                } else {
                    traver.next = rightHead;
                    rightHead = rightHead.next;
                }
            } else if(leftHead != null && rightHead == null){
                traver.next = leftHead;
                leftHead = leftHead.next;
            } else {
                traver.next = rightHead;
                rightHead = rightHead.next;
            }
            
            traver = traver.next;
        }
        
        return dummy.next;
    }
	
    
    
    /****************************************************/
	// by Jackie using priorityQueue
	public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        int len = lists.length;
        Queue<Pair> heap = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
            public int compare(Pair left, Pair right){
                return left.node.val - right.node.val;
            }
        });
        
        for(int i = 0; i < len; i++){
            if(lists[i] != null){
                heap.offer(new Pair(lists[i], i));
                lists[i] = lists[i].next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode traver = dummy;
        
        while(!heap.isEmpty()){
            Pair p = heap.poll();
            traver.next = p.node;
            traver = traver.next;
            
            if(lists[p.index] != null){
                heap.offer(new Pair(lists[p.index], p.index));
                lists[p.index] = lists[p.index].next;
            }
        }
        
        return dummy.next;
    }
    
    class Pair {
        ListNode node;
        int index;
        
        public Pair(ListNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    
    
	
	
	/****************************************************/
	// by other using divide & conquer
	public ListNode mergeKLists3(List<ListNode> lists) {  
        if(lists==null||lists.size()==0) {  
            return null;  
        }  
        if(lists.size()==1) {  
            return lists.get(0);  
        }  
        int length = lists.size() ;  
        int mid = (length - 1)/2 ;  
        ListNode l1 = mergeKLists3(lists.subList(0,mid + 1)) ;  
        ListNode l2 = mergeKLists3(lists.subList(mid + 1,length)) ;  
  
        return merge2Lists(l1,l2) ;  
    }  
    
    ListNode merge2Lists(ListNode list1, ListNode list2) {  
        ListNode head    = new ListNode(-1);  
        ListNode current = head;  
        while(list1!=null&&list2!=null) {  
            if(list1.val<list2.val) {  
                current.next = list1;  
                list1   = list1.next;  
            } else {  
                current.next = list2;  
                list2   = list2.next;  
            }  
            current = current.next;  
        }  
        if(list1!=null) {  
            current.next = list1;  
        } else {  
            current.next = list2;  
        }  
        return head.next;  
    } 
    
    
    /****************************************************/
	// by other using PriorityQueue
    public ListNode mergeKLists4(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>(new ListComparator());
        for(ListNode n: lists){
            if( n!= null) {
                q.add(n);
            }
        }
        ListNode head = new ListNode(0), p = head, cur = null;
        while( !q.isEmpty()) {
            cur = q.poll();
            if(cur.next!=null)
                q.offer(cur.next);
            p.next = cur;
            p = p.next;
        }
        return head.next;
    }
    
    class ListComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
}

