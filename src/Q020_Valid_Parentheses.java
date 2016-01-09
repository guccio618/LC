import java.util.Stack;


public class Q020_Valid_Parentheses {
	// by Jackie
	public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> myStack = new Stack<Character>();
        char[] arrays = s.toCharArray();
        int len = arrays.length;
        
        for(int i = 0; i < len; ++i){
            if(arrays[i] == '(' || arrays[i] == '[' || arrays[i] == '{')
                myStack.push(arrays[i]);
            else if(arrays[i] == ')' || arrays[i] == ']' || arrays[i] == '}'){
                if(myStack.isEmpty()) return false;
                char temp = myStack.pop();
                if( (arrays[i] == ')' && temp == '(') || (arrays[i] == ']' && temp == '[') || (arrays[i] == '}' && temp == '{') )
                    continue;
                else
                    return false;
            }
            else
                return false;
        }
        return myStack.isEmpty();
    }
}
