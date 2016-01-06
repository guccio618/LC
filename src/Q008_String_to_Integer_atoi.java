
public class Q008_String_to_Integer_atoi {
	/********************************************************/
	// by Jackie
	public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        long sum = 0;
        str = str.trim();
        int flag = 1;
        int i = 0;
        char[] nums = str.toCharArray();
        if(nums[0] == '+' || nums[0] == '-'){
        	if(nums[0] == '-') flag = -1;
        	i = 1;
        }

        for(int len = nums.length; i < len; ++i){
        	if(nums[i] > '9' || nums[i] < '0') 
        	    break;
            sum = sum*10 + (int)(nums[i]-'0'); 
            if (flag == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (flag == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }      
        return (int) sum * flag;
    }
	
	
	public static void main(String[] args){
		Q008_String_to_Integer_atoi t = new Q008_String_to_Integer_atoi();
		System.out.println(t.myAtoi("-0012a"));
	}
}
