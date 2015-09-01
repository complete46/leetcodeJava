package tree;

public class UpsideDownBinaryTree {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;
        
        while (cur != null) {
            next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}
