import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Q133_Clone_Graph {
	/*********************************************************/
	// by other
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if(root == null){
            return null;
        }
        
        UndirectedGraphNode copyRoot = new UndirectedGraphNode(root.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(root);
        Queue<UndirectedGraphNode> copyQueue = new LinkedList<UndirectedGraphNode>();
        copyQueue.offer(copyRoot);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(root, copyRoot);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            UndirectedGraphNode copyNode = copyQueue.poll();
            
            for(UndirectedGraphNode next : node.neighbors){
                if(map.containsKey(next)){
                    copyNode.neighbors.add(map.get(next));
                } else {
                    UndirectedGraphNode copyNext = new UndirectedGraphNode(next.label);
                    copyNode.neighbors.add(copyNext);
                    map.put(next, copyNext);
                    queue.offer(next);
                    copyQueue.offer(copyNext);
                }
            }
        }
        
        return copyRoot;
    }
	
	
	
	/*********************************************************/
	// by other
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
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
