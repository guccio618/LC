
public class Q318_Maximum_Product_of_Word_Lengths {
	/********************************************************************/
	// by other using Bit Manipulation， nice
	public int maxProduct(String[] words) {
        int[] checker = new int[words.length];
        int max = 0;
        // populating the checker array with their respective numbers
        for (int i = 0; i < checker.length; i++) {
            int num = 0;
            for (int j = 0; j < words[i].length(); j++) {
                num |= 1 << (words[i].charAt(j) - 'a');   // 标记上0-26中的某一个字母出现过
            }
            checker[i] = num;
        }

        for (int i = 0, len = words.length; i < len-1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((checker[i] & checker[j]) == 0) // checking if the two strings have common character
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }  
        return max;
    }
	
	public static void main(String[] args){
		Q318_Maximum_Product_of_Word_Lengths t = new Q318_Maximum_Product_of_Word_Lengths();
		String[] words = {"abc", "cd", "efg"};
		t.maxProduct(words);
	}
}
