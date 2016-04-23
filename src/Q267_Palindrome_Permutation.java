import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q267_Palindrome_Permutation {
	public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return ans;
        } else if(s.length() == 1){
        	ans.add(s);
        	return ans;
        }
        
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuffer builder = new StringBuffer();
        int n = array.length;
        int faster = 1, slower = 0;
        char mark = ' ';
        int count = 0;
        
        while(faster < n){
            if(array[faster] == array[slower]){
                builder.append(array[faster]);
                faster += 2;
                slower += 2;
            } else {
                mark = array[slower];
                slower++;
                faster++;
                count++;
            }
        }
        
        if(array[n - 1] != array[n - 2]){
        	count++;
        	mark = array[n - 1];
        }
        if(count > 1){
    		return ans;
    	}
        
        String newStr = builder.toString();
        boolean[] visited = new boolean[newStr.length()];
        backtrack(ans, visited, newStr, "");
        
        for(int i = 0; i < ans.size(); i++){
        	String str = ans.get(i);
        	StringBuffer sb = new StringBuffer(str);
        	String revereStr = sb.reverse().toString();
        	str = count == 0 ? str + revereStr : str + mark + revereStr;
        	ans.set(i, str);
        }
        
        return ans;
	}
	
	public void backtrack(List<String> ans, boolean[] visited, String newStr, String solution){
		if(solution.length() == newStr.length()){
			ans.add(solution);
			return;
		}
		
		for(int i = 0; i < newStr.length(); i++){
			if(visited[i] == true){
				continue;
			}
			visited[i] = true;
			backtrack(ans, visited, newStr, solution + newStr.charAt(i));
			visited[i] = false;
		}
	}
	
	
	
	
	
	
	
	public List<String> generatePalindromes2(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return ans;
        }
        
        boolean[] visited = new boolean[s.length()];
        backtrack(s, visited, "", ans);
        return ans;
    }
    
    public void backtrack(String s, boolean[] visited, String path, List<String> ans){
        if(path.length() == s.length()){
            if(isPalindrome(path)){
                ans.add(path);
            }
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            backtrack(s, visited, path + s.charAt(i), ans);
            visited[i] = false;
        }
    }
    
    public boolean isPalindrome(String str){
        if(str.length() == 1){
            return true;
        }
        
        int left = 0, right = str.length() - 1;
        
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    
    public static void main(String[] args){
    	Q267_Palindrome_Permutation t = new Q267_Palindrome_Permutation();
    	String str = "a";
    	List<String> res = t.generatePalindromes(str);
    	
    	for(int i = 0; i < res.size(); i++){
    		System.out.print(res.get(i) + ", ");
    	}
    }
}
