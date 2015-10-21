
public class Q067_Add_Binary {
	public String addBinary(String a, String b) {
        if(b.length() == 0) return a;
        if(a.length() == 0) return b;
        String res = "";
        int len = (a.length() > b.length()) ? a.length(): b.length(), cnt = 0, sum = 0;
        for(int i = 0; i < len; i++){
            if(i >= a.length())
                sum = b.charAt(b.length()-i-1) - '0' + cnt;
            else if(i >= b.length())
                sum = a.charAt(a.length()-i-1) - '0' + cnt;
            else
                sum = a.charAt(a.length()-i-1) - '0' + b.charAt(b.length()-i-1) - '0' + cnt;       
            if(sum > 1){
                cnt = 1;
                sum %= 2; 
            }
            else
                cnt = 0;
            res = (char)(sum + '0') + res;
        }
        if(cnt == 1) res = '1' + res;
        return res;
    }
	
	public static void main(String[] args){
		Q067_Add_Binary ab = new Q067_Add_Binary();
		String str1 = "1010", str2 = "1011";
		System.out.println(ab.addBinary(str1, str2));
	}
}
