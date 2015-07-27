
public class SearchRange {
	public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                int k = mid;
                while (k < nums.length && nums[k] == target) {
                    k++;
                }
                res[1] = k - 1;
                k = mid;
                while (k >= 0 && nums[k] == target) {
                    k--;
                }
                res[0] = k + 1;
                return res;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 4};
		int[] res = searchRange(nums, 4);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
