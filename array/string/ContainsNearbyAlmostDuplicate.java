package string;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer f = set.floor(nums[i] + t);
            Integer c = set.ceiling(nums[i] - t);
            
            if ((f != null && f >= nums[i]) || (c != null && c <= nums[i])) return true;
            
            set.add(nums[i]);
            
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}
