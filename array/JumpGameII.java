
public class JumpGameII {
	public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int reach = 0;
        int lastReach = 0;
        int step = 0;
        
        for (int i = 0; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            
            reach = Math.max(reach, i + nums[i]);
        }
        
        if (reach < nums.length - 1) {
            return 0;
        }
        
        return step;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}
}
