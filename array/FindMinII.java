public class FindMinII {
	public int findMin(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			if (nums[i] < nums[j]) {
				return nums[i];
			}

			int m = (i + j) / 2;
			if (nums[i] > nums[m]) {
				j = m;
			} else if (nums[i] < nums[m]) {
				i = m + 1;
			} else {
				if (nums[i] == nums[j]) {
					i++;
					j--;
				} else {
					i = m + 1;
				}
			}
		}
		return nums[i];
	}
}
