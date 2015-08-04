
public class ProductExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
        int l = nums.length;

        int[] res = new int[l];
        
        res[0] = 1;

        
        for (int i = 1; i < l; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        for (int i = l - 1, t = 1; i >= 0; i--) {
            res[i] = res[i]  * t;
            t = t * nums[i];
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] res = productExceptSelf(new int[]{1, 2, 3, 4, 5});
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(" " + res[i]);
		}
	}
}
