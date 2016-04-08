import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Q049_Group_Anagrams {
	// by Jackie
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return ans;
        }
        
        HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        int n = strs.length;
        Arrays.sort(strs);
        
        for(int i = 0; i < n; ++i){
            String newStr = sort(strs[i]);
            if(map.containsKey(newStr)){
                map.get(newStr).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(newStr, list);
            }
        }
        
        Iterator iter = map.entrySet().iterator();
        
        while(iter.hasNext()){
        	HashMap.Entry entry = (HashMap.Entry) iter.next(); 
        	ans.add((ArrayList<String>) entry.getValue());
        }
        
        return ans;
    }
    
    public String sort(String target){
        char[] letters = target.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    
    
    
    
    public static void main(String[] args){
    	Q049_Group_Anagrams t = new Q049_Group_Anagrams();
    	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	List<List<String>> res = t.groupAnagrams(strs);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
