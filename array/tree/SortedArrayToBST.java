package tree;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return con(nums, 0, nums.length - 1);
    }
    
    public TreeNode con(int[] nums, int i, int j) {
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        
        if (i > j) {
            return null;
        }
        
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = con(nums, i, mid - 1);
        root.right = con(nums, mid + 1, j);
        return root;
    }
}
