
public class Q096_Unique_Binary_Search_Trees {	
	/***********************   recursive + DP   ****************************/
	// by jackie
	public int numTrees(int n) {
        if(n <= 0) return 0;
        int[] f = new int[n+1];
        f[1] = 1; 
        return countNum(1, n, n, f);
    }
	
	public int countNum(int startNode, int endNode, int max, int[] f){
		if(startNode > endNode) return 0;
//		if(startNode == endNode) return 1;
		if(f[endNode - startNode + 1] > 0) return f[endNode - startNode + 1];
		int count = 0;
		
		for (int i = startNode; i <= endNode; ++i) {			
			int left = countNum(startNode, i - 1, max, f);
			int right = countNum(i + 1, endNode, max, f);
			if(left == 0) count += right;
			else if(right == 0) count += left;
			else count += (left * right);
		}
		f[endNode - startNode + 1] = count;
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
