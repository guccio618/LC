import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Q243_Shortest_Word_Distance {
	/****************************************************************/
	// by Jackie, time complexity is O(n)
	public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int flag = 0;
        int position1 = 0, position2 = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(words[i].equals(word1)){
                position1 = i;
                if(flag == 2){
                    ans = Math.min(ans, position1 - position2);
                }
                flag = 1;
            }
            if(words[i].equals(word2)){
                position2 = i;
                if(flag == 1){
                    ans = Math.min(ans, position2 - position1);
                }
                flag = 2;
            }
        }
        
        return ans;
    }
	
	
	
	/****************************************************************/
	// by Jackie using hashmap, time complexity is O(n^2)
	public int shortestDistance2(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i : map.get(word1)){
            for(int j : map.get(word2)){
                ans = Math.min(ans, Math.abs(i - j));
            }
        }
        
        return ans;
    }
	
	public static void main(String[] args){
		Q243_Shortest_Word_Distance t = new Q243_Shortest_Word_Distance();
		String[] words ={"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(t.shortestDistance(words, "coding", "makes"));
	}
}
