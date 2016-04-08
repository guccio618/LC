import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q239_Sliding_Window_Maximum {
	// by ninechapter using Deque, very fast!
	public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Deque<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; ++i){
            while(!list.isEmpty() && nums[i] > nums[list.peekLast()]){
                list.pollLast();
            }
            
            list.offer(i);
            
            if(i - list.peekFirst() + 1 > k){
                list.pollFirst();
            }
            
            if(i >= k - 1){
                res.add(nums[list.peekFirst()]);
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); ++i){
            ans[i] = res.get(i);
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
