
public class SearchInRotatedArray {
	public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (target < nums[j]) {
                if (nums[mid] > target && nums[mid] < nums[j]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (target > nums[j]) {
                if (nums[mid] < target && nums[mid] > nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                return j;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 1, 2, 3};
		int target = 1;
		System.out.println(search(nums, target));
	}
}
