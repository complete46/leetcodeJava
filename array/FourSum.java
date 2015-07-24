import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			threeSum(nums, target - nums[i], i, res);
			while (nums[i] == nums[i + 1] && i < nums.length - 3) {
			    i++;
			}
		}

		return res;

	}

	public static void threeSum(int[] nums, int target, int s, List<List<Integer>> res) {
		if (nums.length - s < 3) {
			return;
		}

		for (int i = s + 1; i < nums.length - 2; i++) {
			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == target) {
					List<Integer> item = new ArrayList<Integer>();
					item.add(nums[s]);
					item.add(nums[i]);
					item.add(nums[l]);
					item.add(nums[r]);
					res.add(item);
					l++;
					r--;

					while (r > l && nums[r] == nums[r + 1]) {
						r--;
					}

					while (r > l && nums[l] == nums[l - 1]) {
						l++;
					}
				} else if (nums[i] + nums[l] + nums[r] > target) {
					r--;
					while (r > l && nums[r] == nums[r + 1]) {
						r--;
					}
				} else {
					l++;
					while (r > l && nums[l] == nums[l - 1]) {
						l++;
					}
				}
			}

			while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 1, 0, -1};
		List<List<Integer>> res = fourSum(nums, 2);
		for (int i = 0; i < res.size(); i++) {
			for (int j : res.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
