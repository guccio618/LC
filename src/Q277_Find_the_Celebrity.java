
public class Q277_Find_the_Celebrity {
	public int findCelebrity(int n) {
        if(n <= 0){
            return -1;
        }
        
        int candidate = 0;
        
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)){   // n 从 1 开始
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){    // n 从 0 开始
            if(candidate != i){
                if(!knows(i, candidate) || knows(candidate, i)){
                    return -1;
                }
            }
        }
        
        return candidate;
    }
	
	
		
	public boolean knows(int x, int y){
		return true;
	}
}
