
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        int c = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                c--;
            }
        }
        return c;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		int t = removeElement(nums, 2);
		for (int i = 0; i < t; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
