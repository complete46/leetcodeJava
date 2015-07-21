
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = nums.length;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                res--;
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println(removeDuplicates(nums));
		
		for (int i = 0; i < 2; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
