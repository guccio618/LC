import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Q336_Palindrome_Pairs {
	/******************************************/
	// by other
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> ans = new LinkedList<>();
	    if (words == null) {
	    	return ans;
	    }
	    
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    
	    for (int i = 0; i < words.length; ++ i) {
	    	map.put(words[i], i);
	    }
	    
	    for (int i = 0; i < words.length; ++ i) {
	        int left = 0, right = 0;
	        while (left <= right) {
	            String s = words[i].substring(left, right);
	            Integer j = map.get(new StringBuilder(s).reverse().toString());
	            String str = words[i].substring(left == 0 ? right : 0, left == 0 ? words[i].length() : left);
	            
	            if (j != null && i != j && isPalindrome(str) == 1){
	                ans.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
	            }
	            
	            if (right < words[i].length()){
	            	++right;
	            } else {
	            	++left;
	            }
	        }
	    }
	    
	    return ans;
	}
	
	
	
	/******************************************/
	// by Jackie but exceed time limited
	public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0){
            return ans;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = words.length;
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
            	if(i == j){
            		continue;
            	}
            	
                String newStr = words[i] + words[j];
                int validFlag = 0;
                
                if(map.containsKey(newStr)){
                	validFlag = map.get(newStr);
                } else {
                	validFlag = isPalindrome(newStr);
                    map.put(newStr, validFlag);                   
                }
                
                if(validFlag == 1){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
    
    public int isPalindrome(String str){
        int n = str.length();
        int left = 0, right = n - 1;
        
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            } else {
                return 0;
            }
        }
        
        return 1;
    }
    
    
    public static void main(String[] args){
    	Q336_Palindrome_Pairs t = new Q336_Palindrome_Pairs();
    	String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
    	List<List<Integer>> ans = t.palindromePairs(words);
    	
    	for(int i = 0; i < ans.size(); ++i){
    		for(int j = 0; j < ans.get(i).size(); ++j){
    			System.out.print(ans.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    	
//    	System.out.println(t.isPalindrome("abbca"));
    }
}
