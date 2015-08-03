
public class MinSubArrayLen {
	public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int len = nums.length + 1;
        int sum = 0;
        
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= s) {
                while (i <= j && sum >= s) {
                    sum -= nums[i];
                    i++;
                }
                i--;
                sum += nums[i];
                len = Math.min(len, j - i + 1);
            }
        }
        
        if (len == nums.length + 1) {
            return 0;
        }
        return len;
    }
}
