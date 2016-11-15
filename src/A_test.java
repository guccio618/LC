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

	
    
    public int getMax(int[][] nums){
    	int sum = 0;
    	int row = nums.length;
    	int col = nums[0].length;
    	int max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < row - 1; i++){
    		sum = nums[i][0] + nums[i][1] + nums[i + 1][0] + nums[i + 1][1];
    		
    		for(int j = 1; j < col - 1; j++){
    			sum -= nums[i][j - 1] + nums[i + 1][j - 1];
    			sum += nums[i][j + 1] + nums[i + 1][j + 1];
    			max = Math.max(max, sum);
    		}
    	}
    	
    	return max;
    }
    
	
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int num : nums1){
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums2){
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
        	int num = entry.getKey();
        	
            if(map2.containsKey(num)){
                int count = Math.min(map1.get(num), map2.get(num));                
                
                for(int i = 0; i < count; i++){
                    list.add(num);
                }
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        
        for(int num : list){
            ans[index++] = num;
        }
        
        return ans;
    }
    
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        char[] letters = s.toCharArray();
        int front = 0, back = 0, len = letters.length;
        
        reverse(letters, 0, letters.length - 1);
        
        while(front < len){
            while(front < len && letters[front] == ' '){
                front++;
            }
            
            back = front;
            
            while(front < len && letters[front] != ' '){
                front++;
            }
            
//            System.out.println(front + ", " + back);
            
            if(front < len && back < len){
            	
                reverse(letters, back, front - 1);
            }
        }
        
        return new String(letters);
    }    

    public void reverse(char[] letters, int start, int end){
        char temp = ' ';
        
        while(start < end){
            temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
    }
    
    
	
	public static void main(String[] args){
		A_test t = new A_test();
		
		int cur = 3;
		List<Integer> list = new ArrayList<Integer>();

		
		System.out.println("*****" + (cur <<= 2));
		
//		int[] nums = {4, 7, 9, 6, 8};
//		
//		System.out.println(t.getView(nums));
//		t.print();
		
//		String str = "--+----+++++++++--";
//		
//		List<List<String>> ans = t.canWin(str);
		
//		for(int i = 0; i < ans.size(); i++){
//			for(int j = 0; j < ans.get(i).size(); j++){
//				if(ans.get(i).size() % 2 != 0){
//					System.out.print(ans.get(i).get(j) + "     ");
//				}
//			}
//			System.out.println();
//		}
		
//		System.out.println(root.val);
		
//		int[][] nums = {
//					{300, 410, 150, 55,  370},
//					{120, 185, 440, 190, 450},
//					{165, 75,  95,  420, 50}
//				};
//		
//		int[] nums1 = {1,2,2,1};
//		int[] nums2 = {2};
//		
//		int[] res = t.intersect(nums1, nums2);
//		
//		for(int num : res){
//			System.out.print(num + ", ");
//		}
		
		t.reverseWords(" ");
		
		
//		System.out.println(t.getMax(nums));
	}
	
	
}



class Intervals {
	int start;
	int end;
	Intervals() { start = 0; end = 0; }
	Intervals(int s, int e) { start = s; end = e; }
}

 
