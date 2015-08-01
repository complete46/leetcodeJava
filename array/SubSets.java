import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> item = new ArrayList<Integer>(res.get(j));
                item.add(nums[i]);
                res.add(item);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3};
    	List<List<Integer>> res = subsets(nums);
    	for (List<Integer> item : res) {
    		for (int i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}
