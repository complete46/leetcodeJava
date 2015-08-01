
public class SortColors {
	public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
        
        return;
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1};
		sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
