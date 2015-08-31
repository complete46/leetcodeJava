package tree;

public class RecoveryBinaryTree {
	TreeNode first;
    TreeNode second;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        pre = new TreeNode(Integer.MIN_VALUE);
        
        inorder(root);
        
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        
        if (first == null && pre.val > root.val) {
            first = pre;
        }
        
        if (first != null && pre.val > root.val) {
            second = root;
        }
        
        pre = root;
        
        inorder(root.right);
    }
}
