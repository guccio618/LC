import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Q210_Course_Schedule_II {
	/****************************************************/
	// by Jackie
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    
        HashSet<Integer>[] graph = new HashSet[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        int[] ans = new int[numCourses];
        int index = 0;
        
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int row = 0; row < prerequisites.length; ++row){
            if(graph[prerequisites[row][1]].contains(prerequisites[row][0])){   
        		continue;
        	}
            graph[prerequisites[row][1]].add(prerequisites[row][0]);
            if(map.containsKey(prerequisites[row][0])){
                map.put(prerequisites[row][0], map.get(prerequisites[row][0]) + 1);
            } else {
                map.put(prerequisites[row][0], 1);
            }
        }
        
        for(int i = 0; i < graph.length; ++i){
            if(!map.containsKey(i)){
                q.offer(i);
            }
        }
        
        if(q.isEmpty()){
            return new int[0];
        }
        
        while(!q.isEmpty()){
            int temp = q.poll();
            ans[index++] = temp;
            for(int nextClass : graph[temp]){
                if(map.containsKey(nextClass)){
                    int count = map.get(nextClass);
                    if(count == 1){
                        map.remove(nextClass);
                        q.offer(nextClass);
                    } else {
                        map.put(nextClass, count - 1);
                    }
                }
            }
        }
        
        return map.size() == 0 ? ans : new int[0];
    }
	
	
	
	/****************************************************/
	// by other, faster
	public int[] findOrder2(int numCourses, int[][] prerequisites) {
	    // Create an adjacency list
		ArrayList<Integer>[] edges = new ArrayList[numCourses];

	    // array to track visited nodes and detect cycles, 0 = white, 1 = gray, 2 = black
	    int[] visited = new int[numCourses];

	    // output array
	    int[] res = new int[numCourses];

	    // initialize adjacency list
	    for (int i = 0; i < edges.length; i++) 
	        edges[i] = new ArrayList<Integer>();
	    for (int[] edge : prerequisites) 
	        edges[edge[0]].add(edge[1]); 

	    // run topological sort
	    for (int i = 0, j = 0; i < numCourses; i++) {
	        j = dfs(i, edges, visited, res, j);
	        if (j == -1) return new int[0]; // cycle, return empty array
	    }

	    return res;
	}
	
	private int dfs(int v, ArrayList<Integer>[] edges, int[] visited, int[] res, int i) {
	    if (visited[v] == 2) return i;           // black node
	    if (visited[v] == 1) return -1;          // gray node -> cycle
	    visited[v] = 1;
	    for(int j : edges[v]) {
	        i = dfs(j, edges, visited, res, i);  // variable "i" is used to record the order storing in array res
	        if (i == -1) return -1;              // if there is a cycle, propagate the error
	    }
	    visited[v] = 2;
	    res[i] = v;
	    return i+1;
	}
	
	
	
	/****************************************************/
	// by Jackie
	private LinkedList<Integer>[] course;
	private int[] visited;
	private LinkedList<Integer> res = new LinkedList<Integer>();
	
	public int[] findOrder3(int numCourses, int[][] prerequisites) {
		visited = new int[numCourses];    
		course = new LinkedList[numCourses];
		for(int i = 0; i < numCourses; ++i)
			course[i] = new LinkedList<Integer>();
		
		for(int i = 0, len = prerequisites.length; i < len; ++i)
			course[prerequisites[i][0]].add(prerequisites[i][1]);
		
		int[] result = new int[numCourses];
		for(int i = 0; i < numCourses; ++i){
			if(!finish(i))
				return new int[0];
		}

		for(int i = 0, len = res.size(); i < len; ++i)
			result[i] = res.get(i);

		return result;
	}
	
	public boolean finish(int vertex){
		if(visited[vertex] == 1) return true;
		if(visited[vertex] == -1) return false;
		
		visited[vertex] = -1;
		for(int i : course[vertex]){
			if(!finish(i))
				return false;
		}
		res.add(vertex);
		visited[vertex] = 1;   // 通过
		return true;
	}	
	
	public static void main(String[] args){
		Q210_Course_Schedule_II t = new Q210_Course_Schedule_II();
		int[][] prerequisites = {{0,1},{1,3},{3,2}};
		int[] res = t.findOrder(4, prerequisites);
		for(int i = 0; i < res.length; ++i)
			System.out.print(res[i] + ", ");
		System.out.println();
		int[] res2 = t.findOrder2(4, prerequisites);
		for(int i = 0; i < res.length; ++i)
			System.out.print(res2[i] + ", ");
	}
}
