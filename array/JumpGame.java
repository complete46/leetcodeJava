

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int reach = 0;
        
        for (int i = 0; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
        }
        
        if (reach < nums.length - 1) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(canJump(new int[]{2,3,1,1,4}));
    	System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
