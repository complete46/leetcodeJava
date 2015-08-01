public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			int m = (i + j) / 2;

			if (nums[m] < nums[m + 1]) {
				i = m + 1;
			} else {
				j = m;
			}
		}
		return i;
	}
}
