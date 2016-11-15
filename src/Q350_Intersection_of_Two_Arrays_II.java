import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q350_Intersection_of_Two_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        List<Integer> list = new ArrayList<>();
        
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] < nums2[index2]){
                index1++;
            } else if(nums1[index1] > nums2[index2]){
                index2++;
            } else {
                list.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        
        for(int num : list){
            ans[index++] = num;
        }
        
        return ans;
    }
	
	
	
	public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int n : nums1){
            if(!map1.containsKey(n)){
                map1.put(n, 1);
            } else {
                map1.put(n, map1.get(n) + 1);
            }
        }
        
        for(int n : nums2){
            if(!map2.containsKey(n)){
                map2.put(n, 1);
            } else {
                map2.put(n, map2.get(n) + 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            int num = entry.getKey();
            if(map2.containsKey(num)){
                int count = Math.min(map1.get(num), map2.get(num));
                for(int i = 0; i < count; i++){
                    list.add(num);
                }
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        for(int n : list){
            ans[index++] = n;
        }
        return ans;
    }
}
