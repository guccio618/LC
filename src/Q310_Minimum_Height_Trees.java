import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;


public class Q310_Minimum_Height_Trees {
	/****************************************************************************/
	// by other, very fast
	public ArrayList<Integer> findMinHeightTrees(int n, int[][] edges) {
		ArrayList<ArrayList<Integer>> myGraph = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
        if (n==1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        for(int i=0; i<n; i++) {
            myGraph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        for(int i=0; i<n; i++) {
            if (degree[i]==0) 
                return res;
            else if (degree[i]==1) {
                myQueue.offer(i);
            }
        }

        while (!myQueue.isEmpty()) {
            res = new ArrayList<Integer>();
            int count = myQueue.size();

            for(int i=0; i<count; i++){
                int curr = myQueue.poll();
                res.add(curr);
                degree[curr]--;
                for(int k=0; k<myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    if (degree[next]==0) continue;
                    if (degree[next]==2) {
                        myQueue.offer(next);
                    }
                    degree[next]--;
                }
            }       
        }
        return res;		
	}
	
	/****************************************************************************/
	// by other, easily understand
	public ArrayList<Integer> findMinHeightTrees22(int n, int[][] edges) {
		ArrayList<Integer> leaves = new ArrayList<>();  
	    if(n <= 1) {leaves.add(0); return leaves;}

	    // Construct adjencent graph
	   HashSet<Integer>[] graph = new HashSet[n];
	    for(int i = 0; i < n; ++i)
	        graph[i] = new HashSet<Integer>();
	    
	    for(int[] e : edges) {
	        graph[e[0]].add(e[1]);
	        graph[e[1]].add(e[0]);
	    }

	    // Add leaves which have one leaf
	    for(int i = 0; i < n; i++) {
	        if(graph[i].size() == 1) leaves.add(i);
	    }	    
	    
	    // Remove leaves level by level
	    while(n > 2) {
	    	ArrayList<Integer> newLeaves = new ArrayList<>();
	        for(int leaf : leaves) {
	            for(int nb : graph[leaf]) {
	                // Remove connection
	                graph[leaf].remove(nb);
	                graph[nb].remove(leaf);
	                n--;
	                if(graph[nb].size() == 1) {
	                    newLeaves.add(nb);
	                }
	            }
	        }
	        leaves = newLeaves;
	    }
	    return leaves;
	}
	
	/****************************************************************************/
	// by Jackie, too slow	
	public LinkedList<Integer> findMinHeightTrees3(int n, int[][] edges) {
		LinkedList<Integer>[] graph = new LinkedList[n];
        int min = Integer.MAX_VALUE;
        int[] heights = new int[n];
        
        LinkedList<Integer> res = new LinkedList<Integer>();
        
        for(int i = 0; i < n; ++i){
        	graph[i] = new LinkedList<Integer>();
        }
        
        for(int i = 0, len = edges.length; i < len; ++i){
        	graph[edges[i][0]].add(edges[i][1]);
        	graph[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; ++i){
        	int[] visited = new int[n];       	
        	heights[i] = getMinHeight(graph, i, visited);
        	min = Math.min(min, heights[i]);
        } 
        
        for(int i = 0; i < n; ++i)
        	if(heights[i] == min)
        		res.add(i);
        return res;
    }
	
	public int getMinHeight(LinkedList<Integer>[] graph, int node, int[] visited){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		int level = 0;
		int numLeft = 1;
		
		while(!q.isEmpty()){
			int tempNode = q.poll();
			for(int j : graph[tempNode]){
				if(visited[j] != 1){
					visited[j] = 1;
					q.add(j);
				}
			}
			if(--numLeft == 0){
				numLeft = q.size();
				level++;
			}
		}
		return level;		
	}
	
	
	public static void main(String[] args){
		Q310_Minimum_Height_Trees t = new Q310_Minimum_Height_Trees();	
		int[][] edges = {{1,0},{1,2},{1,3}};
		ArrayList<Integer> l = t.findMinHeightTrees22(4, edges);
		for(int i = 0; i < l.size(); ++i)
			System.out.print(l.get(i) + ", ");
		System.out.println();
	}
}
