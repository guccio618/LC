import java.util.ArrayList;
import java.util.List;


public class Q017_Letter_Combinations_of_a_Phone_Number {
private List<String> res = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return res;
        }
        char[][] map = {
                            {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, 
                            {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, 
                            {'t','u','v'}, {'w','x','y','z'}
                         };
        char[] digitArray = digits.toCharArray();
        StringBuffer sb = new StringBuffer();
        helper(map, sb, digitArray, 0);
        return res;
    }
    
    public void helper(char[][] map, StringBuffer sb, char[] digitArray, int curPos){
        if(curPos == digitArray.length){
            res.add(sb.toString());
            return;
        }
        int num = digitArray[curPos] - '0';
        if(num < 2 || num > 9){
            return;
        }
        for(int i = 0, len = map[num - 2].length; i < len; ++i){
            sb.append(map[num - 2][i]);
            helper(map, sb, digitArray, curPos + 1);
            sb.deleteCharAt(sb.length() - 1);
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
