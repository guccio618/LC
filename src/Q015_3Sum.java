import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Q015_3Sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> templist = new ArrayList<Integer>();
		if (nums.length == 0) return res;
		int front = 0, back = 0;
		Arrays.sort(nums);	

		for (int i = 0; i < nums.length; i++) {
			int target = -nums[i];
			front = i + 1;
			back = nums.length - 1;
			while (front < back) {
				int sum = nums[front] + nums[back];
				if (sum > target) back--;
				else if (sum < target) front++;
				else {
					templist.clear();
					int num_1 = nums[front], num_2 = nums[back];
					templist.add(nums[i]);
					templist.add(nums[front]);
					templist.add(nums[back]);
					res.add(new ArrayList(templist));
					while (front < back && num_1 == nums[front]) front++;
					while (front < back && num_2 == nums[back]) back--;
				}
			}
			while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
		}
		return res;
	}
	
	public static void main(String[] args){
		Q015_3Sum s = new Q015_3Sum();
		int[] array = {-2,0,1,1,2};
		ArrayList<ArrayList<Integer>> res = s.threeSum(array);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}
