package backtracking;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PermuteUnique {
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, used, 0);
        
        return res;
    }
    
    public static void dfs(List<List<Integer>> res, List<Integer> item, int[] nums, boolean[] used, int step) {
        if (step == nums.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        		continue;
        	}
            if (!used[i]) {
                item.add(nums[i]);
                used[i] = true;
                dfs(res, item, nums, used, step + 1);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2, 1};
    	List<List<Integer>> res = permuteUnique(nums);
    	for (List<Integer> item : res) {
    		for (int i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	} 
    }
}
