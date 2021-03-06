import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q089_Gray_Code {
	/******************************************************/
	// by other, nice!
	public List<Integer> grayCode(int n) {
		List<Integer> rs = new ArrayList<Integer>();
		rs.add(0);
		
		for (int i = 0; i < n; i++) {
			int size = rs.size();
			for (int k = size - 1; k >= 0; k--) {
				rs.add(rs.get(k) | 1 << i);    // !!! 高位加入1或0, 注意这里用的是i
			}
		}
		return rs;
	}
	
	
	
	/******************************************************/
	// by Jackie, slower than previous one
	public List<Integer> grayCode2(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        if(n < 0){
            return ans;
        } else if(n == 0){
            ans.add(0);
            return ans;
        }
        
        List<String> list = new ArrayList<String>();
        list.add("");
        
        for(int i = 0; i < n; ++i){
            int size = list.size();
            List<String> path = new ArrayList<String>();
            
            for(int j = 0; j < size; ++j){
                path.add("0" + list.get(j));
            }
            
            for(int j = size - 1; j >= 0; --j){
                path.add("1" + list.get(j));
            }
            
            list = path;
        }
        
        for(String str : list){
            ans.add(strToInt(str));
        }
        
        return ans;
    }
    
    public int strToInt(String source){
        int sum = 0;
        int n = source.length();
        for(int i = 0; i < n; ++i){
            sum = sum * 2 + (source.charAt(i) - '0');
        }
        return sum;
    }
	
    
	
	/***************************************************/
	// by other
	// so the pattern is when n=n -> add 0 in front of all the result of (n-1)'s
	// binary value (This is just same as all the result of (n-1)
	// and add 1 in front of all the result of(n-1)'s binary value (This need to
	// calculate.)

	public List<Integer> grayCode3(int n) {
		List<Integer> result = new ArrayList();
		result.add(0);

		for (int i = 1; i <= n; i++) {
			int front = 1;
		// Create the correct value for binary format (10...0) which the
		// value has i digi
		// so shift 1 to right (i-1) times
			for (int j = 1; j < i; j++) {
				front = front << 1;
			}

		// add the new generated value to the result list
		// the new generated value is the last result add front value
			int size = result.size();
		// we want to loop through the (n-1) result from end to start. This
		// is just because want to make the test case match the Leetcode
		// answer. You can use other way loop through the (n-1) result.
			for (int k = size - 1; k >= 0; k--) {
				
				result.add(result.get(k) + front);
				System.out.println(result.get(k) + front);
				
			}
		}

		return result;
	}
	
	
	
	/******************************************************/
	// by ninechapter
	public ArrayList<Integer> grayCode4(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++){
                result.add(i);
            }
            return result;
        }
        result = grayCode4(n - 1);
        ArrayList<Integer> r1 = reverse(result);
        
        for(int i = 0; i < r1.size(); ++i){
        	System.out.print(r1.get(i) + ", ");
        }
        System.out.println();
        
        int x = 1 << (n-1);
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        result.addAll(r1);
        return result;
    }
    
    public ArrayList<Integer> reverse (ArrayList<Integer> r) {
        ArrayList<Integer> rev = new ArrayList<Integer>();
        for (int i = r.size() - 1; i >= 0; i--) {
            rev.add(r.get(i));
        }
        return rev;
    }

	public static void main(String[] args) {
		Q089_Gray_Code t = new Q089_Gray_Code();
		List<Integer> res = t.grayCode(3);
		for (int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
		System.out.println();

	}
}
