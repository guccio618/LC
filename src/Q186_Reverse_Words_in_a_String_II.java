
public class Q186_Reverse_Words_in_a_String_II {
	public void reverseWords(char[] s) {
        if(s == null || s.length <= 1){
            return;
        }
        
        int len = s.length;
        reverseStr(s, 0, len - 1);
        int front = 0, back = 0;
        
        while(front < len){
            if(s[front] == ' '){
                front++;
                back++;
            } else {
                while(front < len && s[front] != ' '){
                    front++;
                }
                reverseStr(s, back, front - 1);
                back = front;
            }
        }
    }
    
    public void reverseStr(char[] s, int start, int end){
        char temp = ' ';
        
        while(start < end){
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
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
