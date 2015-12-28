import java.util.ArrayList;
import java.util.HashMap;


public class Q133_Clone_Graph {
	// by other
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        dfs(copy, node);
        return copy;
    }
    
    public void dfs(UndirectedGraphNode copy, UndirectedGraphNode node){
        map.put(node.label, copy);
        for(UndirectedGraphNode n : node.neighbors){
            if(!map.containsKey(n.label)){  // 拷贝而非单纯的连接
                UndirectedGraphNode newCopy = new UndirectedGraphNode(n.label);
                dfs(newCopy, n);
                copy.neighbors.add(newCopy);
            }
            else
                copy.neighbors.add(map.get(n.label));
        }
    }
}

//Definition for undirected graph.
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
