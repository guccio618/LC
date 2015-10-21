import java.util.HashMap;


public class Q290_Word_Pattern {
	//by jackie
	public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length() == 0) return false;
        if(str == null || str.length() == 0) return false;
        
        String[] wordArray = str.split("\\s{1,}");
        if(pattern.length() != wordArray.length) return false;
        HashMap myMap1 = new HashMap<String, Integer>();
        HashMap myMap2 = new HashMap<Character, Integer>();
        for(int i = 0; i < wordArray.length; i++) {
            if(myMap1.containsKey(wordArray[i]) == myMap2.containsKey(pattern.charAt(i))){
                if(!myMap1.containsKey(wordArray[i])){
                    myMap1.put(wordArray[i], i);
                    myMap2.put(pattern.charAt(i), i);
                }
            }
            else
                return false;
        }
        return true;
    }
	
	public static void main(String[] args){
		Q290_Word_Pattern test = new Q290_Word_Pattern();
		String pattern = "abba";
		String str = "dog cat cat dog";
		System.out.println(test.wordPattern(pattern, str));
	}
}
