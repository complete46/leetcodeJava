
public class TrappingRainWater {
	public static int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int minHeight = 0;
        int res = 0;
        
        while (l < r) {
            while (l < r && height[l] <= minHeight) {
                res += minHeight - height[l++];
            }
            while (l < r && height[r] <= minHeight) {
                res += minHeight - height[r--];
            }
            
            minHeight = Math.min(height[l], height[r]);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
