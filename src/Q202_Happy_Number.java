import java.util.HashSet;


public class Q202_Happy_Number {
	/******************************************************/
	// by other, faster
	public boolean isHappy(int n) {
        int[] map = new int[1000];
        while(n != 1) {
            n = getSum(n);
            map[n]++;
            if (map[n] > 1)
                return false;
        }
        return true;
    }

    public int getSum(int num) {
        char[] temp = (num + "").toCharArray();
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += ((temp[i] - '0') * (temp[i] - '0'));
        }
        return sum;
    }
    
    
    /******************************************************/
	// by Jackie    
	public boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            n = getSum2(n);
            if(set.contains(n))
                return false;
            set.add(n);
        }
        return true;
    }

    public int getSum2(int num) {
        char[] temp = (num + "").toCharArray();
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += ((temp[i] - '0') * (temp[i] - '0'));
        }
        return sum;
    }
}
