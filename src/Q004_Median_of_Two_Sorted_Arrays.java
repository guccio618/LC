
public class Q004_Median_of_Two_Sorted_Arrays {
	/**************************************************************************
	 There are two sorted arrays nums1 and nums2 of size m and n respectively. 
	 Find the median of the two sorted arrays. 
	 The overall run time complexity should be O(log (m+n)).
	 **************************************************************************/
	
	//by ninechapter
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        if(len % 2 == 1)
            return findKth(nums1, 0, nums2, 0, len/2 + 1);
        else
            return (findKth(nums1, 0, nums2, 0, len/2) + findKth(nums1, 0, nums2, 0, len/2 + 1)) / 2.0;
    }
	
    //相当于转化成查找A和B数组里第k小的数
	//find the Kth smallest value in the array nums1 and array nums2;
    public int findKth(int[] a, int a_start, int[] b, int b_start, int k){
        if(a_start >= a.length)
            return b[b_start + k - 1];
        if(b_start >= b.length)
            return a[a_start + k - 1];
        if(k == 1)
            return Math.min(a[a_start], b[b_start]);
        
        int a_key = (a_start + k/2 - 1 < a.length) ? a[a_start + k/2 - 1] : Integer.MAX_VALUE;
        int b_key = (b_start + k/2 - 1 < b.length) ? b[b_start + k/2 - 1] : Integer.MAX_VALUE;
        
      //首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，
      //这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。
      //如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
        if(a_key < b_key){  
            return findKth(a, a_start + k/2, b, b_start, k - k/2); //A[k/2] < B[k/2],因此A[]往k/2后找，B[]往k/2前找
        }
        else{
            return findKth(a, a_start, b, b_start + k/2, k - k/2); //A[k/2] >= B[k/2],因此A[]往k/2前找，B[]往k/2后找
        }
    }
}
