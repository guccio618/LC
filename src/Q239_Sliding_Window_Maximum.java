import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q239_Sliding_Window_Maximum {
	// by ninechapter using Deque, very fast!
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || k <= 0 || nums.length < k){
            return new int[0];
        }
        
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();                
            }
            
            dq.offer(i);
            
            if(i - dq.peekFirst() + 1 > k){
                dq.pollFirst();
            }
            
            if(i >= k - 1){
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        
        return ans;
    }
	
	
	
	// by Jackie using priority queue
	public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return new int[0];
        }
        
        int n = nums.length;
        Queue<Integer> heap = new PriorityQueue<Integer>();
        int index = 1;
        int[] ans = new int[n - k + 1];
        int front = 0, back = k;
        
        for(int i = 0; i < k; ++i){
            heap.offer(-nums[i]);
        }
        
        ans[0] = -heap.peek();
        
        for(; back < n; ++back, ++front, ++index){
            heap.offer(-nums[back]);
            heap.remove(-nums[front]);
            ans[index] = -heap.peek();
        }
        
        return ans;
    }
	

	
	public static void main(String[] args){
		Q239_Sliding_Window_Maximum t = new Q239_Sliding_Window_Maximum();
		int[] nums = {1, -1};
		int[] ans = t.maxSlidingWindow2(nums, 1);
		for(int i = 0; i < ans.length; ++i){
			System.out.print(ans[i] + ", ");
		}
	}
}
