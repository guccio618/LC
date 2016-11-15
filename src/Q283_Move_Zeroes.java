
public class Q283_Move_Zeroes {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int len = nums.length, front = 0, back = 0;
        
        while(front < len){
            if(nums[front] != 0){
                nums[back] = nums[front];
                back++;
            }
            
            front++;
        }
        
        while(back < len){
            nums[back] = 0;
            back++;
        }
    }
	
	public void moveZeroes2(int[] nums) {
		if(nums == null || nums.length == 0){
			return ;
		}
		
		int len = nums.length;
		int front = 0, back = 0;
		
		while(back < len && nums[back] != 0){
			back++;
		}
		
		front = back;
		
		while(front < len && nums[front] == 0){
			front++;
		}
		
		while(front < len){
			if(nums[front] != 0){
				nums[back++] = nums[front];
			}
			
			front++;
		}
		
		while(back < len){
			nums[back++] = 0;
		}
	}
	
	public void moveZeroes3(int[] nums) {
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
