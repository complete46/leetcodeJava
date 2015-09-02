import java.util.Arrays;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] >= target) {
                break;
            }
            
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                while (l < r && nums[i] + nums[l] + nums[r] >= target) {
                    r--;
                }
                
                res += (r - l);
                l++;
            }
        }
        
        return res;
    }
}
