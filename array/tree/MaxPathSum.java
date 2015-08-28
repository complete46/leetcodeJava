package tree;

public class MaxPathSum {
	public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        
        return max[0];
    }
    
    public int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        
        int path = Math.max(root.val + Math.max(left, right), root.val);
        
        int crossover = left + right + root.val;
        
        max[0] = Math.max(max[0], Math.max(path, crossover));
        
        return path;
    }
}
