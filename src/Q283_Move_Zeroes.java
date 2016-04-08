
public class Q283_Move_Zeroes {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        
        int back = 0, front = 0;
        int n = nums.length;
        
        while(front < n && nums[front] != 0){
            front++;
        }
        
        back = front;
        
        while(front < n){
            if(nums[front] != 0){
                nums[back++] = nums[front++];
            } else {
                front++;
            }
        }
        
        while(back < n){
            nums[back++] = 0;
        }
    }
	
	public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n-count; ){
            if(nums[i] == 0){               
                for(int j = i; j < n-count-1; j++)
                    nums[j] = nums[j+1];
                nums[n-count-1] = 0;
                count++;
            }
            if(nums[i] != 0) i++;
        }
    }
	
	public static void main(String[] args){
		Q283_Move_Zeroes test = new Q283_Move_Zeroes();
		int[] array = {1, 0, 0};
		test.moveZeroes(array);
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
}
