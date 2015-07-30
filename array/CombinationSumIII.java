import java.util.List;
import java.util.ArrayList;

public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, new ArrayList<Integer>(), 1, k, 0, n);
		return res;
	}

	public static void dfs(List<List<Integer>> res, List<Integer> item, int start,
			int k, int step, int remain) {
		if (step == k && remain == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		if (step == k) {
			return;
		}
		for (int i = start; i < 10; i++) {
			item.add(i);
			dfs(res, item, i + 1, k, step + 1, remain - i);
			item.remove(item.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum3(3, 9);
		for (List<Integer> item : res) {
			for (int i : item) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
