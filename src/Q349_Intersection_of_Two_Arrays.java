import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Q349_Intersection_of_Two_Arrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        for(int n : nums1){
            set1.add(n);
        }
        
        for(int n : nums2){
            if(set1.contains(n)){
                set2.add(n);
            }
        }
        
        int[] ans = new int[set2.size()];
        int index = 0;
        
        for(int n : set2){
            ans[index++] = n;
        }
        
        return ans;
    }
}
