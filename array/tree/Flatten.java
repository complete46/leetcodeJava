package tree;
import java.util.Stack;


public class Flatten {
	public void flatten(TreeNode root) {
        if (root == null) return;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur.right != null) {
                s.push(cur.right);
            }
            
            if (cur.left != null) {
                s.push(cur.left);
            }
            
            if (!s.isEmpty()) {
                cur.right = s.peek();
            }
            
            cur.left = null;
        }
    }
}
