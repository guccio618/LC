
public class Q345_Reverse_Vowels_of_a_String {
	public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return new String();
        }
        
        int left = 0, right = s.length() - 1;
        char[] letters = s.toCharArray();
        
        while(left < right){
            while(left < right && isVowel(letters[left]) == false){
                left++;
            }
            while(left < right && isVowel(letters[right]) == false){
                right--;
            }
            if(left < right && letters[left] != letters[right]){
                char temp = letters[left];
                letters[left] = letters[right];
                letters[right] = temp;
            }
            left++;
            right--;
        }
        
        return new String(letters);
    }
    
    public boolean isVowel(char c){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        for(int i = 0; i < vowels.length; i++){
            if(c == vowels[i]){
                return true;
            }
        }
        
        return false;
    }
}
