import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    public static void dfs(List<List<Integer>> res, List<Integer> item, int[] candidates, int remain, int step) {
        if (remain == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if (remain < 0) {
        	return;
        }
        
        for (int i = step; i < candidates.length; i++) {
        	if (i > step && candidates[i] == candidates[i - 1]) {
        		continue;
        	}
            item.add(candidates[i]);
            dfs(res, item, candidates, remain - candidates[i], i + 1);
            item.remove(item.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {10,1,2,7,6,1, 5};
    	List<List<Integer>> res = combinationSum(nums, 8);
    	for (List<Integer> item : res) {
    		for (int i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}
