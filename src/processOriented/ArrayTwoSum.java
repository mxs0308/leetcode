package processOriented;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTwoSum {

	public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();//存放各位置的数字
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];//取补集
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	//Test
	public static void main(String[] args) {
		int nums[]= new int[] {2,7,11,15};
		int target=9;
		ArrayTwoSum test = new ArrayTwoSum();
		System.out.println(Arrays.toString(test.twoSum(nums, target)));
	}
}
