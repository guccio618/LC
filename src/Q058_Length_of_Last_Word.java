
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
}
