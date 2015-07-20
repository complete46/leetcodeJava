import java.util.HashMap;


public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i + 1);
            } else {
                res[0] = map.get(nums[i]);
                res[1] = i + 1;
                break;
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int[] res = twoSum(nums, 6);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
