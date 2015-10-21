import java.util.ArrayList;


public class Q155_Min_Stack {
	int min = Integer.MAX_VALUE;
    int min_count = 0;
    ArrayList<Integer> a = new ArrayList<Integer> ();
    
    public void push(int x) {
        a.add(x);
        if(x < min){
            min = x;
            min_count = 1;
        }
        else if(min == x)
            min_count++;
    }

    public void pop() {
    	if(a.isEmpty()) return;
        if(a.get(a.size()-1) == min)
            min_count--;
        a.remove(a.size()-1);
        if(min_count == 0){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < a.size(); i++){
                if(min > a.get(i))
                    min = a.get(i);
            }
            min_count++;
        }
    }

    public int top() {
        return a.get(a.size()-1);
    }

    public int getMin() {
        return min;
    }
    
    public static void main(String[] args){
    	Q155_Min_Stack ms = new Q155_Min_Stack();
    	ms.push(395);
    	System.out.print(ms.getMin() + ", ");
    	System.out.print(ms.top() + ", ");
    	System.out.print(ms.getMin() + ", ");
    	ms.push(276);
    	ms.push(29);
    	System.out.print(ms.getMin() + ", ");
    	ms.push(-482);
    	System.out.print(ms.getMin() + ", ");
    	ms.pop();
    	ms.push(-108);
    	ms.push(-251);
    	System.out.print(ms.getMin() + ", ");
    	ms.push(-439);
    	System.out.print(ms.top() + ", ");
    	ms.push(370);
    	ms.pop();
    	ms.pop();
    	System.out.print(ms.getMin() + ", ");
    	ms.pop();
    	System.out.print(ms.getMin() + ", ");
    	System.out.print(ms.getMin() + ", ");
    	System.out.print(ms.top() + ", ");
    	
    }
}
