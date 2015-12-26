public class Q299_Bulls_and_Cows {
	// by Jackie
	public String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
        int[] words = new int[10];

        for(int i = 0, len = secret.length(); i < len; ++i)
            words[secret.charAt(i) - '0']++;
        
        for(int i = 0, len = secret.length(); i < len; ++i){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g == s){
            	if(words[g - '0'] == 0)
            		cows--;
            	else
            		words[g - '0']--;
            	bulls++;
            }
            else if(words[g - '0'] != 0){
                words[g - '0']--;
                cows++;
            }
        }
        
        String s = new String();
        s = bulls + "A" + cows + "B";        
        return s.toString();
    }
	
	public static void main(String[] args){
		Q299_Bulls_and_Cows t = new Q299_Bulls_and_Cows();
		System.out.println(t.getHint("1121", "0311"));
	}
}
