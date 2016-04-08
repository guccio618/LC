import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Q187_Repeated_DNA_Sequences {
	/****************************************************************/
	// by Jackie
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() <= 10){
            return ans;
        }
        
        int n = s.length();
        HashSet<String> set = new HashSet<String>();
        HashSet<String> store = new HashSet<String>();
        
        for(int i = 0; i <= n - 10; ++i){
            String subStr = s.substring(i, i + 10);
            if(set.contains(subStr)) {
                if(!store.contains(subStr)){
                	store.add(subStr);
                    ans.add(subStr);
                }
            } else {
                set.add(subStr);
            }
        }
        
        return ans;
    }
	
	
	
	
	/****************************************************************/
	// by Jackie
	public LinkedList<String> findRepeatedDnaSequences2(String s) {
		LinkedList<String> res = new LinkedList<String>();
        if(s == null || s.length() == 0) return res;
        HashSet<String> stringSet = new HashSet<String>();
        HashSet<String> resSet = new HashSet<String>();
        
        for(int i = 0, len = s.length(); i <= len-10; ++i){
            if( stringSet.contains(s.substring(i, i+10)) )
                resSet.add(s.substring(i, i+10));
            else
                stringSet.add(s.substring(i, i+10));
        }
        
        Iterator iter = resSet.iterator();
        while(iter.hasNext())
        	res.add((String)iter.next());       
        return res;
    }
	
	
	
	/********************************* main function *******************************/
	public static void main(String[] args){
		Q187_Repeated_DNA_Sequences t = new Q187_Repeated_DNA_Sequences();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s2 = "AAAAAAAAAAAA";
		List<String> res = t.findRepeatedDnaSequences2(s);
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
	}
}
