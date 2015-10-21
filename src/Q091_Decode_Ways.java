
public class Q091_Decode_Ways {
	//by ninechapter
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] res = new int[s.length() + 1];
        int n = s.length();
        res[0] = 1;
        res[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                res[i] = res[i - 1];
            }
            
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                res[i] += res[i - 2];
            }
        }
        return res[s.length()];
    }
	
	public static void main(String[] args){
		Q091_Decode_Ways test = new Q091_Decode_Ways();
		System.out.println(test.numDecodings("06"));
		
		
		
	}
	
}
