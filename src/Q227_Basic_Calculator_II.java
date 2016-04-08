import java.util.Stack;


public class Q227_Basic_Calculator_II {
	/*************************************************/
	// by other
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = ' ';
        
        for(int i = 0; i < n; ++i){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
            } 
            if(!Character.isDigit(c) && c != ' ' || i == n - 1){
                if(sign == '+'){
                    stack.push(num);
                } else if(sign == '-'){
                    stack.push(-num);
                } else if(sign == '*'){
                    stack.push(stack.pop() * num);
                } else if(sign == '/'){
                    stack.push(stack.pop() / num);
                } else {
                    stack.push(num);
                }
                sign = c;
                num = 0;
            }
            
        }
        
        num = 0;
        while(!stack.isEmpty()){
            num += stack.pop();
        }
        
        return num;
    }
	
	
	
	/*************************************************/
	// by jackie
	public int calculate2(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return s.charAt(0) - '0';
        String str = "";
        Stack<Integer> stack = new Stack<>();
        s += '+'; 
        int len = s.length(), res = 0;
        char pre_oper = 'n';
       
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == ' ') continue;
            else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
            	if(pre_oper == '*')
                	stack.push(Integer.parseInt(str) * stack.pop());
                else if(pre_oper == '/'){
                    int y = Integer.parseInt(str);
                    int x = stack.pop();
                    stack.push(x / y);
                }
                else if(i == 0){
                    str += s.charAt(i);
                    pre_oper = s.charAt(i);
                    continue;
                }
                else if(pre_oper == '-')
                	stack.push(0 - Integer.parseInt(str));
                else
                	stack.push(Integer.parseInt(str));
                str = "";
                pre_oper = s.charAt(i);
            }
            else str += s.charAt(i);
        }
        while(!stack.isEmpty()) 
        	res += stack.pop();
        return res;
    }
	
	
	
	
	
	
	public static void main(String[] args){
		Q227_Basic_Calculator_II b = new Q227_Basic_Calculator_II();
		String a = "3+5 / 2 ";
        System.out.println("res = " + b.calculate(a));
	}
	
}
