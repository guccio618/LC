import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Q364_Nested_List_Weight_Sum_II {
	// by Jackie, iterator
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int sum = 0;
        int totalLevel = 1;
        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();
        
        for(NestedInteger node : nestedList) {
            if(node.isInteger() == true) {
                list.add(new Node(node, 1));
            } else {
                stack.push(new Node(node, 1));
            }
        }
        
        while(!stack.isEmpty()) {
            Node n = stack.pop();
            NestedInteger current = n.node;
            int curLevel = n.level + 1;
            totalLevel = Math.max(totalLevel, curLevel);
            
            for(NestedInteger next : current.getList()) {
                if(next.isInteger() == true) {
                    list.add(new Node(next, curLevel));
                } else {
                    stack.push(new Node(next, curLevel));
                }
            }
        }
        
        for(Node n : list) {
            sum += n.node.getInteger() * (totalLevel - n.level + 1);
        }
        
        return sum;
    }
    
    class Node {
        NestedInteger node;
        int level;
        
        public Node(NestedInteger node, int level) {
            this.node = node;
            this.level = level;
        }
    }
	
	// by Jackie, recursion
	private Stack<Node2> stack = new Stack<Node2>();
    private int totalLevel = 0;
    
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        int ans = 0;
        
        for(NestedInteger item : nestedList){
            dfs(item, 1);    // 必须从1开始 ！！！
        }
        
        while(!stack.isEmpty()){
            Node2 tempNode = stack.pop();
            ans += tempNode.value * (totalLevel - tempNode.level + 1);
        }
        
        return ans;
    }
    
    public void dfs(NestedInteger node, int level){
        totalLevel = Math.max(totalLevel, level);
        
        if(node.isInteger() == true){
            stack.push(new Node2(node.getInteger(), level));
        } else {
            List<NestedInteger> list = node.getList();
            for(NestedInteger nextNode : list){
                dfs(nextNode, level + 1);
            }
        }
    }
    
    class Node2{
        int value;
        int level;
        
        public Node2(int v, int l){
            value = v;
            level = l;
        }
    }
    
    
    
    
    // example 
    class NestedInteger{
    	public boolean isInteger(){
    		return true;
    	}
    	
    	public int getInteger(){
    		return 1;
    	}
    	
    	public List<NestedInteger> getList(){
    		return new ArrayList<NestedInteger>();
    	}
    }
}
