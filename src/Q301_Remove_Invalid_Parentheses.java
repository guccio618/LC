import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q301_Remove_Invalid_Parentheses {
	// by other
	public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        
        if(s == null){
            return ans;
        }
        
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        
        while(!q.isEmpty()){
            String tempStr = q.poll();
            
            if(isValid(tempStr)){
                ans.add(tempStr);
                found = true;
            }
            
            if(found == true){
                continue;
            }
            
            int len = tempStr.length();
            
            for(int i = 0; i < len; ++i){
                char c = tempStr.charAt(i);
                
                if(c != '(' && c != ')'){
                    continue;
                }
                
                String newStr = tempStr.substring(0, i) + tempStr.substring(i + 1);
                
                if(!visited.contains(newStr)){
                    visited.add(newStr);
                    q.offer(newStr);
                }
            }
        }

        return ans;
    }
    
	
    public boolean isValid(String str){
        int count = 0;
        int n = str.length();
        
        for(int i = 0; i < n; ++i){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            } else if (c == ')'){
                count--;
            }
            
            if(count < 0){
                return false;
            }
        }
        
        return count == 0;
    }
}
