import java.util.Arrays;

public class ThreeSumCloset {
	public static int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == target) {
					return target;
				}
				if (Math.abs(res - target) > Math.abs(nums[i] + nums[l]
						+ nums[r] - target)) {
					res = nums[i] + nums[l] + nums[r];
				}

				if (nums[i] + nums[l] + nums[r] > target) {
					r--;
				} else {
					l++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -3, -2, -5, 3, -4 };
		System.out.println(threeSumClosest(nums, -1));
	}
}
