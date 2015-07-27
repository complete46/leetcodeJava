import java.util.HashMap;


public class MajorityElement {
	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length / 2;
        int i = 0;
        for (; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            if (map.get(nums[i]) + 1 > n) {
                break;
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        return nums[i];
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 2};
		System.out.println(majorityElement(nums));
	}
}
