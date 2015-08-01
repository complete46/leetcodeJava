
public class FindMin {
	public static int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        int res = 0;
        
        while (i <= j) {
            if (nums[i] <= nums[j]) {
                res = nums[i];
                break;
            }
            
            int mid = (i + j) / 2;
            if (nums[i] <= nums[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        
        return res;    
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 2};
		System.out.println(findMin(nums));
	}
}
