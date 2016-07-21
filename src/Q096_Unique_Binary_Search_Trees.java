
public class Q096_Unique_Binary_Search_Trees {	
	/***********************   recursive + DP   ****************************/
	// by jackie
	public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        
        int[] memo = new int[n + 1];     // 因为是从 1 到 n，因此这里需要定义到 n + 1 !!!
        memo[0] = 0;
        memo[1] = 1;
        
        return helper(memo, 1, n);
    }
    
    public int helper(int[] memo, int start, int end){
        if(start > end){
            return 0;
        } else if(memo[end - start + 1] > 0){
            return memo[end - start + 1];
        }
        
        int count = 0;
        
        for(int i = start; i <= end; i++){
            int left = helper(memo, start, i - 1);
            int right = helper(memo, i + 1, end);
            
            if(left == 0 || right == 0){
                count += left + right;
            } else {
                count += left * right;
            }
        }
        
        memo[end - start + 1] = count;
        return count;
    }
	
	
	// by other
	public int numTrees_2(int n) {
	    int count[] = new int[n + 1];   //count[i]: Possible amount for i numbers
	    count[0] = 1;                   //Empty tree
	    count[1] = 1;                   //Tree with one node 

	    for (int i = 2; i <= n; i++)    //number amount: i
	        for (int j = 0; j < i; j++) //Possible amount with j as the root
	            count[i] += count[j] * count[i-1-j]; //Divide i numbers into 2 parts with j: 1) 0..j 2) j..i-1. Count[i] is count[left part] * count[right part]        
	    return count[n];
	} 
	
    
    public static void main(String[] args){
    	Q096_Unique_Binary_Search_Trees t = new Q096_Unique_Binary_Search_Trees();
    	System.out.println(t.numTrees(5));
    }
}
