
public class Q387_First_Unique_Character_in_a_String {
	// by Jackie
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        
        int[] hash = new int[256];
        
        for(char c : s.toCharArray()){
            hash[c]++; 
        }
        
        for(int i = 0; i < s.length(); i++){
            if(hash[s.charAt(i)] == 1){
                return i;
            }
        }
        
        return -1;
    }
}
