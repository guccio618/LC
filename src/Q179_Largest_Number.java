import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*******************************************
(1). Comparator                
/*******************************************/

public class Q179_Largest_Number {
	class NumbersComparator implements Comparator<String> {  //by Ninechapter
		@Override
		public int compare(String s1, String s2) {
			return (s2 + s1).compareTo(s1 + s2);
		}
	}
	
	public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }
	    
//**************************************************************
    
	public String largestNumber_2(int[] nums) {  //by Jackie
        if(nums.length == 0) return "";
        String res = "", str1 = "", str2 = "";
        int len = nums.length, temp_int = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                str1 = Integer.toString(nums[i]);
                str2 = Integer.toString(nums[j]);
                int k = 0;
                while(k < str1.length() || k < str2.length()){
                	if(k == str1.length() || k == str2.length()){
                		String temp_str1 = str1 + str2;
                		String temp_str2 = str2 + str1;
                		int temp_len = temp_str1.length();
                		for(int x = 0; x < temp_len; x++){
                			if(temp_str1.charAt(x) - temp_str2.charAt(x) < 0){
                				temp_int = nums[i];
                                nums[i] = nums[j];
                                nums[j] = temp_int;
                                break;
                			}
                			else if (temp_str1.charAt(x) - temp_str2.charAt(x) > 0)
                				break;
                		}
                		break;
                	}
                	else if(str1.charAt(k) - str2.charAt(k) < 0){
                        temp_int = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp_int;
                        break;
                    }
                    else if(str1.charAt(k) - str2.charAt(k) > 0)
                        break;
                    else k++;
                }
            }
        }
        if(nums[0] == 0) return "0";
        for(int i = 0; i < len; i++)
            res += Integer.toString(nums[i]);
        return res;
    }
	
	
	public static void main(String[] args){
		Q179_Largest_Number l = new Q179_Largest_Number();
		int[] nums = {0, 0};
		System.out.println(l.largestNumber(nums));
		System.out.println(l.largestNumber_2(nums));
	}
}
