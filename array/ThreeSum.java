import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> item = new ArrayList<Integer>();
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
                } else if (nums[i] + nums[l] + nums[r] > 0) {
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
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	int[] nums2 = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
    	List<List<Integer>> res = threeSum(nums2);
    	for (List<Integer> item : res) {
    		for (int i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.print('\n');
    	}
    }
}
