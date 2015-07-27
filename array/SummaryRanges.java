import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		if (nums.length == 1) {
			String item = Integer.toString(nums[0]);
			res.add(item);
			return res;
		}

		int diff = nums[0];
		int start = nums[0];
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] - i != diff) {
				String item;
				if (nums[i - 1] == start) {
					item = Integer.toString(start);
				} else {
					item = start + "->" + nums[i - 1];
				}
				res.add(item);
				start = nums[i];
				if (i != nums.length - 1) {
					diff = nums[i] - i;
				}
			}
		}
		if (nums[i - 1] - i + 1 != diff) {
			String item = Integer.toString(nums[i - 1]);
			res.add(item);
		} else {
			String item = start + "->" + nums[i - 1];
			res.add(item);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0 , 1, 2, 4, 5, 7 };
		List<String> res = summaryRanges(nums);
		for (String s : res) {
			System.out.println(s);
		}
	}
}
