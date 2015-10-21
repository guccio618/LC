import java.util.ArrayList;


public class Q228_Summary_Ranges {
	//by jackie
	public ArrayList<String> summaryRanges(int[] nums) {
		ArrayList<String> res = new ArrayList<String>();
        int n = nums.length;
        int front = 0, back = 0;
        for(int i = 0; i < n; i++){
            if(i < n-1 && nums[i+1] - nums[i] == 1){  //注意当处理数组最后一个元素时，
                front = i;                            //如果连续，则在此步内就会停止
                while(i < n-1 && nums[i+1] - nums[i] == 1)
                    i++;
                back = i;                             
                res.add(Integer.toString(nums[front]) + "->" + Integer.toString(nums[back]));
            }
            else{
            	res.add(Integer.toString(nums[i]));
            }
        }
        return res;
    }

	
	public static void main(String[] args){
		Q228_Summary_Ranges test = new Q228_Summary_Ranges();
		int[] array = {-2147483648,-2147483647,2147483647};
		 ArrayList<String> list = test.summaryRanges(array);
		 for(int i = 0; i < list.size(); i++)
			 System.out.print(list.get(i) + ", ");
		 System.out.println();
	}
}
