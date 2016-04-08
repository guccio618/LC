import java.util.HashMap;


public class Q205_Isomorphic_Strings {
	// by Jackie
	public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()){
            if( (s == null && t == null) || (s.length() == 0 && t.length() == 0) ){
                return true;
            } else {
                return false;
            }
        }
        
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        int n = array1.length;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        for(int i = 0; i < n; ++i){
            if(map.containsKey(array1[i])){
                if(array2[i] != map.get(array1[i])){
                    return false;
                }
            } else {
                if(map.containsValue(array2[i])){
                    return false;
                } else {
                    map.put(array1[i], array2[i]);
                }
            }
        }
        
        return true;
    }
}
