
public class Q038_Count_and_Say {
	// by other
	public String countAndSay(int n) {
        if (n == 1) return "1";
        String prevStr = countAndSay(n - 1);
        System.out.println("prevStr = " + prevStr);
        StringBuffer sb = new StringBuffer();
        int count = 0;
        int ptr = 0;
        
        while (ptr < prevStr.length()) {
            count++;
            char curChar = prevStr.charAt(ptr);
            if (ptr + 1 >= prevStr.length() || curChar != prevStr.charAt(ptr + 1)) {
                sb.append(count).append(curChar);
                count = 0;
            }
            ptr++;
        }
        return sb.toString();
    }
	
	public static void main(String[] args){
		Q038_Count_and_Say t = new Q038_Count_and_Say();
		System.out.println(t.countAndSay(10));
	}
}
