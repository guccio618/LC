import java.util.LinkedList;

public class Q093_Restore_IP_Addresses {
	public LinkedList<String> restoreIpAddresses(String s) {
		LinkedList<String> res = new LinkedList<String>();
        if(s==null || s.length() < 4 || s.length() > 12) return res;
        helper(s, 0, res, new LinkedList<String>());
        return res;
    }

    public void helper(String s, int startIndex, LinkedList<String> res, LinkedList<String> path){
        if(path.size() == 4){
            if(startIndex == s.length()){
                String str = "";
                for(int i = 0; i < 4; i++){
                    str += path.get(i);
                    if(i != 3) str += '.';
                }
                res.add(str);
            }
            return;
        }

        for(int i = startIndex; i < startIndex + 3 && i < s.length(); i++){
            if(s.charAt(startIndex) == '0' && i != startIndex) break;
            String cur = s.substring(startIndex, i+1);
            if(Integer.valueOf(cur) <= 255){
                path.add(cur);
                helper(s, i+1, res, path);
                path.remove(path.size()-1);
            }
        }
    }
}
