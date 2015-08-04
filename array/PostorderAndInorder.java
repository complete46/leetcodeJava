public class PostorderAndInorder {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = build(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return root;
    }
    
    public TreeNode build(int[] postorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pe]);
        
        int mark = is;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == postorder[pe]) {
                mark = i;
                break;
            }
        }
        
        root.left = build(postorder, inorder, ps, ps + mark - is - 1, is, mark - 1);
        root.right = build(postorder, inorder, ps + mark - is, pe - 1, mark + 1, ie);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
