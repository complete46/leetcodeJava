import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
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
            item.add(candidates[i]);
            dfs(res, item, candidates, remain - candidates[i], i);
            item.remove(item.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {8, 7, 4, 3};
    	List<List<Integer>> res = combinationSum(nums, 7);
    	for (List<Integer> item : res) {
    		for (int i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}
