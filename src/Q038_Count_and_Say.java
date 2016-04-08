
public class Q038_Count_and_Say {
	/**************************************/
	// by other
	public String countAndSay(int n) {
        if(n <= 0) {
        	return "-1";
        }
        
        String result = "1";

        for(int i = 1; i < n; i ++) {
            result = build(result);
        }
        return result;
    }

    private String build(String result) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while(index < result.length()) {
            char val = result.charAt(index);
            int count = 0;

            while(index < result.length() && result.charAt(index) == val){
                index ++;
                count ++;
            }
            
            builder.append(String.valueOf(count));
            builder.append(val);
        }
        
        return builder.toString();
    }
	
	
    
    /**************************************/
	// by other
	public String countAndSay2(int n) {
        if (n == 1) {
        	return "1";
        }

        String prevStr = countAndSay2(n - 1);
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
		System.out.println(t.countAndSay(25));
	}
}
