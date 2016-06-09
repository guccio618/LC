
public class Q161_One_Edit_Distance {
	public boolean isOneEditDistance(String s, String t) {
        if(s == null){
            if(t == null || t.length() == 1){
                return true;
            } else {
                return false;
            }
        }
        if(t == null){
            if(s == null || s.length() == 1){
                return true;
            } else {
                return false;
            }
        }
        if(Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        
        int len1 = s.length(), len2 = t.length();
        if(len1 == len2){
            return oneModify(s, t);
        } else if(len1 > len2){
            return oneDel(s, t);
        } else {
            return oneDel(t, s);
        }
    }
    
    public boolean oneModify(String s, String t){
        int n = s.length();
        int diff = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
    
    public boolean oneDel(String s, String t){
        for(int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i + 1).equals(t.substring(j));
            }
        }
        return true;
    }
}
