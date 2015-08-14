package tree;

public class CountNodes {
	public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0) {
            return 0;
        }
        
        int hl = height(root.right);
        
        return hl == h - 1 ? ((1 << (h - 1)) + countNodes(root.right)) : ((1 << (h - 2)) + countNodes(root.left));
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + height(root.left);
    }
}
