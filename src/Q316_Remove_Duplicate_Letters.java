import java.util.HashSet;
import java.util.Stack;


public class Q316_Remove_Duplicate_Letters {
	// by other
	public String removeDuplicateLetters(String s) { 
        /**
         * First loop: use an array cnt[] to count the number of times appeared for each letter in s.
         * 
         * Second loop (Greedy): use a stack, pop() 
         * while (!stack.isEmpty() && (sc = stack.peek()) >= c && cnt[sc] > 0)
         */

        int i, n = s.length();
        int[] cnt = new int[128];
        boolean[] inRes = new boolean[128]; // whether a char is in res[]
        char[] res = s.toCharArray(); // simulate a stack

        for (i = 0; i < n; i++)
            cnt[res[i]]++;

        char c, sc;
        int end = -1;
        // now cnt[c] means the remaining count of the char c
        for (i = 0; i < n; i++) {
            c = res[i];
            if (inRes[c]) {
                cnt[c]--;
                continue;
            }
            // sc >= c表示当前的c的顺序比res里的最后一个sc小，需要置换；cnt[sc]>0 表示sc在str后边还会出现
            while (end >= 0 && (sc = res[end]) >= c && cnt[sc] > 0) { 
                end--;               // res里的顺序前移一位
                inRes[sc] = false;   // 设置sc为未被访问过
            }

            res[++end] = c;
            cnt[c]--;
            inRes[c] = true;
        }
        return String.valueOf(res).substring(0, end + 1);  // string.valueof(): 将res转化为字符串
    }	
	
	
	
	
	
	public static void main(String[] args){
		Q316_Remove_Duplicate_Letters t = new Q316_Remove_Duplicate_Letters();
		System.out.println(t.removeDuplicateLetters("cbacdcbc"));	
	}
}
