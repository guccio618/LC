
public class Q075_Sort_Colors {
	// by Jackie using quickSort, a little bit slow;
	public void sortColors(int[] nums) {
        Quicksort(nums, 0, nums.length-1);
    }
    
    public void Quicksort(int[] x, int left, int right){   
		if(left >= right) return;                          
		int i = left, j = right;
		double pivot = (x[left]+x[right])/2.0;  
		while(i < j){
			while(x[i] < pivot && i < right) i++;  
			while(x[j] >= pivot && j > left) j--; 
			if(i < j){
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
			}
		}
		if(j > left)                         
			Quicksort(x, left, j);
		if(right > j+1)
			Quicksort(x, j+1, right);		
	}
    
    // by other
	public void sortColors2(int[] nums) {
		int[] buckets = new int[3];
		for (int i : nums) {
			buckets[i]++;
		}
		int idx = 0;
		while (buckets[0]-- > 0)
			nums[idx++] = 0;
		while (buckets[1]-- > 0)
			nums[idx++] = 1;
		while (buckets[2]-- > 0)
			nums[idx++] = 2;
	}
	
	
	
	public static void main(String[] args){
		Q075_Sort_Colors t = new Q075_Sort_Colors();
		int[] array = {2,1,0,2,0,1,1,2,1,0,2};
		t.sortColors(array);
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
			
	}
}
