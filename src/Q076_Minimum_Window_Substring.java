
public class Q076_Minimum_Window_Substring {
	// by ninechapter using two pointers
	public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()){
            return new String();
        }
        
        int[] targetHash = new int[256];
        int[] sourceHash = new int[256];
        int end = 0, n = s.length(), tLen = t.length();
        int ans = Integer.MAX_VALUE;
        String ansStr = "";
        
        for(int i = 0; i < tLen; ++ i){
            targetHash[t.charAt(i)]++;
        }
        
        for(int start = 0; start < n; ++start){
            while(end < n && !isValid(sourceHash, targetHash)){
                sourceHash[s.charAt(end)]++;
                end++;
            }
            if(isValid(sourceHash, targetHash)){
                if(ans > end - start){
                    ans = end - start;
                    ansStr = s.substring(start, end);
                }
            }
            sourceHash[s.charAt(start)]--;
        }
        
        return ansStr;
   }
   
   public boolean isValid(int[] sourceHash, int[] targetHash){
       for(int i = 0; i < 256; ++i){
           if(targetHash[i] > sourceHash[i]){
               return false;
           }
       }
       return true;
   }
   
   
   
   public static void main(String[] args){
	   Q076_Minimum_Window_Substring t = new Q076_Minimum_Window_Substring();
	   String s = "a";
	   String target = "a";
	   
	   System.out.println(t.minWindow(s, target));
   }
}
