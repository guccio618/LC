import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Q261_Graph_Valid_Tree {
	public boolean validTree(int n, int[][] edges) {
        if(n <= 0){
            return true;
        }
        
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            if(visited.contains(i)){
                continue;
            } else if(bfs(graph, i, visited) == false){
                return false;
            }
            count++;
        }
        
        return count == 1;
    }
    
    public boolean bfs(Set<Integer>[] graph, int root, Set<Integer> visited){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(root);
        Set<Integer> canReach = new HashSet<Integer>();
        
        while(!q.isEmpty()){
            int num = q.poll();
            Set<Integer> node = graph[num];
            visited.add(num);
            
            for(int n : node){
                if(visited.contains(n)){
                    continue;
                }
                if(canReach.contains(n)){
                    return false;
                }
                canReach.add(n);
                q.offer(n);
            }
        }
             
        return true;
    }
	
	
	// by ninechapter
//	public boolean validTree(int n, int[][] edges) {
//		if(edges == null || edges.length == 0){
//            if(n == 1){
//                return true;
//            } else{
//                return false;
//            }
//        }
//        
//		Node[] nodes = new Node[n];
//		Queue<Node> q = new LinkedList<Node>();
//		HashSet<Integer> visited = new HashSet<Integer>();
//		
//		for(int row = 0; row < edges.length; ++ row){
//			if(nodes[edges[row][0]] == null){
//				nodes[edges[row][0]] = new Node(edges[row][0]);
//			}
//			nodes[edges[row][0]].neighbor.add(edges[row][1]);
//			
//			if(nodes[edges[row][1]] == null){
//				nodes[edges[row][1]] = new Node(edges[row][1]);
//			}
//			nodes[edges[row][1]].neighbor.add(edges[row][0]);
//		}
//		
//		for(int i = 0; i < n; ++i){
//		    if(nodes[i] == null){
//				return false;
//			} else if(visited.contains(i)){
//				continue;
//			}
//			
//			q.add(nodes[i]);
//			HashSet<Integer> canReach = new HashSet<Integer>();
//			while(!q.isEmpty()){
//				Node temp = q.poll();
//				visited.add(temp.label);
//
//				for(int nextIndex : temp.neighbor){
//					if(visited.contains(nextIndex)){
//						continue;
//					} 
//					if(canReach.contains(nextIndex)){
//						return false;
//					}
//					q.add(nodes[nextIndex]);
//					canReach.add(nextIndex);
//				}
//			}
//		}
//		
//		return true;
//	}
//	
//	class Node{
//		int label;
//		HashSet<Integer> neighbor;
//		
//		public Node(int l){
//			label = l;
//			neighbor = new HashSet<Integer>();
//		}
//	}
}
