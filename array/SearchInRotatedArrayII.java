
public class SearchInRotatedArrayII {
	public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[mid] < nums[i]) {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] > nums[i]) {
                if (nums[mid] > target && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                i++;
            }
        }
        
        return false;
    }
}
