
public class Q306_Additive_Number {
	/*******************************************************************/
	// by other using DFS
	public boolean isAdditiveNumber(String num) {
        for(int i=1; i<num.length()-1; i++){
            for(int j=i+1; j<num.length(); j++) {
                if(dfs(num, 0, i, j)) return true;
            }
        }
        return false;
    }
	
	private boolean dfs(String num, int start, int end1, int end2) {
        String s1 = num.substring(start, end1);
        String s2 = num.substring(end1, end2);
        if((s1.length()>1 && s1.charAt(0)=='0') || (s2.length()>1 && s2.charAt(0)=='0')) return false;
        long n1 = Long.valueOf(s1);
        long n2 = Long.valueOf(s2);
        String result = String.valueOf(n1+n2);
        if(num.substring(end2).length()==0) return true;
        if(num.substring(end2).indexOf(result)!=0) return false;
        return dfs(num, end1, end2, end2+result.length());
    }
	
	
	
	/*******************************************************************/
	// by other
	public boolean isAdditiveNumber2(String num) {
        if (num=="")
            return false;
        for (int i=1;i<num.length()-1;i++) {
            if (i>=num.length()-i)
                return false;
            if (num.charAt(0)=='0' && i>1)
                return false;
            for (int j=i+1;j<num.length();j++) {
                if (num.charAt(i)=='0' && j>i+1)
                    break;
                if (j-i>num.length()-j)
                    break;
                if (num.charAt(j)=='0')
                    continue;
                Long left=Long.parseLong(num.substring(0, i));
                Long right=Long.parseLong(num.substring(i, j));
                String sum=Long.toString(left+right);
                String other=num.substring(j, num.length());;
                while (other.length()>0 && !other.startsWith("0")) {
                    if (!other.startsWith(sum))
                        break;
                    other=other.substring(sum.length());
                    left=right;
                    right=Long.valueOf(sum);
                    sum=Long.toString(left+right);
                }
                if (other.length()==0)
                    return true;
            }
        }
        return false;
    }
}
