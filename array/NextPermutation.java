import java.util.Arrays;


public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        
        
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        
        int j = i;
        while (j + 1 < nums.length && nums[j + 1] > nums[i - 1]) {
            j++;
        }
        int t = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = t;
        
        Arrays.sort(nums, i, nums.length);
        return;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 2};
		nextPermutation(nums);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
