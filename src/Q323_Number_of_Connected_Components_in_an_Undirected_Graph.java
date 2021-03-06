import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Q323_Number_of_Connected_Components_in_an_Undirected_Graph {
	public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            return 0;
        }
        
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                BFS(graph, i, visited);
            }
        }
        
        return count;
    }
    
    public void BFS(Set<Integer>[] graph, int root, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int nextNode : graph[node]) {
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(nextNode);
                }
            }
        }
    }
	
	
	/***********************************************/
	// by Jackie using BFS
	public int countComponents2(int n, int[][] edges) {
        if(n <= 0){
            return 0;
        } else if(edges == null || edges.length == 0 || edges[0].length == 0){
            return n;
        }
        
        int len = edges.length;
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        
        for(int i = 0; i < len; i++){
            if(graph[edges[i][0]] == null){
                graph[edges[i][0]] = new HashSet<Integer>();
            }
            graph[edges[i][0]].add(edges[i][1]);
            
            if(graph[edges[i][1]] == null){
                graph[edges[i][1]] = new HashSet<Integer>();
            }
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                count++;
                bfs(graph, i, visited);
            }
        }
        
        return count;
    }
    
    public void bfs(Set<Integer>[] graph, int root, Set<Integer> visited){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited.contains(node) || graph[node] == null){
                continue;
            }
            
            visited.add(node);
            
            for(int next : graph[node]){
                if(!visited.contains(next)){
                    queue.offer(next);
                }
            }
        }
    }
	
    
    
    /***********************************************/
	// by Jackie using union find
	public int countComponents3(int n, int[][] edges) {
        if(n <= 0){
            return 0;
        } else if(edges == null || edges.length == 0 || edges[0].length == 0){
            return n;
        }
        
        Union_Find uf = new Union_Find(n);
        int len = edges.length;
        Set<Integer> reach = new HashSet<Integer>();
        int count = 0;
        
        for(int i = 0; i < len; i++){
            uf.union(edges[i][0], edges[i][1]);
        }
        
        for(int i = 0; i < n; i++){
            int parent = uf.compress_find(i);
            if(reach.contains(parent)){
                continue;
            } else {
                count++;
                reach.add(parent);
            }
        }
        
        return count;
    }
    
    class Union_Find{
        Map<Integer, Integer> father = new HashMap<Integer, Integer>();
        
        public Union_Find(int n){
            for(int i = 0; i < n; i++){
                father.put(i, i);
            }
        }
        
        public int compress_find(int x){
            int parent = father.get(x);
            
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            
            int temp = -1;
            int fa = x;
            
            while(fa != father.get(fa)){
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            
            return parent;
        }
        
        public void union(int x, int y){
            int fa_x = compress_find(x);     // 注意这里用的是compress_find(x)而不是直接father.get(x) !!!
            int fa_y = compress_find(y);
            
            if(fa_x != fa_y){
                father.put(fa_x, fa_y);
            }
        }
    }
}
