import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q373_Find_K_Pairs_with_Smallest_Sums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return ans;
        }
        
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                return (left.x + left.y) - (right.x + right.y);
            }
        });
        
        int curMaxValue = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums1.length; i++){
            if(heap.size() >= k && curMaxValue <= nums1[i] + nums2[0]){
                break;
            }
            
            for(int j = 0; j < nums2.length; j++){
            	curMaxValue = Math.max(curMaxValue, nums1[i] + nums2[j]);
                heap.offer(new Node(nums1[i], nums2[j]));
            }
        }
        
        for(int i = 0; i < k && !heap.isEmpty(); i++){
            Node node = heap.poll();
            ans.add(new int[]{node.x, node.y});
        }
        
        return ans;
    }
    
    class Node{
        int x;
        int y; 
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public static void main(String[] arge){
    	Q373_Find_K_Pairs_with_Smallest_Sums t = new Q373_Find_K_Pairs_with_Smallest_Sums();
    	int[] nums1 = {1,1,2};
    	int[] nums2 = {1,2,3};
    	
    	t.kSmallestPairs(nums1, nums2, 2);
    }
    
}
