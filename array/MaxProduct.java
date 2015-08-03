
public class MaxProduct {
	public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i] * max;
            int b = nums[i] * min;
            
            max = Math.max(Math.max(a, b), nums[i]);
            min = Math.min(Math.min(a, b), nums[i]);
            
            if (max > res) {
                res = max;
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {-4, -3, -2};
		System.out.println(maxProduct(nums));
	}
}
