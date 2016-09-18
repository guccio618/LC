import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Q403_Frog_Jump {
	public boolean canCross(int[] stones) {
        if (stones.length < 1 || stones[0] != 0){
        	return false;
        }
        
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int s : stones){
        	map.put(s, new HashSet<Integer>());
        }
        
        for (int stone : stones) {
            Set<Integer> jSet = map.get(stone);
            
            // Initial condition
            if (stone == 0) {
                jSet.add(0);
                
                if (map.containsKey(1)){
                	map.get(1).add(1);
                }
                continue;
            }
            
            // For other stones
            for (int prevJump : jSet) {
                int curJump = prevJump - 1;
                int nextStone = stone + curJump;
                
                // Previous jump - 1
                if (nextStone != stone && map.containsKey(nextStone)) {
                	map.get(nextStone).add(curJump);
                }
                
                // Previous jump
                curJump++; 
                nextStone = stone + curJump;
                
                if (nextStone != stone && map.containsKey(nextStone)) {
                	map.get(nextStone).add(curJump);
                }
                
                // Previous jump + 1
                curJump++; 
                nextStone = stone + curJump;
                
                if (nextStone != stone && map.containsKey(nextStone)) {
                	map.get(nextStone).add(curJump);
                }
            }
        }
        
        return !map.get(stones[len - 1]).isEmpty();
	}
	
	
	public boolean canCross2(int[] stones) {
        if(stones == null || stones.length <= 1){
        	return true;
        } else if(stones.length == 2){
        	return stones[1] == 1;
        }
        
        int len = stones.length;
        Set<Integer>[] jump = new Set[len];
        
        for(int i = 0; i < len; i++){
        	jump[i] = new HashSet<Integer>();
        }
        jump[1].add(1);
        
        for(int i = 2; i < len; i++){
        	for(int j = i - 1; j > 0; j--){        		
        		for(int step : jump[j]){
        			int diff = stones[i] - stones[j];
        			
        			if(diff == step){
        				jump[i].add(step);
        			} else if(diff == step + 1){
        				jump[i].add(step + 1);
        			} else if(diff == step - 1){
        				jump[i].add(step - 1);
        			}
        		} 
        	}
        }
        
//        for(int i = 0; i < len; i++){
//        	System.out.print(jump[i] + ", ");
//        }
//        System.out.println();
        
        return jump[len - 1].size() != 0; 
	}
	
//	public boolean canCross(int[] stones) {
//        if(stones == null || stones.length == 0){
//        	return true;
//        }
//        
//        int len = stones.length;
//        boolean[] canReach = new boolean[len];
//        canReach[0] = true;
//        int currentStep = 1;
//        
//        for(int i = 0; i < len; i++){
//        	if(canReach[i] == true){
//        		int j = i + 1;
//            	
//            	while(j < len){
//            		int diff = stones[j] - stones[i];
//            		
//            		if(diff == currentStep + 1 || diff == currentStep - 1){
//            			canReach[j] = true;
//            			j++;
//            		} else if(diff > currentStep + 1){
//            			break;
//            		}
//            	}
//        	}
//        }
//        
//        return canReach[len - 1];
//    }
	
	
	public static void main(String[] args){
		Q403_Frog_Jump t = new Q403_Frog_Jump();
		int[] stones = {0,1,3,5,6,8,12,17};
		int[] stones2 = {0,1,2,3,4,8,9,11};
		
		System.out.println(t.canCross(stones));
		System.out.println(t.canCross(stones2));
	}
}
