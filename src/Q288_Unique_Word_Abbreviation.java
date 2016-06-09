import java.util.HashMap;
import java.util.Map;


public class Q288_Unique_Word_Abbreviation {
	private Map<String, String> map;
    
    public Q288_Unique_Word_Abbreviation(String[] dictionary) {
        map = new HashMap<String, String>();
        if(dictionary == null || dictionary.length == 0){
            return ;
        }
        
        int n = dictionary.length;
        
        for(int i = 0; i < n; i++){
            String abbreStr = getAbbreviation(dictionary[i]);
            if(!map.containsKey(abbreStr)){
                map.put(abbreStr, dictionary[i]);
            } else {
                if(!map.get(abbreStr).equals(dictionary[i])){
                    map.put(abbreStr, "2");
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String abbreStr = getAbbreviation(word);
        if(!map.containsKey(abbreStr)){
            return true;
        } else {
            return map.get(abbreStr).equals(word);
        }
    }
    
    public String getAbbreviation(String target){
        if(target == null || target.length() <= 2){
            return target;
        }
        
        StringBuffer builder = new StringBuffer();
        int len = target.length();
        builder.append(target.charAt(0)).append(len - 2).append(target.charAt(len - 1));
        return builder.toString();
    }
}
