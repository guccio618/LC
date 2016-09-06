public class Q394_Decode_String {
	
//	s = "3[a]2[bc]", return "aaabcbc".
//	s = "3[a2[c]]", return "accaccacc".
//	s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	
	public String decodeString(String s) {
        if(s == null || s.length() == 0){
        	return "";
        } else if(s.indexOf("[", 0) < 0){
			return s;
		}

		int startIndex = 0;
		StringBuilder builder = new StringBuilder();
				
		while(startIndex < s.length()){
			int numberStart = startIndex;
			startIndex = s.indexOf("[", startIndex);
			
			if(startIndex < 0){
				builder.append(s.substring(numberStart));
				break;
			} 
			
			while(!Character.isDigit(s.charAt(numberStart))){
				builder.append(s.charAt(numberStart));
				numberStart++;
			}
			
			int nextTime = 1;
			
			if(Character.isDigit(s.charAt(startIndex - 1))){
				nextTime = Integer.parseInt(s.substring(numberStart, startIndex));	
			}
			
			int count = 0;
			int endIndex = startIndex;
			
			while(endIndex < s.length()){
				char c = s.charAt(endIndex);
				
				if(c == '['){
					count++;
				} else if(c == ']'){
					count--;
				}
				
				if(count == 0){
					break;
				}
				
				endIndex++;
			}
			
			StringBuilder subBuilder = new StringBuilder();
			String subStr = decodeString(s.substring(startIndex + 1, endIndex));
			
			for(int i = 0; i < nextTime; i++){
				subBuilder.append(subStr);
			}
			
			builder.append(subBuilder);
			startIndex = endIndex + 1;
		}
		
        return builder.toString();
    }
	
	
	
	public static void main(String[] args){
		Q394_Decode_String t = new Q394_Decode_String();
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "ef2[abc]3[cd]ef";
		String s4 = "";
		System.out.println(t.decodeString(s3));
	}
}
