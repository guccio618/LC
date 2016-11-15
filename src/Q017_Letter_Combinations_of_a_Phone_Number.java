import java.util.ArrayList;
import java.util.List;


public class Q017_Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        
        backtrack(ans, "", digits, 0);
        return ans;
    }
    
    public void backtrack(List<String> ans, String solution, String digits, int startPos) {
        if (startPos == digits.length()) {
            ans.add(solution);
            return ;
        }
        
        String[] array = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int pos = digits.charAt(startPos) - '0';
        
        for (int i = 0; i < array[pos].length(); i++) {
            char c = array[pos].charAt(i);
            
            backtrack(ans, solution + c, digits, startPos + 1);
        }
    }
    
    
    
    
    
    public static void main(String[] args){
    	Q017_Letter_Combinations_of_a_Phone_Number t = new Q017_Letter_Combinations_of_a_Phone_Number();
    	List<String> res = t.letterCombinations("23");
    	for(int i = 0; i < res.size(); ++i)
    		System.out.print(res.get(i) + ", ");
    	System.out.println();
    }
}
