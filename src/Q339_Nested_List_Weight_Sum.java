import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q339_Nested_List_Weight_Sum {
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        int sum = 0;
        int n = nestedList.size();
        
        for(NestedInteger next : nestedList){
            sum += bfs(next);
        }
        
        return sum;
    }
    
    public int bfs(NestedInteger root){
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();
        q.offer(root);
        int sum = 0;
        int size = 1;
        int level = 1;
        
        while(!q.isEmpty()){
            NestedInteger node = q.poll();
            if(node.isInteger()){
                sum += node.getInteger() * level;
            } else {
                for(NestedInteger n : node.getList()){
                    q.offer(n);
                }
            }
            
            if(--size == 0){
                size = q.size();
                level++;
            }
        }
        
        return sum;
    }
    
    
    class NestedInteger{
    	int val;
    	List<NestedInteger> list;
    	
    	public NestedInteger(int v){
    		val = v;
    		list = null;
    	}
    	
    	public NestedInteger(List<NestedInteger> l){
    		list = l;
    	}
    	
    	public boolean isInteger(){
    		return list == null;
    	}
    	
    	public int getInteger(){
    		return val;
    	}
    	
    	public List<NestedInteger> getList(){
    		return list;
    	}
    }
}
