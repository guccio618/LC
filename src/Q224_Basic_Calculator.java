import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q224_Basic_Calculator {
	//by other 1
	public int calculate(String s) {
	    Stack<Character> stack = new Stack<Character>();
	    int i = 0, sign = 1, res = 0;
	    while(i < s.length()){
	        if(s.charAt(i) == ' ') i++;
	        else if(s.charAt(i) == '('){
	            if(i > 0)
	            	stack.push(s.charAt(i-1));
	            if(!stack.isEmpty() && stack.peek() == '-')
	            	sign = -sign;
	            i++;
	        }
	        else if(s.charAt(i) == ')'){
	            if(!stack.isEmpty() && stack.pop() == '-')
	            	sign = -sign;
	            i++;
	        }
	        else{
	            int j = Character.isDigit(s.charAt(i)) ? i : i + 1, p = 0;
	            while(j < s.length() && Character.isDigit(s.charAt(j))){
	               p = 10 * p + s.charAt(j) - '0';
	               j++; 
	            } 
	            res += (s.charAt(i) == '-' ? -1 : 1) * sign * p;
	            i = j;
	        }
	    }
	    return res;
	}
	
	//by other 2
	public int calculate_2(String s) {
	    //Deque<Integer> stack = new LinkedList<>();  //双端队列
		Stack<Integer> stack = new Stack<Integer>();
	    int rs = 0;
	    int sign = 1;
	    stack.push(1);
	    for (int i = 0; i < s.length(); i++){
	        if (s.charAt(i) == ' ') continue;
	        else if (s.charAt(i) == '('){
	            stack.push(stack.peek() * sign);      //双端队列用peekFirst()
	            sign = 1;
	        }
	        else if (s.charAt(i) == ')') stack.pop();
	        else if (s.charAt(i) == '+') sign = 1;
	        else if (s.charAt(i) == '-') sign = -1;
	        else{
	            int temp = s.charAt(i) - '0';
	            while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
	                temp = temp * 10 + s.charAt(++i) - '0';
	            rs += sign * stack.peek() * temp;
	        }
	    }
	    return rs;
	}
	//by jackie but slow
	public int calculate_3(String s) {
		if (s.length() == 0) return 0;
		Stack<String> stack = new Stack<String>(), stack2 = new Stack<String>();
		String temp = "", num_str = "";
		int sum = 0, num = 0;
		char oper = '+';
		s = '(' + s + ')';
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') continue;
			else{
				if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '(' && s.charAt(i) != ')')
					num_str += s.charAt(i);
				else {
					if(!num_str.equals("")){
						stack.push(num_str);
						num_str = "";
					}
					if(s.charAt(i) != ')')
						stack.push(s.substring(i, i+1));				
					else{
						while (!stack.peek().equals("("))
							stack2.push(stack.pop());
						stack.pop();
						while(!stack2.isEmpty()){
							temp = "";
							temp = stack2.pop();
							if(temp.equals("+")) oper = '+';
							else if(temp.equals("-")) oper = '-';
							else{
								num = (oper == '+') ? Integer.parseInt(temp) : 0 - Integer.parseInt(temp);
								sum += num;								
							}
						}
						stack.push(Integer.toString(sum));
						num = sum = 0;	
						oper = '+';
					}
				}
			}				
		}
		return Integer.parseInt(stack.pop());
	}		
	

	public static void main(String[] args) {
		Q224_Basic_Calculator bc = new Q224_Basic_Calculator();
		String str = "2-(5-6)";
		System.out.println(bc.calculate(str));
		System.out.println(bc.calculate_3(str));
	}
}
