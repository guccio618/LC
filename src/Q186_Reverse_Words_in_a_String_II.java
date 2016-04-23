
public class Q186_Reverse_Words_in_a_String_II {
	public void reverseWords(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        
        int n = s.length;
        reverse(s, 0, n - 1);
        int index = 0;
        
        while(index < n){
            if(s[index] != ' '){
                int front = index;
                while(front < n && s[front] != ' '){
                    front++;
                }
                reverse(s, index, front - 1);
                index = front;
            } else {
                index++;
            }
        }
    }
    
    public void reverse(char[] s, int start, int end){
        if(start == end){
            return;
        }
        
        int left = start, right = end;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    
    
    
    public static void main(String[] str){
    	Q186_Reverse_Words_in_a_String_II t = new Q186_Reverse_Words_in_a_String_II();
    	String s = "a, yqo! qjktum ym. .fumuhau";
    	char[] array = s.toCharArray();
    	t.reverseWords(array);
    	
    	for(int i = 0; i < array.length; i++){
    		System.out.print(array[i]);
    	}
    	System.out.println();
    }
}
