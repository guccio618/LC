
public class Q088_Merge_Sorted_Array {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null){
            return;
        }
        
        int index = m + n - 1;
        int index1 = m - 1, index2 = n - 1;
        
        while(index1 >= 0 || index2 >= 0){
            if(index1 >= 0 && index2 >= 0){
                if(nums1[index1] > nums2[index2]){
                    nums1[index--] = nums1[index1--];
                } else {
                    nums1[index--] = nums2[index2--];
                }
            } else if(index1 >= 0 && index2 < 0){
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
    }
}
