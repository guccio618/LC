import java.util.LinkedList;


public class Q131_Palindrome_Partitioning {
	/********************************************************/
	// by Jackie using backtrack
	private LinkedList<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
    
    public LinkedList<LinkedList<String>> partition(String s) {
        if(s == null) return res;
        LinkedList<String> path = new LinkedList<String>();
        for(int i = 1, len = s.length(); i <= len; ++i)
        	backtrack(s, 0, i, path);
        return res;
    }
    
    public void backtrack(String s, int start, int end, LinkedList<String> path){
    	if(isPalindrome(s.substring(start, end)) == false) return;
        path.add(s.substring(start, end));
        if(end == s.length())
        	res.add(new LinkedList<String>(path));
        else{
            for(int i = end+1, len = s.length(); i <= len; ++i)
            	backtrack(s, end, i, path);
        }
        path.remove(path.size()-1);
    }
    
    public boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        int front = 0;
        int back = s.length()-1;
        while(front <= back){
            if(s.charAt(front++) != s.charAt(back--))
                return false;
        }
        return true;
    }
    
    public boolean isPalindrome2(String s){     // by other, but a little slow
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString().equals(s);
    }
	
	
	
	public static void main(String[] args){
		Q131_Palindrome_Partitioning t = new Q131_Palindrome_Partitioning();
		String s = "aab";
		LinkedList<LinkedList<String>> res = t.partition(s);
		
		for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}

	}
}
