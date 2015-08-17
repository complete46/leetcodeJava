package tree;
import java.util.List;
import java.util.ArrayList;

public class NumTreesII {

	public List<TreeNode> generateTrees(int n) {
		return generate(1, n);
	}

	public List<TreeNode> generate(int i, int j) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (i > j) {
			res.add(null);
			return res;
		}

		for (int k = i; k <= j; k++) {
			List<TreeNode> left = generate(i, k - 1);
			List<TreeNode> right = generate(k + 1, j);

			for (int l = 0; l < left.size(); l++) {
				for (int r = 0; r < right.size(); r++) {
					TreeNode root = new TreeNode(k);
					root.left = left.get(l);
					root.right = right.get(r);
					res.add(root);
				}
			}
		}

		return res;
	}
}
