import java.util.List;
import java.util.Stack;


public class Q385_Mini_Parser {
	// by other
	public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0){
            return null;
        } else if(s.indexOf("[", 0) < 0){
            return new NestedInteger(Integer.parseInt(s));
        }
        
        int len = s.length();
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int start = 0;
        NestedInteger current = null;
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            
            if(c == '['){
                if(current != null){
                    stack.push(current);
                }
                
                current = new NestedInteger();
                start = i + 1;
            } else if(c == ']'){
                String num = s.substring(start, i);
                
                if(!num.isEmpty()){
                    current.add(new NestedInteger(Integer.parseInt(num)));
                }
                
                if(!stack.isEmpty()){
                    NestedInteger prev = stack.pop();
                    prev.add(current);
                    current = prev;
                }
                
                start = i + 1;
            } else if(c == ','){
                if(s.charAt(i - 1) != ']'){
                    String num = s.substring(start, i);
                    current.add(new NestedInteger(Integer.parseInt(num)));
                }
                
                start = i + 1;
            }
        }
        
        return current;
    }
	
	
	
	class NestedInteger {
		int value;
		List<NestedInteger> list;

		// Constructor initializes an empty nested list.
		public NestedInteger() {
			value = 0;
			list = null;
		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
			this.value = value;
			list = null;
		}

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger() {
			return list == null;
		}

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return value;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
			this.value = value;
		}

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni) {
			list.add(ni);
		}

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return list;
		}
	}
}
