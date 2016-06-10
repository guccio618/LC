import java.util.Arrays;
import java.util.Comparator;



public class Q354_Russian_Doll_Envelopes {
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        
        int maxNum = 1;
        int n = envelopes.length;
        Node[] arrays = new Node[n];
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++){
            arrays[i] = new Node(envelopes[i][0], envelopes[i][1], 0);
            dp[i] = 1;
        }
        
        Arrays.sort(arrays, new Comparator<Node>(){
            public int compare(Node left, Node right){
                if(left.width != right.width){
                    return left.width - right.width;
                } else {
                    return left.height - right.height;
                }
            }
        });
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arrays[i].width > arrays[j].width && arrays[i].height > arrays[j].height){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxNum = Math.max(maxNum, dp[i]);
                }
            }
        }
        
        return maxNum;
    }
    
    class Node{
        int width;
        int height;
        int num;
        
        public Node(int w, int h, int n){
            width = w;
            height = h;
            num = n;
        }
    }

    
        
    public static void main(String[] args){
    	Q354_Russian_Doll_Envelopes t = new Q354_Russian_Doll_Envelopes();
    	int[][] envelopes = {
//    			{5,4}, {6,4}, {6,7}, {2,3}
    			{4,5}, {4,6}, {6,7}, {2,3}, {1,1}
    	};
    	
    	System.out.println(t.maxEnvelopes(envelopes));
    }
}
