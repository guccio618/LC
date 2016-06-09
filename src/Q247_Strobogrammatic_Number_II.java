import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q247_Strobogrammatic_Number_II {
	public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<String>();
        if(n < 1){
            return ans;
        }
        
        int[] nums1 = {0, 1, 8};
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        
        if(n % 2 == 1){
            helper(ans, map, "0", n);
            helper(ans, map, "1", n);
            helper(ans, map, "8", n);
        } else {
            helper(ans, map, "", n);
        }
        
        return ans;
    }
    
    public void helper(List<String> ans, Map<Character, Character> map, String solution, int n){
        if(solution.length() == n){
            ans.add(solution);
//            System.out.println("in here");
            return;
        }
        
        char[] nums2 = {'0', '1', '6', '8', '9'};
        
        for(int i = 0; i < 5; i++){
            char c1 = nums2[i];
            char c2 = map.get(c1);
            helper(ans, map, c1 + solution + c2, n);
        }
    }
    
    
    public static void main(String[] args){
    	Q247_Strobogrammatic_Number_II t = new Q247_Strobogrammatic_Number_II();
    	List<String> ans = t.findStrobogrammatic(1);
    	
    	for(int i = 0; i < ans.size(); i++){
    		System.out.print(ans.get(i) + ", ");
    	}
    }
}
