
public class Q058_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int count = 0, start_flag = 0;
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ' && start_flag == 0) continue;
            if(s.charAt(i) == ' ') break;
            start_flag = 1;
            count++;
        }
        return count;
    }
	
	
	public int lengthOfLastWord2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        String[] strArray = s.split("\\s{1,}");
        if(strArray.length == 0){
        	return 0;
        }
        
        return strArray[strArray.length - 1].length();    
    }
	
	public static void main(String[] args){
		Q058_Length_of_Last_Word t = new Q058_Length_of_Last_Word();
		String str = "   Hello world   ";
		System.out.println(t.lengthOfLastWord2(str));
	}
}
