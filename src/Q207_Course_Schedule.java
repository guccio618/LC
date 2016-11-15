import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Q207_Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) {
            return true;
        }
        
        Set<Integer>[] graph = new Set[numCourses];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int[] prerequisite : prerequisites) {
            if(graph[prerequisite[1]] == null) {
                graph[prerequisite[1]] = new HashSet<Integer>();
            }
            
            if(!graph[prerequisite[1]].contains(prerequisite[0])) {
                graph[prerequisite[1]].add(prerequisite[0]);
                map.put(prerequisite[0], map.getOrDefault(prerequisite[0], 0) + 1);
            }
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(!map.containsKey(i)) {
                queue.offer(i);
            }
        }
        
        if(queue.isEmpty()){
            return false;
        }
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            if(graph[node] == null) {
                continue;
            }
            
            for(int next : graph[node]) {
                int count = map.get(next);
                
                if(count == 1) {
                    map.remove(next);
                    queue.offer(next);
                } else {
                    map.put(next, count - 1);
                }
            }
        }
        
        return map.size() == 0;
    }
	
	/******************************************/
	// by Jackie using topology sort
	// 用set存结点的邻居，用index索引，不易出错
	// test case: {{5,8},{3,5},{1,9},{4,5},{1,9},{0,2},{7,8},{4,9}};
	//            {{0,1},{3,1}, {1,3},{3,2}};
	//	          {{1,0},{2,0}}
	
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		if(prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites.length == 0 || numCourses <= 0){
            return true;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    
        HashSet<Integer>[] graph = new HashSet[numCourses];
        Queue<Set> q = new LinkedList<Set>();
        
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int row = 0; row < prerequisites.length; ++row){
            if(graph[prerequisites[row][1]].contains(prerequisites[row][0])){   // 去除prerequisites中的重复
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
                q.offer(graph[i]);
            }
        }
        
        if(q.isEmpty()){
            return false;
        }
        
        while(!q.isEmpty()){
            Set<Integer> temp = q.poll();
            for(int nextClass : temp){
                if(map.containsKey(nextClass)){
                    int count = map.get(nextClass);
                    if(count == 1){
                        map.remove(nextClass);
                        q.offer(graph[nextClass]);
                    } else {
                        map.put(nextClass, count - 1);
                    }
                }
            }
        }
        return map.size() == 0;
    }
	
	
	
	/*******************************************/
	// by other
	private LinkedList<Integer>[] course;
	private int[] visited;
	
	public boolean canFinish3(int numCourses, int[][] prerequisites) {
		if(numCourses == 0) return true;
		visited = new int[numCourses];    // 共3态，1:通，－1:不通，0:未判断
		course = new LinkedList[numCourses];
		for(int i = 0; i < numCourses; ++i)
			course[i] = new LinkedList<Integer>();
		
		for(int i = 0, len = prerequisites.length; i < len; ++i)
			course[prerequisites[i][0]].add(prerequisites[i][1]);
		
		for(int i = 0; i < numCourses; ++i)
			if(!finish(i))
				return false;
	
		return true;
	}
	
	public boolean finish(int vertex){
		if(visited[vertex] == 1) return true;
		if(visited[vertex] == -1) return false;
		visited[vertex] = -1;
		for(int i : course[vertex]){
			if(!finish(i))
				return false;
		}
		visited[vertex] = 1;   // 通过
		return true;
	}

	
	public static void main(String[] args){
		Q207_Course_Schedule t = new Q207_Course_Schedule();
		// test case:
		int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
		int[][] prerequisites2 = {{0,1},{3,1}, {1,3},{3,2}};
		int[][] prerequisites3 = {{1,0}, {2,1}};
		int[][] prerequisites4 = {{5,8},{3,5},{1,9},{4,5},{1,9},{0,2},{7,8},{4,9}};   // {1,9}有重复
		int[][] prerequisites5 = {{0,1}};
		System.out.println(t.canFinish(2, prerequisites5));
	}
}
