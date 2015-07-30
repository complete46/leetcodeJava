
public class SearchInsert {
	public static int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        return i;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		int[] nums2 = {1};
		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 7));
		System.out.println(searchInsert(nums, 0));
		System.out.println(searchInsert(nums2, 0));
		System.out.println(searchInsert(nums2, 2));
	}
}
