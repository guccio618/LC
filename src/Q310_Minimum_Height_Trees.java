import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;


public class Q310_Minimum_Height_Trees {
	/****************************************************************************/
	// by other, easily understand
	public ArrayList<Integer> findMinHeightTrees(int n, int[][] edges) {
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		if (n <= 1) {
			leaves.add(0);
			return leaves;
		}

		// Construct adjencent graph
		HashSet<Integer>[] graph = new HashSet[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new HashSet<Integer>();
		}

		for (int[] e : edges) {
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}

		// Add leaves which have one leaf
		for (int i = 0; i < n; i++) {
			if (graph[i].size() == 1){
				leaves.add(i);
			}
		}

		// Remove leaves level by level
		while (n > 2) {
			ArrayList<Integer> newLeaves = new ArrayList<Integer>();
			for (int leaf : leaves) {
				for (int nb : graph[leaf]) {					
					graph[leaf].remove(nb);     // Remove connection
					graph[nb].remove(leaf);
					n--;
					if (graph[nb].size() == 1) {
						newLeaves.add(nb);
					}
				}
			}
			leaves = newLeaves;
		}
		return leaves;
	}
	
	
	
	/****************************************************************************/
	// by Jackie
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0 || n <= 0){
            return ans;
        }
        
        Node[] nodes = new Node[n];
        
        for(int row = 0; row < edges.length; ++row){
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
            if(nodes[i].neighbor.size() == 1){
                ans.add(i);
            }
        }
        
        while(n > 2){
        	ArrayList<Integer> newlist = new ArrayList<Integer>();
            for(int next : ans){
                for(int nb : nodes[next].neighbor){
                	nodes[nb].neighbor.remove(next);
                	nodes[next].neighbor.remove(nb);
                	n--;
                	if(nodes[nb].neighbor.size() == 1){
                        newlist.add(nb);
                    }
                }  
            }
            ans = newlist;
        }

        return ans;
    }
    
    class Node{
        int label;
        HashSet<Integer> neighbor;
        
        public Node(int l){
            label = l;
            neighbor = new HashSet<Integer>();
        }
    }
	
    
    
	/****************************************************************************/
	// by other, very fast
	public ArrayList<Integer> findMinHeightTrees3(int n, int[][] edges) {
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
	
	
	
	
	/************************ main function ****************************/
	
	public static void main(String[] args){
		Q310_Minimum_Height_Trees t = new Q310_Minimum_Height_Trees();	
		int[][] edges = {{1,0},{1,2},{1,3}};
		List<Integer> l = t.findMinHeightTrees(4, edges);
		for(int i = 0; i < l.size(); ++i)
			System.out.print(l.get(i) + ", ");
		System.out.println();
	}
}
