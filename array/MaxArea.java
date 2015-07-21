
public class MaxArea {
	public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int area = 0;
        while (i < j) {
            int areaT = Math.min(height[i], height[j]) * (j - i);
            area = Math.max(area, areaT);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        
        return area;
    }
	
	public static void main(String[] args) {
		int[] height = {2, 4, 3, 1, 6, 5};
		System.out.println(maxArea(height));
	}
}
