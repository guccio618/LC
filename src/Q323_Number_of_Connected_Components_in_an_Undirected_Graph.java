import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q323_Number_of_Connected_Components_in_an_Undirected_Graph {
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0){
            return ans;
        }
        
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        
        for(UndirectedGraphNode node : nodes){
            if(visited.contains(node)){
                continue;
            }
            
            q.add(node);
            visited.add(node);
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            while(!q.isEmpty()){
                UndirectedGraphNode temp = q.poll();
                list.add(temp.label);
                
                for(UndirectedGraphNode nextNode : temp.neighbors){
                    if(!visited.contains(nextNode)){
                        q.add(nextNode);
                        visited.add(nextNode);
                    }
                }
            }
            
            Collections.sort(list);
            ans.add(list);
        }
        
        return ans;
    }
}
