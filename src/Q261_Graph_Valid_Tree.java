import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Q261_Graph_Valid_Tree {
	// by ninechapter
	public boolean validTree(int n, int[][] edges) {
		if(edges == null || edges.length == 0){
            if(n == 1){
                return true;
            } else{
                return false;
            }
        }
        
		Node[] nodes = new Node[n];
		Queue<Node> q = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		
		for(int row = 0; row < edges.length; ++ row){
			if(nodes[edges[row][0]] == null){
				nodes[edges[row][0]] = new Node(edges[row][0]);
			}
			nodes[edges[row][0]].neighbor.add(edges[row][1]);
			
			if(nodes[edges[row][1]] == null){
				nodes[edges[row][1]] = new Node(edges[row][1]);
			}
			nodes[edges[row][1]].neighbor.add(edges[row][0]);
		}
		
		for(int i = 0; i < n; ++i){
		    if(nodes[i] == null){
				return false;
			} else if(visited.contains(i)){
				continue;
			}
			
			q.add(nodes[i]);
			HashSet<Integer> canReach = new HashSet<Integer>();
			while(!q.isEmpty()){
				Node temp = q.poll();
				visited.add(temp.label);

				for(int nextIndex : temp.neighbor){
					if(visited.contains(nextIndex)){
						continue;
					} 
					if(canReach.contains(nextIndex)){
						return false;
					}
					q.add(nodes[nextIndex]);
					canReach.add(nextIndex);
				}
			}
		}
		
		return true;
	}
	
	class Node{
		int label;
		HashSet<Integer> neighbor;
		
		public Node(int l){
			label = l;
			neighbor = new HashSet<Integer>();
		}
	}
}
