import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q057_Insert_Interval {
	// by Jackie
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return intervals;
        }
        
        List<Interval> ans = new ArrayList<Interval>();
        int count = 0;
        int startTime = 0, endTime = 0;
        int n = intervals.size();
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
            	if(left.time != right.time){
            		return left.time - right.time;
            	} else {
            		if(left.isStart == true && right.isStart == false){
            			return -1;
            		} else if(left.isStart == false && right.isStart == true){
            			return 1;
            		} else {
            			return 0;
            		}
            	}
            }
        });
        
        for(Interval inter : intervals){
            heap.offer(new Node(inter.start, true));
            heap.offer(new Node(inter.end, false));
        }
        
        heap.offer(new Node(newInterval.start, true));
        heap.offer(new Node(newInterval.end, false));
        
        
        while(!heap.isEmpty()){
        	Node node = heap.poll();
            if(count == 0 && node.isStart == true){
                startTime = node.time;
                count++;
            } else if(count == 1 && node.isStart == false){
                endTime = node.time;
                ans.add(new Interval(startTime, endTime));
                count--;
            } else {
                if(node.isStart == true){
                    count++;
                } 
                if(node.isStart == false){
                    count--;
                }
            }
        }
        
        return ans;
    }
    
    class Node{
        int time;
        boolean isStart;
        
        public Node(int t, boolean s){
            time = t;
            isStart = s;
        }
    }
    
    
    
    public static void main(String[] args){
    	Q057_Insert_Interval t = new Q057_Insert_Interval();
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(1, 5));
    	intervals.add(new Interval(6, 9));
    	Interval newInterval = new Interval(5, 6);
    	List<Interval> ans = t.insert(intervals, newInterval);
    	System.out.println(ans.get(0).start + ", " + ans.get(0).end);
    }
}
