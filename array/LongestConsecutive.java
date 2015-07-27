import java.util.HashMap;


public class LongestConsecutive {
	public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, i + 1);
        }
        int res = 0;
        for (int i : nums) {
            if (!map.containsKey(i - 1)) {
                int cur = 1;
                int k = i;
                while (map.containsKey(map.get(k))) {
                    cur++;
                    k = map.get(k);
                }
                res = Math.max(res, cur);
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));
	}
}
