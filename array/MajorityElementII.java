import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        int bar = nums.length / 3 + 1;
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            
            if (map.get(nums[i]) + 1 == bar) {
                res.add(nums[i]);
            }
            
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        return res;
    }
}
