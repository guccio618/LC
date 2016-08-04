import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Q364_Nested_List_Weight_Sum_II {
	// by Jackie
	private Stack<Node> stack = new Stack<Node>();
    private int totalLevel = 0;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        int ans = 0;
        
        for(NestedInteger item : nestedList){
            dfs(item, 1);    // 必须从1开始 ！！！
        }
        
        while(!stack.isEmpty()){
            Node tempNode = stack.pop();
            ans += tempNode.value * (totalLevel - tempNode.level + 1);
        }
        
        return ans;
    }
    
    public void dfs(NestedInteger node, int level){
        totalLevel = Math.max(totalLevel, level);
        
        if(node.isInteger() == true){
            stack.push(new Node(node.getInteger(), level));
        } else {
            List<NestedInteger> list = node.getList();
            for(NestedInteger nextNode : list){
                dfs(nextNode, level + 1);
            }
        }
    }
    
    class Node{
        int value;
        int level;
        
        public Node(int v, int l){
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
