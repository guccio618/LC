import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q249_Group_Shifted_Strings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0){
            return ans;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strings){
            String newStr = getFirstShifted(str);

            if(map.containsKey(newStr)){
                map.get(newStr).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(newStr, list);
            }
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> list = entry.getValue();
            Collections.sort(list, new Comparator<String>(){
                public int compare(String left, String right){
                    return left.compareTo(right);
                }
            });
            ans.add(list);
        }
        
        return ans;
    }
    
    public String getFirstShifted(String target){
        int n = target.length();
        int diff = target.charAt(0) - 'a';
        char[] letters = target.toCharArray();
        
        for(int i = 0; i < n; i++){
        	int distance = letters[i] - 'a' - diff;
        	if(distance >= 0){
        		letters[i] -= diff;
        	} else {
        		letters[i] = (char) (distance + 26 + 'a');
        	}
        }
        
        return new String(letters);
    }
    
    
    
    public static void main(String[] args){
    	Q249_Group_Shifted_Strings t = new Q249_Group_Shifted_Strings();
    	String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
//    	String[] strings = {"az", "ba"};
    	List<List<String>> ans = t.groupStrings(strings);
    	
    	for(int i = 0; i < ans.size(); i++){
    		for(int j = 0; j < ans.get(i).size(); j++){
    			System.out.print(ans.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
