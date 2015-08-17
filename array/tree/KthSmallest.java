package tree;
import java.util.Stack;
public class KthSmallest {
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        int[] res = new int[k];
        int i = 0;
        
        TreeNode cur = root;
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            res[i++] = t.val;
            if (i == k) break;
            if (t.right != null) {
                t = t.right;
                while (t != null) {
                    s.push(t);
                    t = t.left;
                }
            }
        }
        
        return res[k - 1];
    }
}
