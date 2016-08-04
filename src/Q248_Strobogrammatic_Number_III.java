
public class Q248_Strobogrammatic_Number_III {
	// by Jackie using DFS
	
	private char[] array1 = {'0', '1', '6', '8', '9'};
    private char[] array2 = {'0', '1', '9', '8', '6'};
    private char[] array3 = {'0', '1', '8'};
    private int count = 0;
    
    public int strobogrammaticInRange(String low, String high) {
        for(int i = low.length(); i <= high.length(); i++){
            DFS("", i, low, high);
        }
        
        return count;
    }
    
    public void DFS(String solution, int n, String low, String high){
        if(solution.length() == n){
            if(n > 1 && solution.charAt(0) == '0'){
                return;
            } 
            
            if((solution.length() == low.length() && solution.compareTo(low) < 0) || 
         		   (solution.length() == high.length() && solution.compareTo(high) > 0)) {
            	return;
            }
            
            count++;
            return;
        } 
        
        if(solution.length() == 0 && n % 2 == 1){
            for(char c : array3){
                DFS(solution + c, n, low, high);
            }
        } else {
            for(int i = 0; i < array1.length; i++){
                DFS(array1[i] + solution + array2[i], n, low, high);
            }
        }
    }
    
    
    public static void main(String[] args){
    	Q248_Strobogrammatic_Number_III t = new Q248_Strobogrammatic_Number_III();
    	
    	System.out.println(t.strobogrammaticInRange("50", "100"));
    }
}
