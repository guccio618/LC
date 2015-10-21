
public class Q165_Compare_Version_Numbers {
	public int compareVersion(String version1, String version2) {
        if(version1.length() == 0) return -1;
        if(version2.length() == 0) return 0;
        String str1 = "", str2 = "";
        int i = 0, j = 0, num1 = 0, num2 = 0;
        
        while(i < version1.length() || j < version2.length()){
        	str1 = "";
        	while(i < version1.length() && version1.charAt(i) != '.')
        		str1 += version1.charAt(i++);
        	if(i <= version1.length()) num1 = Integer.parseInt(str1);
        	else num1 = 0;
        	System.out.println("num1 = " + num1);
        	str2 = "";
        	while(j < version2.length() && version2.charAt(j) != '.')
        		str2 += version2.charAt(j++);
        	if(j <= version2.length()) num2 = Integer.parseInt(str2);
        	else num2 = 0;
        	System.out.println("num1 = " + num1 + ", num2 = " + num2);
        	if(num1 > num2) return 1;
        	if(num1 < num2) return -1;
        	else{i++; j++;}        	
        }
        System.out.println("i = " + i + ", j = " + j);
        num1 = (str1.equals("") == true) ? 0 : Integer.parseInt(str1);
        num2 = (str2.equals("") == true) ? 0 : Integer.parseInt(str2);
        if(num1 > num2) return 1;
        if(num1 < num2) return -1;
        else return 0;
    }
	
	public static void main(String[] args){
		Q165_Compare_Version_Numbers c = new Q165_Compare_Version_Numbers();
		System.out.println(c.compareVersion("012", "1.0.0"));
	}
}
