import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


public class Q187_Repeated_DNA_Sequences {
	/****************************************************************/
	// by Jackie
	public LinkedList<String> findRepeatedDnaSequences(String s) {
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
	
	
	public static void main(String[] args){
		Q187_Repeated_DNA_Sequences t = new Q187_Repeated_DNA_Sequences();
		LinkedList<String> res = t.findRepeatedDnaSequences("AAAAAAAAAAAA");
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
	}
}
