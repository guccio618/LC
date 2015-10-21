
public class Q242_Valid_Anagram {
	//by jackie
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return true;
        int n = s.length();
        int[] a = new int[256];
        int[] b = new int[256];
        
        for(int i = 0; i < n; ++i){
            a[(int)s.charAt(i)]++;
            b[(int)t.charAt(i)]++;
        }
        for(int i = 0; i < 256; ++i)
            if(a[i] != b[i])
                return false;
        return true;
    }
	
	
}
