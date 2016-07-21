import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class A_test {
	// bloomberg 12/21
	public int getView(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int len = nums.length;
		int ans = nums[0];
		int maxHeight = nums[0];
		
		for(int i = 1; i < len; i++){
			ans += Math.max(0, nums[i] - maxHeight);
			maxHeight = Math.max(maxHeight, nums[i]);
		}
		
		return ans;
	}
	
	
	public void print(){
		Queue<Character> q = new PriorityQueue<Character>();
		q.offer('b');
		q.offer('a');
		q.offer('c');
		
		while(!q.isEmpty()){
			System.out.print(q.poll() + ", ");
		}
	}
	
	/********************************************************************/
	public List<List<String>> canWin(String s) {
		List<List<String>> ans = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return ans;
        }
        
        int len = s.length();
        boolean[] state = new boolean[len];
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '+'){
                state[i] = true;
            } else {
                state[i] = false;
            }
        }
        
        boolean result1 = DFS(ans, list, state);
        boolean result2 = search(state);
        System.out.println("win or lose: " + result1);
        System.out.println("win or lose: " + result2);
        
        return ans;
    }
    
    public boolean search(boolean[] state){
    	for(int i = 0; i < state.length - 1; i++){
            if(state[i] == true && state[i + 1] == true){
                state[i] = state[i + 1] = false;
                
                if(search(state) == false){
                    state[i] = state[i + 1] = true;
                    return true;
                } else {
                    state[i] = state[i + 1] = true;
                }
            }
        }
        
        return false;
    }
    
    public boolean DFS(List<List<String>> ans, List<String> list, boolean[] state){
    	for(int i = 0; i < state.length - 1; i++){
            if(state[i] == true && state[i + 1] == true){
                state[i] = state[i + 1] = false;
                StringBuilder builder = new StringBuilder();
                builder.append(i).append(", ").append(i + 1);
                list.add(builder.toString());
                
                if(DFS(ans, list, state) == false){                   
                    ans.add(new ArrayList<String>(list));
                    state[i] = state[i + 1] = true;
                    list.remove(list.size() - 1);
                    return true;
                } else {
                    state[i] = state[i + 1] = true;
                    list.remove(list.size() - 1);
                }
            }
        }
    	
    	return false;
    }

	

	
	
	public static void main(String[] args){
		A_test t = new A_test();
//		int[] nums = {4, 7, 9, 6, 8};
//		
//		System.out.println(t.getView(nums));
//		t.print();
		
		String str = "--+----+++++++++--";
		
		List<List<String>> ans = t.canWin(str);
		
		for(int i = 0; i < ans.size(); i++){
			for(int j = 0; j < ans.get(i).size(); j++){
				if(ans.get(i).size() % 2 != 0){
					System.out.print(ans.get(i).get(j) + "     ");
				}
			}
			System.out.println();
		}
		
//		System.out.println(root.val);
		
	}
	
	
}



class Intervals {
	int start;
	int end;
	Intervals() { start = 0; end = 0; }
	Intervals(int s, int e) { start = s; end = e; }
}

 
