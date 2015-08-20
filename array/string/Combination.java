package string;
import java.util.List;
import java.util.ArrayList;


public class Combination {
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        dfs(res, new ArrayList<Integer>(), n, k, 1);
        
        return res;
    }
    
    public static void dfs (List<List<Integer>> res, List<Integer> item, int n, int k, int pos) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = pos; i <= n; i++) {
            item.add(i);
            dfs(res, item, n, k, i + 1);
            item.remove(item.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> res = combine(10, 7);
    	for (List<Integer> item : res) {
    		for (int i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.print("\n");
    	}
    }
}
