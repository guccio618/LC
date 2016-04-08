
public class Q125_Valid_Palindrome {
	// by Jackie
	public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return true;
        }
        
        char[] letters = s.toCharArray();
        int left = 0, right = letters.length - 1;
        
        while(left < right){
            if( (letters[left] >= '0' && letters[left] <= '9') || (letters[left] >= 'a' && letters[left] <= 'z') || (letters[left] >= 'A' && letters[left] <= 'Z') ){
                if(letters[left] >= 'A' && letters[left] <= 'Z'){
                	letters[left] += 32; 
                }
            } else {
                left++;
                continue;
            }
            
            if( (letters[right] >= '0' && letters[right] <= '9') || (letters[right] >= 'a' && letters[right] <= 'z') || (letters[right] >= 'A' && letters[right] <= 'Z') ){
            	if(letters[right] >= 'A' && letters[right] <= 'Z'){
                	letters[right] += 32; 
                }
            } else {
                right--;
                continue;
            }
            
            if(letters[left] == letters[right]){
                left++;
                right--;
            } else {
                return false;
            }
        }
        
        return true;
    }
	
	
	
	public static void main(String[] args){
		Q125_Valid_Palindrome t = new Q125_Valid_Palindrome();
		String[] test = {"", "1", "22", "313", "333", "A man, a plan, a canal: Panama", "23", "321", "race a car"};
		
		for(int i = 0; i < test.length; ++i){
			System.out.println(t.isPalindrome(test[i]));
		}
	}
}
