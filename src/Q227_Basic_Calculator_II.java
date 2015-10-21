import java.util.Stack;


public class Q227_Basic_Calculator_II {
	public int calculate(String s) {  //by jackie
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
