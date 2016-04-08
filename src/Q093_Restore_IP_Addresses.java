import java.util.LinkedList;

public class Q093_Restore_IP_Addresses {
	// by other
	// test case = "0000"
	public LinkedList<String> restoreIpAddresses(String s) {
		LinkedList<String> res = new LinkedList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return res;
		}
		backtrack(s, 0, res, new LinkedList<String>());
		return res;
	}

	public void backtrack(String s, int startIndex, LinkedList<String> ans, LinkedList<String> solution) {
		if(solution.size() == 4){
            if(startIndex == s.length()){
                StringBuffer builder = new StringBuffer();
                builder.append(solution.get(0));
                for(int i = 1; i < solution.size(); ++i){
                    builder.append(".").append(solution.get(i));
                }
                ans.add(builder.toString());
            }
            return;
        } 

		for(int endIndex = startIndex; endIndex < startIndex + 3 && endIndex < s.length(); ++endIndex){
            if(s.charAt(startIndex) == '0' && endIndex != startIndex){
                break;
            }
            String currentStr =s.substring(startIndex, endIndex + 1);
            if(Integer.parseInt(currentStr) <= 255){
                solution.add(currentStr);
                backtrack(s, endIndex + 1, ans, solution);
                solution.remove(solution.size() - 1);
            }
        }
	}
}
