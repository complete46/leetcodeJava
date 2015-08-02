
public class RemoveDuplicatesII {
	public int removeDuplicates(int[] nums) {
        int res = nums.length;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] == nums[i - 2]) {
                for (int j = i - 1; j < nums.length -1; j++) {
                    nums[j] = nums[j + 1];
                }
                res--;
            }
        }
        
        return res;
    }
}
