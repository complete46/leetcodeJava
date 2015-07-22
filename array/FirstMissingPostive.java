
public class FirstMissingPostive {
	public static int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
				int t = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = t;
				i--;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		
		return nums.length + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, -1, 0, 5};
		firstMissingPositive(nums);
	}
}
