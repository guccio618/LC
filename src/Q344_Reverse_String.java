
public class Q344_Reverse_String {
	public String reverseString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        int left = 0, right = s.length() - 1;
        char[] letters = s.toCharArray();
        
        while(left < right){
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            left++;
            right--;
        }
        
        return new String(letters);
    }
}
