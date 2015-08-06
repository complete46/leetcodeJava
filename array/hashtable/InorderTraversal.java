package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		inorder(res, root);
		return res;
	}

	public void inorder(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null) {
			s.push(root);
			root = root.left;
		}

		while (!s.isEmpty()) {
			root = s.pop();
			res.add(root.val);
			if (root.right != null) {
				root = root.right;
				while (root != null) {
					s.push(root);
					root = root.left;
				}
			}
		}

		return;
	}
}
