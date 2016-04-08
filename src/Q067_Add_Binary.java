
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
	
	public String addBinary2(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        } else if(b == null || b.length() == 0){
            return a;
        }
        
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        boolean plusOneFlag = false;
        int x = a.length() - 1;
        int y = b.length() - 1;
        StringBuffer ans = new StringBuffer();
        
        while(x >= 0 && y >= 0){
            if(num1[x] == '1' && num2[y] == '1'){
                if(plusOneFlag == true){
                    ans.append("1");
                } else {
                    ans.append("0");
                }
                plusOneFlag = true;
            } else if(num1[x] == '0' && num2[y] == '0'){
                if(plusOneFlag == true){
                    ans.append("1");
                } else {
                    ans.append("0");
                }
                plusOneFlag = false;
            } else {
                if(plusOneFlag == true){
                    ans.append("0");
                    plusOneFlag = true;
                } else {
                    ans.append("1");
                    plusOneFlag = false;
                }
            }
        	System.out.println(num1[x] + ", " + num2[y] + ", " + plusOneFlag + ", " + ans.toString());
            x--;
            y--;
        }
        
        while(x >= 0){
            if(num1[x] == '1'){
                if(plusOneFlag = true){
                    ans.append("0");
                    plusOneFlag = true;
                } else {
                    ans.append("1");
                    plusOneFlag = false;
                }
            } else {
                if(plusOneFlag = true){
                    ans.append("1");
                } else {
                    ans.append("0");
                }
                plusOneFlag = true;
            }
            x--;
        }
        
        while(y >= 0){
            if(num2[y] == '1'){
                if(plusOneFlag == true){
                	System.out.println("1");
                    ans.append("0");
                    plusOneFlag = true;
                } else {
                	System.out.println("2");
                    ans.append("1");
                    plusOneFlag = false;
                }
            } else {
                if(plusOneFlag == true){
                	System.out.println("3");
                    ans.append("1");
                } else {
                	System.out.println("4");
                    ans.append("0");
                }
                plusOneFlag = false;
            }
            System.out.println(num2[y] + ", " + plusOneFlag + ", " + ans.toString());
            y--;
        }
        
        if(plusOneFlag == true){
            ans.append("1");
        }
        
        ans.reverse();
        return ans.toString();
    }
	
	public static void main(String[] args){
		Q067_Add_Binary ab = new Q067_Add_Binary();
		String str1 = "10", str2 = "101111";
		System.out.println(ab.addBinary2(str1, str2));
	}
}
