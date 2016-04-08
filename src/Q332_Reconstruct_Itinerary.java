import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


public class Q332_Reconstruct_Itinerary {	
	public List<String> findItinerary(String[][] tickets) {
	    Map<String, PriorityQueue<String>> targets = new HashMap<>();
	    for (String[] ticket : tickets)
	        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
	    List<String> route = new LinkedList();
	    Stack<String> stack = new Stack<>();
	    stack.push("JFK");
	    while (!stack.empty()) {
	        while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
	            stack.push(targets.get(stack.peek()).poll());
	        route.add(0, stack.pop());
	    }
	    return route;
	}
	
	
	// by other
	public List<String> findItinerary2(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0){
            return res;
        }
        Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        int len = tickets.length;
        for(int i = 0; i < len; ++i){
        	if(map.containsKey(tickets[i][0])){
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	} else{
        		LinkedList<String> temp = new LinkedList<String>();
        		temp.add(tickets[i][1]);
        		map.put(tickets[i][0], temp);
        	}
        }
        
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
        	HashMap.Entry entry = (HashMap.Entry) iter.next();
        	Collections.sort((List)entry.getValue(), new Comparator<String>(){
        		public int compare(String str1, String str2){
        			return str1.compareToIgnoreCase(str2);
        		}
        	});
        }
        
        Stack<String> stack = new Stack<String>();
        stack.add("JFK");
        
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());   // 保证顺序的进行，poll出去后，下次就不会再访问了，类似visited的作用
            }
            res.add(0, stack.pop());
        }
        return res;
    }
	
	
	
	public static void main(String[] args){
		Q332_Reconstruct_Itinerary t = new Q332_Reconstruct_Itinerary();
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String[][] tickets3 = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		List<String> res = t.findItinerary2(tickets2);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
