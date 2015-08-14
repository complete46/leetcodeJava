package tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PreorderTravesal {
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while (root != null) {
            res.add(root.val);
            s.push(root);
            root = root.left;
        }
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    res.add(cur.val);
                    s.push(cur);
                    cur = cur.left;
                }
            }
        }
        
        return res;
    }
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		while (root != null) {
			s.push(root);
			root = root.left;
		}
		
		while (!s.isEmpty()) {
			TreeNode cur = s.pop();
			res.add(cur.val);
			
			if (cur.right != null) {
				cur = cur.right;
				while (cur != null) {
					s.push(cur);
					cur = cur.left;
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<Integer> res1 = preorderTraversal(root);
		List<Integer> res2 = inorderTraversal(root);
		
		for (int i : res1) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : res2) {
			System.out.print(i + " ");
		}

	}
}
