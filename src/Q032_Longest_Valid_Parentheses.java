import java.util.Stack;

public class Q032_Longest_Valid_Parentheses {
	public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] array = s.toCharArray();
        int len = array.length;
        int max = Integer.MIN_VALUE;
        
        for(int start = 0; start < len; ++start){
        	if(array[start] == ')') continue;
        	Stack<Character> stack = new Stack<Character>();
        	stack.push(array[start]);
        	boolean flag = false;
        	for(int end = start + 1; end < len; ++end){
        		if(array[end] == '('){
        			stack.push(array[end]);
        		} 
        		else{
        			if(!stack.isEmpty()){
        				stack.pop();
        			} 
        			else{
        				max = Math.max(max, end - start);
        				flag = true;
        				break;
        			}
        		}
        	}
        	if(flag == false && stack.isEmpty()){
        		max = Math.max(max, len - start);
        	}
        }
        return max;
    }
	
	
	public static void main(String[] args){
		Q032_Longest_Valid_Parentheses t = new Q032_Longest_Valid_Parentheses();
		System.out.println(t.longestValidParentheses(")()())"));
	}
}
