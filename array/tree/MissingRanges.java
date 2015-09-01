package tree;

import java.util.List;
import java.util.ArrayList;

public class MissingRanges {
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                res.add(String.valueOf(lower));
            } else if (lower < upper) {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        
        for (int i = 0; i <= nums.length; i++) {
            int l = 0;
            int r = 0;
            if (i == 0) {
                l = lower;
                r = nums[i] - 1;
            } else if (i == nums.length) {
                l = nums[i - 1] + 1;
                r = upper;
            } else {
                l = nums[i - 1] + 1;
                r = nums[i] - 1;
            }
            
            if (l == r) {
                res.add(String.valueOf(l));
            } else if (l < r) {
                res.add(l + "->" + r);
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 99};
		System.out.println(findMissingRanges(nums, 0, 99));
	}
}
