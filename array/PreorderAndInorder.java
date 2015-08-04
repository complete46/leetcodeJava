
public class PreorderAndInorder {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[ps]);
        
        int mark = is;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) {
                mark = i;
                break;
            }
        }
        
        root.left = build(preorder, inorder, ps + 1, ps + mark - is, is, mark - 1);
        root.right = build(preorder, inorder, ps + mark - is + 1, pe, mark + 1, ie);
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
